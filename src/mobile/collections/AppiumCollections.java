package mobile.collections;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import mobile.base.Driver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Davidito
 */
public class AppiumCollections {

    static private WebDriverWait wait;
    static int miliseconds = 30000;

    public static void waitForElement(AndroidDriver driver, MobileElement element) {
        wait = new WebDriverWait(driver, miliseconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void typeText(AndroidDriver driver, MobileElement element, String value) {
        waitForElement(driver, element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.sendKeys(value);
    }

    public static void clickOn(AndroidDriver driver, MobileElement element) {
        waitForElement(driver, element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public static String getText(AndroidDriver driver, MobileElement element) {
        waitForElement(driver, element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element.getText();
    }

    public static void openApp(String appName) {
        new Driver().driver.findElementByAccessibilityId(appName).click();
    }

    private static Dimension getScreenDimensions() {
        Dimension windowSize = new Driver().driver.manage().window().getSize();
        return windowSize;
    }

    private static int startingPoint() {
        Dimension window = getScreenDimensions();
        int startPoint = window.height / 10;
        return startPoint;
    }

    private static int releasePoint() {
        Dimension window = getScreenDimensions();
        int startPoint = window.height / 80;
        return startPoint;
    }
    
    private static int width() {
        Dimension window = getScreenDimensions();
        int startPoint = window.width / 2;
        return startPoint;
    }

    public static void scrollDownScreen(AndroidDriver driver) {
        //scrown down action
        new TouchAction(driver).press(PointOption.point(width(), startingPoint())).moveTo(PointOption.point(width(), releasePoint())).release().perform();
    }

    public static void scrollUpScreen(AndroidDriver driver) {
        //scrown down action
        new TouchAction(driver).press(PointOption.point(width(), startingPoint())).moveTo(PointOption.point(width(), releasePoint())).release().perform();
    }

}
