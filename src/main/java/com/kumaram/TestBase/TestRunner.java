package com.kumaram.TestBase;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "/RedBus/src/test/resources/features", glue = "com.kumaran.steps" )

public class TestRunner extends AbstractTestNGCucumberTests {
	
}



