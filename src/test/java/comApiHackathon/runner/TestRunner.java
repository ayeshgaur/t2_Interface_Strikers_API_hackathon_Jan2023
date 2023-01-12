package comApiHackathon.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/programModule",
        glue = {"stepDefinitions"},
        monochrome = true
)
public class TestRunner {
}
