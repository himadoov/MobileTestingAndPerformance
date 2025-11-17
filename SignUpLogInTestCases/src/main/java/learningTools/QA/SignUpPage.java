package learningTools.QA;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage {

    private AndroidDriver driver;

    // ===== Locators =====
    //private final WebElement firstNameId        = driver.findElement(AppiumBy.id("com.varsitytutors.learningtools:id/first_name"));
    private final String firstNameId        = "com.varsitytutors.learningtools:id/first_name";
    private final String lastNameId         = "com.varsitytutors.learningtools:id/last_name";
    private final String emailId            = "com.varsitytutors.learningtools:id/email";
    private final String passwordId         = "com.varsitytutors.learningtools:id/password";
    private final String termsCheckboxId    = "com.varsitytutors.learningtools:id/terms_agree";
    
    private final By createAccountButton =
            AppiumBy.id("com.varsitytutors.learningtools:id/register_button");


    // ===== Constructor =====
    public SignUpPage(AndroidDriver driver) {
        this.driver = driver;
    }

    // ===== Element getters =====
    private WebElement getFirstNameField() {
        return driver.findElement(AppiumBy.id(firstNameId));
    }

    private WebElement getLastNameField() {
        return driver.findElement(AppiumBy.id(lastNameId));
    }

    private WebElement getEmailField() {
        return driver.findElement(AppiumBy.id(emailId));
    }

    private WebElement getPasswordField() {
        return driver.findElement(AppiumBy.id(passwordId));
    }

    private WebElement getTermsCheckbox() {
        return driver.findElement(AppiumBy.id(termsCheckboxId));
    }

    

    

    // ===== Actions =====
    public void typeFirstName(String firstName) {
        getFirstNameField().clear();
        getFirstNameField().sendKeys(firstName);
    }

    public void typeLastName(String lastName) {
        getLastNameField().clear();
        getLastNameField().sendKeys(lastName);
    }

    public void typeEmail(String email) {
        getEmailField().clear();
        getEmailField().sendKeys(email);
    }

    public void typePassword(String password) {
        getPasswordField().clear();
        getPasswordField().sendKeys(password);
    }

    public void checkTerms() {
        WebElement checkbox = getTermsCheckbox();
        boolean isChecked = checkbox.getAttribute("checked").equalsIgnoreCase("true");
        if (!isChecked) {
            checkbox.click();
        
		}
    }

    public void tapCreateAccount() {
        waitFor(createAccountButton).click();
    }
    private WebElement waitFor(By locator) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

    

    // ===== High-level flow =====
    public void signUp(String firstName, String lastName, String email, String password,boolean checkTerms) {
        //driver.findElement(AppiumBy.id("com.varsitytutors.learningtools:id/first_name")).sendKeys(firstName);
        typeFirstName(firstName);
        typeLastName(lastName);
        typeEmail(email);
        typePassword(password);
        checkTerms();
        tapCreateAccount();
       
    }
    public void signUpFoeCheckBox(String firstName, String lastName, String email, String password) {
        typeFirstName(firstName);
        typeLastName(lastName);
        typeEmail(email);
        typePassword(password);
        
        
       
    }
    
    }

