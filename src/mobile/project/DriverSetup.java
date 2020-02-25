package mobile.project;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.net.URL;

/**
 *
 * @author Davidito
 */
public class DriverSetup {

    protected static AndroidDriver androidDriver;
    //Default url to appium 
    String URL = "http://127.0.0.1:4723/wd/hub";

    @BeforeClass
    public void setup() {
        initDriver();
    }

    public AndroidDriver getDriver() {
        return androidDriver;
    }

    private void initDriver() {
        try {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            //If you are using android studio emulator the default is 'emulator-5554' change if needed
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "");
            //Replace with device type example 'android'
            desiredCapabilities.setCapability("platformName", "");
            androidDriver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @AfterClass
    public void tearDown() {
        androidDriver.quit();
    }
}
