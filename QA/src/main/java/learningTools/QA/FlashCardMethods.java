package learningTools.QA;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class FlashCardMethods {
	
	private AndroidDriver driver;
	private WebDriverWait wait ; 

	
	public FlashCardMethods(AndroidDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	//Methods
		public void clickMethod(By locator) {
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			driver.findElement(locator).click();
		}
		
		public boolean IsDisplayed(By locator) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			return driver.findElement(locator).isDisplayed();
		} 
		
		public void sendKeysMethod(By locator, String str) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			driver.findElement(locator).sendKeys(str); 
		}
		
		public String getTextMethod(By locator) {
			return driver.findElement(locator).getText(); 
		}
		
		public void switchToAlertMethod(String str) {
			driver.switchTo().alert().sendKeys(str); 
		}
}
  