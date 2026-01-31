package StepDefinition;

import PageObject.AddCartPage;
import PageObject.LoginPage;
import Utilities.DriverFactory;
import Utilities.ReadConfig;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import java.io.File;

import java.io.IOException;


public class StepDef extends BaseClass{
    @Before(order=1)
    public void setup()
    {
        readConfig=new ReadConfig();
        String browser=readConfig.getBrowser();
        driver= DriverFactory.initDriver(browser);

        log= LogManager.getLogger("StepDef");

        log.trace("Setup1 executed");

    }
    @Before(value= "@Sanity", order=2)
    public void setup2()
    {
        System.out.println("Setup2 is success");
        log.info("setup2 executed");
    }
    @Given("user launch chrome browser")
    public void user_launch_chrome_browser() {
        //driver= DriverFactory.initDriver();
        loginPg=new LoginPage(driver);
        addcartpg=new AddCartPage(driver);

        log.fatal("User launched chrome browser");
    }
    @When("user opens url {string}")
    public void user_opens_url(String url) {

        driver.get(url);
        log.error("url is opened");
    }
    @When("user enters email as {string} and password {string}")
    public void user_enters_email_as_and_password(String email, String pass) {
        loginPg.EnterEmail(email);
        loginPg.EnterPassword(pass);
        log.warn("entered email and password");
    }
    @When("click on login")
    public void click_on_login() {

        loginPg.SigninBtn();
        log.debug("login button clicked");
    }
    @Then("page title should be {string}")
    public void page_title_should_be(String ExpectedTitle) {

        String ActualTitle=driver.getTitle();
        if(ActualTitle.equals(ExpectedTitle))
        {
            log.info("Test passed: loginfeature page Title matched");
            Assert.assertTrue(true);
        }
        else
        {
            log.warn("Test Failed: loginfeature page title not matched");
            Assert.assertTrue(false);
        }

    }
    @Then("user click on open menu option")
    public void user_click_on_open_menu_option() {

        loginPg.OpenMenu();
        log.info("Menu option is clicked");
    }
    @When("user click on logout link")
    public void user_click_on_logout_link() {

        loginPg.Logout();
        log.info("User logout successfully");
    }
    /*@Then("close browser")
    public void close_browser() {
        driver.close();
        log.info("Browser is closed");
    }*/
    //Add to cart page
    @When("user click on Addcart button")
    public void user_click_on_addcart_button() {
        addcartpg.AddToCartBtn();
        log.info("User clicked on add cart button");
    }
    @Then("User should be able to view Remove button")
    public void user_should_be_able_to_view_remove_button() {
        addcartpg.RemoveBtn();
        log.info("remove button is displayed");
    }
    @AfterStep
    public void takeScreenshotAfterEveryStep(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);
//attach image file report(data, media type, name of the attachment)
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
    }
    /*@After
    public void TearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("Scenario failed: " + scenario.getName());
        }
        driver.quit();
    }*/
    /*@After
    public void Teardown(Scenario sc) throws IOException {
    System.out.println("Tear Down method executed");
    if(sc.isFailed()==true)
    {
        //convert webdriver object to TakeScreenshot
        String fileWithPath="Screenshots/failedtest.png";
        TakesScreenshot srcshot=((TakesScreenshot)driver);
        //call getscreenshotAs method to create image file
        File srcFile=srcshot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File(fileWithPath);
        //copy file at destination
        FileUtils.copyFile(srcFile,DestFile);
    }
    }*/
    @After
    public void Teardown(){
        driver.quit();
    }
}
