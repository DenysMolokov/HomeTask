package com.runner;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src//test//java//com//features",
        glue={"com/steps"},
        monochrome = true,
        //dryRun = true
        plugin = {"pretty","html:target/cucumber-html-report", "json:target/cucumber-json-report.json"}
        )

        public class TestRunner {
        }
