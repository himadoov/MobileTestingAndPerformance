package learningTools.QA;

import io.appium.java_client.AppiumBy;
import jdk.jfr.Enabled;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AuthAndProfileTests extends LearningToolsTestBase {
	 

	// ---------- Helper: explicit wait ----------
	private WebElement waitFor(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	
	// Signup screen
	
	private final By linkSignupLogin = AppiumBy.id("com.varsitytutors.learningtools:id/sign_in_link");
	

	// Login screen (IDs مفترضة، عدّلها لو مختلفة عندك)
	
	

	// Home screen
	private final By homeChooseSubject = AppiumBy.id("com.varsitytutors.learningtools:id/choose_subject");

	
	// فوق، مع باقي الـ locators
	private final By registerDialogTitle   = AppiumBy.id("android:id/alertTitle");
	private final By registerDialogMessage = AppiumBy.id("com.varsitytutors.learningtools:id/wrap_text");
	private final By registerDialogClose   = AppiumBy.id("android:id/button1");
	


	
	 
	 

	
	private void OpenApp() {
		WebElement el = waitFor(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/text1\")"));
		String txt = el.getText();
		System.out.println("Text is: " + txt);
		el.click();
		waitFor(AppiumBy.xpath(
				"//android.widget.TextView[@resource-id=\"com.varsitytutors.learningtools:id/drawer_label\" and @text=\"My Profile\"]"))
				.click();
		waitFor(AppiumBy.id("com.varsitytutors.learningtools:id/button_sign_in_other")).click();
		waitFor(AppiumBy.androidUIAutomator(
				"new UiSelector().resourceId(\"com.varsitytutors.learningtools:id/register_link\")")).click();
	}


	// SIGNUP-001: Verify user can create an account with valid data

	@Test(enabled = true)
	public void SIGNUP_001_verifyUserCanCreateAccountWithValidData() {
		OpenApp();
		SignUpPage signUp = new SignUpPage(driver);
		String firstName = "ibrahhiiiiiiiiiiiiiiiiiiiiiiiiim";
		String lastName = "Hamoudaaaaa";
		String email = "user" + System.currentTimeMillis() + "@test.com";
		String password = "Test@1234";
		signUp.signUp(firstName, lastName, email, password,true);
		waitFor(AppiumBy.androidUIAutomator("new UiSelector().description(\"Learning\")")).click();
		System.out.println("5555555555");
		waitFor(AppiumBy.xpath(
				"//android.widget.TextView[@resource-id=\"com.varsitytutors.learningtools:id/drawer_label\" and @text=\"My Profile\"]"))
				.click();
		waitFor(AppiumBy.id("com.varsitytutors.learningtools:id/button_sign_in_other")).click();

		System.out.println("Sign up flow executed successfully.");

	}

	// SIGNUP-002: Verify all fields are mandatory
	@Test(enabled = true)
	public void SIGNUP_002_verifyAllFieldsMandatory() {
		waitFor(AppiumBy.androidUIAutomator(
				"new UiSelector().resourceId(\"com.varsitytutors.learningtools:id/register_link\")")).click();

	
		SignUpPage signUp = new SignUpPage(driver);
		signUp.signUp("", "", "", "",true);
		
		//waitFor(AppiumBy.accessibilityId("Learning")).click();
		WebElement titleEl = waitFor(registerDialogTitle);
	    Assert.assertEquals(titleEl.getText(), "Register", "Dialog title mismatch");
		 WebElement closeBtn = waitFor(registerDialogClose);
		    closeBtn.click();
	}

	// SIGNUP-003: Invalid email format
	
	  @Test(enabled = true)
	  public void SIGNUP_003_invalidEmailFormat() {
		  
		  SignUpPage signUp = new SignUpPage(driver);
			signUp.signUp("ibarhim", "emaf", "dasdfsdf", "addsdasdd",true);
			WebElement titleEl = waitFor(registerDialogTitle);
		    Assert.assertEquals(titleEl.getText(), "Register", "Dialog title mismatch");
		    WebElement EmailNotFound=waitFor(registerDialogMessage);
		    Assert.assertEquals(EmailNotFound.getText(), "Email is not valid.");
		    WebElement closeBtn = waitFor(registerDialogClose);
		    closeBtn.click();

	  
	  }
	  
	  // SIGNUP-004: Weak password validation
	 
	  @Test (enabled = true)
	  public void SIGNUP_004_weakPasswordValidation() {

		  SignUpPage signUp = new SignUpPage(driver);
	  signUp.signUp("ibarhim", "emaf", "ibarhim@gmail.com", "4152",true);
	  boolean onHome = driver.findElements(homeChooseSubject).size() > 0;
	  Assert.assertFalse(onHome,
	  "User should NOT be navigated to home with weak password");
	  WebElement closeBtn = waitFor(registerDialogClose);
	    closeBtn.click();
	  
	  }
	  
	  // SIGNUP-005: Terms checkbox required
	  
	  @Test(enabled = true)
	  
	  public void SIGNUP_005_termsCheckboxRequired() {
		 

		String email= "user" + System.currentTimeMillis() + "@test.com";
		SignUpPage signUpFoeCheckBox = new SignUpPage(driver);
		
		signUpFoeCheckBox.signUpFoeCheckBox("ibarhim", "emad", email, "sdsfdsfddd");
		waitFor(AppiumBy.id("com.varsitytutors.learningtools:id/terms_agree")).click();
		waitFor(AppiumBy.id("com.varsitytutors.learningtools:id/register_button")).click();
		WebElement closeBtn = waitFor(registerDialogClose);
		closeBtn.click();
	 
	    boolean onHome = driver.findElements(homeChooseSubject).size() > 0;
		  Assert.assertFalse(onHome,
		  "User should NOT be navigated to home without accepting terms");
	  }
	 
	  // SIGNUP-006: Existing email error
	  
	  @Test(enabled = true) 
	  
	  public void SIGNUP_006_existingEmailError() { 
		
		  String txt = "6f658d1662@anonymous-mobile-app-user.org";
		  SignUpPage signUp = new SignUpPage(driver);
		  signUp.signUp("ibarhim", "emaf",txt, "4gfsfsdfsd152",true);
	  
		  boolean onHome = driver.findElements(homeChooseSubject).size() > 0;
		  Assert.assertFalse(onHome,"User should NOT be navigated to home when email already exists");
				  WebElement closeBtn = waitFor(registerDialogClose);
				  closeBtn.click();
		
	  }
	 
	  // SIGNUP-007: Navigate signup to login
	  
	  @Test(enabled = true) 
	  public void SIGNUP_007_navigateSignupToLogin() {
		  waitFor(linkSignupLogin).click();
		 
	  }
}