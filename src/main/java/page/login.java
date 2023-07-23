package page;

import Base.base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class login extends base {
    public login(WebDriver driver) throws IOException {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "nav-link-accountList-nav-line-1")
    public WebElement LogInButton;

    @FindBy(id = "ap_email")
    public WebElement EmailField;

    @FindBy(id = "continue")
    public WebElement ContinueButton;

    @FindBy (xpath = "//*[contains(text(),'لا يمكننا العثور على حساب بعنوان البريد الإلكتروني هذا.')]")
    public WebElement NotRegisteredEmailMessage;
}
