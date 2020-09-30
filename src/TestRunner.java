import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/tests",
		glue = {"stepDefinations", "helperMethods"})
public class TestRunner
{
	

}