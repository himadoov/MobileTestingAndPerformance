package learningTools.QA;

import io.appium.java_client.AppiumBy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class SignUpTest extends LearningToolsTestBase {
	private WebElement waitFor(By locator) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

    @Test
    public void testUserCanSignUp() {
    	
    	WebElement el=waitFor(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/text1\")"));
    	String txt = el.getText();
    	System.out.println("Text is: " + txt);
    	el.click();
        System.out.println("t11111111");
        
        waitFor(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.varsitytutors.learningtools:id/drawer_label\" and @text=\"My Profile\"]")).click();
        System.out.println("t22222222");

        waitFor(AppiumBy.id("com.varsitytutors.learningtools:id/button_sign_in_other")).click();      
        System.out.println("t3333333333");

        waitFor(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.varsitytutors.learningtools:id/register_link\")")).click();  
        System.out.println("t4444444444e");

  

        SignUpPage signUp = new SignUpPage(driver);

        String firstName = "ibrahhiiiiiiiiiiiiiiiiiiiiiiiiim";
        String lastName  = "Hamoudaaaaa";
        String email     = "user" + System.currentTimeMillis() + "@test.com";
        String password  = "Test@1234";

        signUp.signUp(firstName, lastName, email, password,true);
        waitFor(AppiumBy.accessibilityId("Learning")).click();
        System.out.println("5555555555");
        waitFor(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.varsitytutors.learningtools:id/drawer_label\" and @text=\"My Profile\"]")).click();
        waitFor(AppiumBy.id("com.varsitytutors.learningtools:id/button_sign_in_other")).click(); 
        

        System.out.println("Sign up flow executed successfully.");
    }
}
