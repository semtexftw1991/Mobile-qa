package mobile.test;

import io.appium.java_client.MobileElement;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Davidito
 */
public class TestSuites {

    //Use AppiumCollections Class to typeText, click elements.
    
    @Test
    public void sampleTest() {
        //implement tests here

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
