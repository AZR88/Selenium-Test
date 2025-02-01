import api.APITest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetTagsTest {

    @DataProvider(name = "tagsData")
    public Object[][] createTagsData() {
        return new Object[][] {
                {true}
        };
    }

    @Test(dataProvider = "tagsData")
    public void GetTags(boolean shouldPass) {
        APITest test = new APITest();
        test.GetTagsList(shouldPass);
    }
}
