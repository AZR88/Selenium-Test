package stepDef;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import static Helper.WebHelper.startDriver;
import static Helper.WebHelper.tearDown;

public class Hooks {

    @Before
    public void beforeTest() {
        String browser = System.getProperty("browser", "chrome"); // Default to chrome if no property is set
        System.out.println("Running tests on: " + browser);
        startDriver(browser);
    }

    @After
    public void afterTest() {
        tearDown();
    }
}
