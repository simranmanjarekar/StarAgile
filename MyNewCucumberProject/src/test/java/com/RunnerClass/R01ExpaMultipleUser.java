package com.RunnerClass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="./src/test/resources/MyNewCucumberProject/MyNewCucumberProject/F01ExpaMultipleUser.feature",glue="com.stepDefinition",publish=true)
public class R01ExpaMultipleUser {

}
