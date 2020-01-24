/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobile.project;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;
import java.net.MalformedURLException;
import java.net.URL;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
/**
 *
 * @author Davidito
 */
public class MobileProject {

    public static AndroidDriver androidDriver = null;
    static int MILISECONDS = 10000;

    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        try {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
            desiredCapabilities.setCapability("platformName", "android");
            androidDriver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        //clicking into app
        androidDriver.findElementByAccessibilityId("Saavn").click();

        //Validating Activity
        Thread.sleep(MILISECONDS);
        WebElement isActivityDisplayed = androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.ImageView[1]");
        Boolean isElementPresent = isActivityDisplayed.isDisplayed();
        
        assertThat(isElementPresent, is(true));

        //Unclick Language
        Thread.sleep(MILISECONDS);
        androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.ImageView[1]").click();

        //Get screen size
        Dimension windowSize = androidDriver.manage().window().getSize();
        int height = windowSize.height;
        int width = windowSize.width;

        Thread.sleep(MILISECONDS);
        new TouchAction(androidDriver).press(PointOption.point(width / 2, height - 100)).moveTo(PointOption.point(width / 2, 349)).release().perform();

        Thread.sleep(MILISECONDS);
        androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[11]/android.widget.RelativeLayout").click();

        Thread.sleep(MILISECONDS);
        String languagesSelected = androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView").getText();
        
        assertThat(languagesSelected, is("1 Selected"));
        
        Thread.sleep(MILISECONDS);
        androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout").click();
    }
}
