package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver ldriver;
    public LoginPage(WebDriver rDriver)
    {
        ldriver=rDriver;
        PageFactory.initElements(rDriver,this);
    }
    @FindBy(id="user-name")
    WebElement email;
    @FindBy(id="password")
    WebElement password;
    @FindBy(id="login-button")
    WebElement signinbtn;
    @FindBy(id="react-burger-menu-btn")
    WebElement openmenu;
    @FindBy(id="logout_sidebar_link")
    WebElement logout;

    public void EnterEmail(String Email)
    {
        email.clear();
        email.sendKeys(Email);
    }
    public void EnterPassword(String Password)
    {
        password.clear();
        password.sendKeys(Password);
    }
    public void SigninBtn()
    {
        signinbtn.click();
    }
    public void OpenMenu()
    {
        openmenu.click();
    }
    public void Logout()
    {
        WebDriverWait wait=new WebDriverWait(ldriver,Duration.ofSeconds(10));
                wait.until(ExpectedConditions.elementToBeClickable(logout)).click();
    }


}
