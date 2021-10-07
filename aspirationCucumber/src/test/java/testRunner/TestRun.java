package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions
(features="src/test/resources/Features/homePage.feature",
glue="stepDefinitions",
monochrome=true

)


public class TestRun {

}
