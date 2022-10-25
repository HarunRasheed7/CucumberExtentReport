package StepDefinitions;

import java.io.File;
import java.io.FileReader;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features ="src/test/resources/Feature",
glue = {"StepDefinitions"},
monochrome = true,
plugin = {"json:target/cucumber.json"})
public class TestRunner {
	
}
