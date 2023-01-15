package com.api.hackathon.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/programModule",
        glue = {"com.api.hackathon.steps"},
        monochrome = true,
        plugin = { "pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
                + "Jvm"}
)
public class TestRunner {
}
