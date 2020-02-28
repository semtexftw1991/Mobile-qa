package mobile.base;

import io.appium.java_client.android.AndroidDriver;

/**
 *
 * @author Davidito
 */
public class Driver extends DriverSetup {

    public AndroidDriver driver;

    public Driver() {
        this.driver = super.getDriver();
    }
}
