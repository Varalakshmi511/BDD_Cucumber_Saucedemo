package TestRunner;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


//@RunWith(Cucumber.class)
@CucumberOptions
        (
                features = "Features",
                glue="StepDefinition",
                dryRun = false,
                monochrome=true,
                //tags = "@Sanity and not @Regression",
                //plugin={"pretty","html:target/cucumber-reports/htmlreport.html", "json:target/cucumber-reports/jsonreport.json", "junit:target/cucumber-reports/xmlreport.xml"}
                plugin={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
        )
public class Run extends AbstractTestNGCucumberTests {
    //This class will be Empty
}


