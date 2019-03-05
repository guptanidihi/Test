package com.CCQA.com;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

 @CucumberOptions(
		// tags = {"@LoginSuccess,@LoginInvalid"}
		 tags = {"@Smoke"}
		 )

 public class Testrun {

 }
