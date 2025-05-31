package com.RunnerClass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/MyCucumberProject/MyCucumberProject/F03ExpandTesting.feature",
glue="com.stepDefinition",tags="@AllLinks",publish=true)
public class R03ExpandTesting {

}
