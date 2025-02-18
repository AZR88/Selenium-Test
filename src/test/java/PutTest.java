import api.APITest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PutTest {

    @DataProvider(name = "userData")
    public Object[][] createUserData() {
        return new Object[][] {
                {2,"John Doe", "Software Developer", true},          // Positive case
                {2,"", "QA Engineer", true},                        // Negative case: empty name
                {2,"Alice", "", true},                              // Negative case: empty job
                {2, "VeryLongNameThatExceedsNormalLengthaldhiuhisabdkauhiugfKJKASJHFKSJH", "Dev", true}, // Negative case: very long name
                {2,"Bob", "Business Analyst", true},                 // Positive case
                {2,"!@#$%^&*()", "Engineer", true},                 // Negative case: special characters in name
                {3,"Jane Doe", "Tester", true}                       // Negative case
        };
    }

    @Test(dataProvider = "userData")
    public void testPutUser(Integer ID,String name, String job, boolean shouldPass) {
        APITest test = new APITest();
        test.putUser(ID,name, job, shouldPass);
    }
}
