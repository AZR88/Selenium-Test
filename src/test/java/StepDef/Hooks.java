package StepDef;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

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
        startDriver();
    }

    @After
    public  void afterTest (){
        tearDown();
    }
}
