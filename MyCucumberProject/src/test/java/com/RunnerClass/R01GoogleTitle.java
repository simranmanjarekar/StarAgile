package com.RunnerClass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="./src/test/resources/MyCucumberProject/MyCucumberProject/F01GoogleTitle.feature",glue="com.stepDefinition")
public class R01GoogleTitle {



}
