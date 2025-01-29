import api.APITest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Get_Test {
    @DataProvider(name = "userData")
    public Object[][] createUserData() {
        return new Object[][] {
                {2, true},  // Positive case: Valid user ID
                {999, false}, // Negative case: Non-existent user ID
                {0, false} // Negative case: Null/empty ID
        };
    }

    @Test(dataProvider = "userData")
    public void GetUser(Integer ID, boolean shouldPass) {
        APITest test = new APITest();
        test.getUserById(ID, shouldPass);
    }

}
