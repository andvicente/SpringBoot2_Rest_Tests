package com.andvicente.springboot2rest;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * Created by avicente on 26/07/17.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-html-report", "json:target/cucumber-json-report.json" },
        features = "src/test/resources",
        glue = {"com.andvicente.springboot2rest.cucumber.steps"})
public class RunCucumberTests {


}