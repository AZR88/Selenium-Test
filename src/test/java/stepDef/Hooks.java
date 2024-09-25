package stepDef;

import io.cucumber.java.*;

import static Helper.WebHelper.startDriver;
import static Helper.WebHelper.tearDown;


public class Hooks {

    @BeforeAll
    public static void startUp (){

    }

    @AfterAll
    public static void shutDown (){

    }

    @Before
    public void beforeTest (){
        System.out.println("BEFORE TEST");
        startDriver();
    }

    @After
    public  void afterTest (){
        System.out.println("AFTER TEST");
        tearDown();
    }
}
