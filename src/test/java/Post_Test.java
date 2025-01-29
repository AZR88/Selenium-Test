import api.APITest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Post_Test {

    @DataProvider(name = "userData")
    public Object[][] createUserData() {
        return new Object[][] {
                {"John Doe", "Software Developer", true},          // Positive case
                {"", "QA Engineer", true},                        // Negative case: empty name
                {"Alice", "", true},                              // Negative case: empty job
                {"VeryLongNameThatExceedsNormalLengthaldhiuhisabdkauhiugfKJKASJHFKSJH", "Dev", true}, // Negative case: very long name
                {"Bob", "Business Analyst", true},                 // Positive case
                {"!@#$%^&*()", "Engineer", true},                 // Negative case: special characters in name
                {"Jane Doe", "Tester", true}                       // Positive case
        };
    }

    @Test(dataProvider = "userData")
    public void testPostUser(String name, String job, boolean shouldPass) {
        APITest test = new APITest();
        test.PostUser(name, job, shouldPass);
    }
}