package mobile.project;

import io.appium.java_client.android.AndroidDriver;

/**
 *
 * @author Davidito
 */
public class Driver extends DriverSetup {

    protected AndroidDriver driver;

    public Driver() {
        this.driver = super.getDriver();
    }
}
