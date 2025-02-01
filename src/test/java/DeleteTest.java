import api.APITest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DeleteTest {
    
    @DataProvider(name = "userDeleteData")
    public Object[][] createDeleteUserData() {
        return new Object[][] {
                { 204},  // Valid user ID, expects 204 (successful deletion)
        };
    }

    @Test(dataProvider = "userDeleteData")
    public void DeleteUser(int expectedStatusCode) {
        APITest test = new APITest();
        test.DeleteUser(expectedStatusCode);
    }
}
