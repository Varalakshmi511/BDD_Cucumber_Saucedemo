package StepDefinition;

import PageObject.AddCartPage;
import PageObject.LoginPage;
import Utilities.ReadConfig;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.*;

import java.util.Properties;

public class BaseClass {
    public static WebDriver driver;
    public LoginPage loginPg;
    public AddCartPage addcartpg;
    public static Logger log;
    public ReadConfig readConfig;
}
