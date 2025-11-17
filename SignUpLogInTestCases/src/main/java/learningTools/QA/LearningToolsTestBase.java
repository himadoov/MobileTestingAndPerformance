

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

        // ---------- Device ----------
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("appium:deviceName", "Android");
        caps.setCapability("appium:udid", "6963b4e0");

        // ---------- App (نفس اللي شغّال في Inspector) ----------
        caps.setCapability("appium:appPackage", "com.varsitytutors.learningtools");
        caps.setCapability("appium:appActivity",
                "com.varsitytutors.learningtools.ui.activity.SplashActivity");

        // التطبيق بينط بسرعة لـ FindTutorDrawerActivity، فإحنا بنقبل أي Activity من نفس الباكدج
        caps.setCapability("appium:appWaitActivity",
                "com.varsitytutors.learningtools.ui.activity.FindTutorDrawerActivity," +
                "com.varsitytutors.learningtools.ui.activity.*");

        // المهم جداً عشان ما يفضلش مستني SplashActivity حرفيًا
        caps.setCapability("appium:appWaitForLaunch", false);
        

        // ما تمسحش الداتا كل مرة (نفس لاستخدامك من الموبايل)
        caps.setCapability("appium:noReset", false);
        //caps.setCapability("appium:fullReset", true);

        // ---------- Driver ----------
        driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723/wd/hub"),
                caps
        );
    }


    //@AfterTest
    //public void tearDown() {
    //    if (driver != null) {
     //       driver.quit();
     //   }
   // }
}
