package foradacaixa.tests;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/foradacaixa/features/Cliente.feature",
glue = { "" }, monochrome = true, dryRun = false)
public class  ClienteTest {}
