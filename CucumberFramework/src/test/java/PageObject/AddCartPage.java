package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddCartPage {
    WebDriver ldriver;

    public AddCartPage(WebDriver rdriver)
    {
        ldriver=rdriver;
        PageFactory.initElements(rdriver,this);
    }
    @FindBy(id="add-to-cart-sauce-labs-backpack")
    WebElement addtocartbtn;
    @FindBy(id="remove-sauce-labs-backpack")
    WebElement removebtn;

    public void AddToCartBtn()
    {
        addtocartbtn.click();
    }
    public boolean RemoveBtn()
    {
        WebDriverWait wait=new WebDriverWait(ldriver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(removebtn));
        return removebtn.isDisplayed();
    }
}
