package learningTools.QA;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;

public class LearningToolsTestBase {
	protected AndroidDriver driver;

	 @BeforeTest
	 public void setUp() throws MalformedURLException {
	     DesiredCapabilities caps = new DesiredCapabilities();
	     
	     caps.setCapability("appium:platformName", "Android");

	        caps.setCapability("appium:platformVersion", "16");   

	        caps.setCapability("appium:automationName", "UiAutomator2");

	        caps.setCapability("appium:deviceName", "emulator-5554");
	 
	        caps.setCapability("appium:app",

	            "D:\\Users\\sohai\\Documents\\workspace-spring-tools-for-eclipse-4.32.0.RELEASE\\QA\\com-varsitytutors-learningtools-288-67287210-7bd74430ed623baf53e928b20f888f92.apk");
	 
	        

	        caps.setCapability("appium:appPackage", "com.varsitytutors.learningtools");

	        caps.setCapability("appium:appActivity",

	                "com.varsitytutors.learningtools.ui.activity.SplashActivity");

	        caps.setCapability("appium:appWaitActivity", "*");

	        caps.setCapability("appium:appWaitDuration", 20000);
	 
	     driver= new AndroidDriver(
				 new URL("http://127.0.0.1:4723/wd/hub"), caps);

	 }
	 @AfterTest
	 public void teardown() {
	  if(driver!=null) {
		  driver.quit();
	  }
	 }
} 
 