package com.metsky_net.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-reports.html",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber"
        },
        features = "C:\\Users\\nancy\\IdeaProjects\\nancy_project\\src\\test\\resources\\features",
        glue = "com/metsky_net/step_definitions",
        dryRun = false,
        tags = " @login",
        publish = true //generating a report with public link
)
public class CukesRunner {}


