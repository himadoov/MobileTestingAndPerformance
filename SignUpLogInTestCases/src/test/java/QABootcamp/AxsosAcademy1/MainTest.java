package QABootcamp.AxsosAcademy1;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import java.net.MalformedURLException;
import java.net.URL;

public class MainTest {

    private AndroidDriver driver;
    @BeforeTest  
    public void setUp() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("appium:deviceName", "emulator-5554");
            capabilities.setCapability("appium:platformVersion", "14");
            capabilities.setCapability("appium:platformName", "Android");
            capabilities.setCapability("appium:automationName", "UiAutomator2");
            capabilities.setCapability("appium:app", "C:\\Users\\Lenovo\\eclipse-workspace\\ApiDemos-debug.apk");

            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (Exception e) {
            e.printStackTrace();            // اطبع الاستثناء الكامل هنا
            org.testng.Assert.fail(e.getMessage()); // هذا يلغي الاختبار مع رسالة
        }
    }


    @Test
    public void simpleTest() {
        driver.findElement(By.id("android:id/text1")).click();
    }
    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
