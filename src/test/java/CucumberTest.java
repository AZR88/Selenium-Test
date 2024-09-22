import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"StepDef"},
        features = {"feature"},
        plugin = {"pretty"}
)

public class CucumberTest {
}
