import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/resources/features/", plugin={"pretty","html:out.html"}, glue="def")
public class TestRunner {

}
