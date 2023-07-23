package pageTest;

import Base.base;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.login;

import java.io.IOException;

public class loginTest extends base {
    public loginTest() throws IOException {
    }

    login login;
    SoftAssert softAssert=new SoftAssert();
    @Test(priority = 1)
    public void valid_but_not_registered_email() throws InterruptedException, IOException {
        login=new login(driver);
        login.LogInButton.click();
        login.EmailField.sendKeys("amrayman99@gmail.com");
        login.ContinueButton.click();
        softAssert.assertTrue(login.NotRegisteredEmailMessage.isDisplayed());
    }
}
