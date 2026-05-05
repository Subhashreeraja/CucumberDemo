package runner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin="pretty",features="src/test/resources/com/features/Login.feature",
glue="stepDefinitions",
tags="@ValidCredentials")
public class JunitCucumber {

}
