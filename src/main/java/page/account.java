package page;

import Base.base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class account extends base {

    public account(WebDriver driver) throws IOException {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "icp-nav-flyout")
    public WebElement Language;

    @FindBy(xpath = "//*[text()='English']")
    public WebElement English_Button;

    @FindBy(xpath = "//span[contains(.,'Hello, sign in')]")
    public WebElement Account_List;

    @FindBy(xpath = "//*[text()='Your Orders']")
    public WebElement Your_Orders;

    @FindBy(xpath = "//*[text()='Your Addresses']")
    public WebElement Your_Addresses;

    @FindBy(xpath = "//span[contains(text(),'Your Lists')]")
    public WebElement Your_Lists;

    @FindBy(xpath = "//span[@class='al-intro-banner-header']")
    public WebElement List_Banner;
    @FindBy(xpath = "//input[@type='email']")
    public WebElement Email_Input;
}
