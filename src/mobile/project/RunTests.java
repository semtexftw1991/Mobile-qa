package mobile.project;

import java.net.MalformedURLException;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 *
 * @author Davidito
 */
public class RunTests {

    //Executing TestSuites Class 
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        Result result = JUnitCore.runClasses(TestSuites.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }
}
