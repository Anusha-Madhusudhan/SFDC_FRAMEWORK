/**
 * 
 */
package com.tekarch.testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/**
 * 
 */


@RunWith(Cucumber.class)
@CucumberOptions(features = {"./src/test/java/com/tekarch/featureFiles/login.feature"},
                    glue="com.tekarch.stepDefinitions",
                    dryRun = false)
public class TestRnnerClass {

}
