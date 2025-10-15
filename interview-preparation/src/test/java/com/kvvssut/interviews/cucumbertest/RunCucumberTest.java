package com.kvvssut.interviews.cucumbertest;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

/*
https://cucumber.io/docs/guides/10-minute-tutorial/?lang=java
 */
@Suite
@IncludeEngines("cucumber")
@SelectPackages("cucumbertest")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
public class RunCucumberTest {
}
