package learningTools.QA;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


import io.appium.java_client.AppiumBy;

public class signInTests extends LearningToolsTestBase {
	private final By homeChooseSubject = AppiumBy.id("com.varsitytutors.learningtools:id/choose_subject");
	private WebElement waitFor(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	private void OpenApp() {
		WebElement el = waitFor(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/text1\")"));
		String txt = el.getText();
		System.out.println("Text is: " + txt);
		el.click();
		waitFor(AppiumBy.xpath(
				"//android.widget.TextView[@resource-id=\"com.varsitytutors.learningtools:id/drawer_label\" and @text=\"My Profile\"]"))
				.click();
		waitFor(AppiumBy.id("com.varsitytutors.learningtools:id/button_sign_in_other")).click();
		
		
	}
	  // LOGIN-009: Successful login
	@Test(enabled = false)
	//email=himadoov@gmail.com pass=00000000
	public void sihhhh() {
		OpenApp();
		waitFor(AppiumBy.id("com.varsitytutors.learningtools:id/email")).clear();
		waitFor(AppiumBy.id("com.varsitytutors.learningtools:id/email")).sendKeys("himadoov@gmail.com");
		waitFor(AppiumBy.id("com.varsitytutors.learningtools:id/password")).clear();
		waitFor(AppiumBy.id("com.varsitytutors.learningtools:id/password")).sendKeys("00000000");
		waitFor(AppiumBy.id("com.varsitytutors.learningtools:id/sign_in_button")).click();
		waitFor(AppiumBy.androidUIAutomator("new UiSelector().description(\"Learning\")")).click();

		waitFor(AppiumBy.xpath(
				"//android.widget.TextView[@resource-id=\"com.varsitytutors.learningtools:id/drawer_label\" and @text=\"My Profile\"]"))
				.click();
		waitFor(AppiumBy.id("com.varsitytutors.learningtools:id/button_sign_in_other")).click();

		
		}
	 // LOGIN-010: Incorrect password
	  
	  @Test public void LOGIN_010_incorrectPassword() { 
		    OpenApp();
		    waitFor(AppiumBy.id("com.varsitytutors.learningtools:id/email")).clear();
			waitFor(AppiumBy.id("com.varsitytutors.learningtools:id/email")).sendKeys("himadoov@gmail.com");
			waitFor(AppiumBy.id("com.varsitytutors.learningtools:id/password")).clear();
			waitFor(AppiumBy.id("com.varsitytutors.learningtools:id/password")).sendKeys("0000000000");
			waitFor(AppiumBy.id("com.varsitytutors.learningtools:id/sign_in_button")).click();

	  
	  boolean onHome = driver.findElements(homeChooseSubject).size() > 0;
	   Assert.assertFalse(onHome, "User should NOT login with wrong password");
	  }
}
