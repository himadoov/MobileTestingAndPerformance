package com.Axos.appiumTest;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.appium.java_client.android.AndroidDriver;

public class TestBaseAppium {
	protected AndroidDriver driver;

	 @BeforeTest
	 public void setUp() throws MalformedURLException {
	     DesiredCapabilities caps = new DesiredCapabilities();
	     caps.setCapability("platformName", "Android");
	     caps.setCapability("appium:automationName", "UiAutomator2");
	     caps.setCapability("appium:deviceName", "RR8NC05MGXF");
	     caps.setCapability("appium:noReset", true);       
	     caps.setCapability("appium:autoGrantPermissions", true);   
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
