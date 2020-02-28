package mobile.test;

import io.appium.java_client.MobileElement;
import mobile.base.Driver;
import mobile.collections.AppiumCollections;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Davidito
 */
public class TestSuites {

    //Use AppiumCollections Class to typeText, click elements.
    private AppiumCollections collections = new AppiumCollections();
    Objects obj = new Objects();

    @Test
    public void sampleTest() {
        //implement tests here
        collections.openApp("App name");

        collections.clickOn(new Driver().getDriver(), obj.sample1);

        collections.getText(new Driver().getDriver(), obj.sample2);

        collections.typeText(new Driver().getDriver(), obj.sample3, "send text");

        collections.scrollUpScreen(new Driver().getDriver());

        collections.scrollDownScreen(new Driver().getDriver());

        assertEquals("", "");
    }

    class Objects {

        @FindBy(xpath = "")
        public MobileElement sample1;

        @FindBy(linkText = "")
        public MobileElement sample2;

        @FindBy(name = "")
        public MobileElement sample3;
    }
}
