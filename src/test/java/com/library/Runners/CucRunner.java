package com.library.Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "html:target/cucumber-report.html",
        features = "src\\test\\resources\\Features", //path of the content root
        glue ="com\\library\\StepDefinitions", // source root
        tags= "@AC-6",
        dryRun= false
)



public class CucRunner {



}
