package learningTools.QA;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class firstTimeSignUp extends LearningToolsTestBase{

    

   
    private WebElement waitFor(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

   @Test
    public void doFlow() {

        

        // اضغط على My Profile
        waitFor(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.varsitytutors.learningtools:id/drawer_label\" and @text=\"My Profile\"]")).click();
        System.out.println("success step 2");

        // اضغط Sign in other
        waitFor(AppiumBy.id("com.varsitytutors.learningtools:id/button_sign_in_other")).click();
        System.out.println("success step 3");

        // اضغط Register link
        waitFor(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.varsitytutors.learningtools:id/register_link\")")).click();
        System.out.println("success step 4");
        SignUpPage signUp = new SignUpPage(driver);

        String firstName = "ibrahhiiiiiiiiiiiiiiiiiiiiiiiiim";
        String lastName  = "Hamoudaaaaa";
        String email     = "user" + System.currentTimeMillis() + "@test.com";
        String password  = "Test@1234";

        signUp.signUp(firstName, lastName, email, password,true);
    }
}
