package mobile.collections;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import mobile.base.Driver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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
        new Driver().driver.findElementByAccessibilityId("appName").click();
    }

    public static void scrollDown() {
        //Getting screen dimensions of device
        Dimension windowSize = new Driver().driver.manage().window().getSize();
        //Touch starting point and relase point (height)
        //Calculation accounts for roughly 10 && 80% of the height (change depending on screen size and testing needs)
        int startPoint = windowSize.height / 10;
        int releasePoint = windowSize.height / 80;
        //center of the screen (width)
        int width = windowSize.width / 2;

        //scrown down action
        new TouchAction(new Driver().driver).press(PointOption.point(width, startPoint)).moveTo(PointOption.point(width, releasePoint)).release().perform();
    }

    public static void scrollUp() {
        //Getting screen dimensions of device
        Dimension windowSize = new Driver().driver.manage().window().getSize();
        //Touch starting point and relase point (height)
        //Calculation accounts for roughly 10 && 80% of the height (change depending on screen size and testing needs)
        int releasePoint = windowSize.height / 10;
        int startPoint = windowSize.height / 80;
        //center of the screen (width)
        int width = windowSize.width / 2;
        //scrown down action
        new TouchAction(new Driver().driver).press(PointOption.point(width, startPoint)).moveTo(PointOption.point(width, releasePoint)).release().perform();
    }
    
}
