package pageTest;

import Base.base;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.account;

import java.io.IOException;

public class accountTest extends base {
    public accountTest() throws IOException {
    }

    account accountObj;
    SoftAssert softAssert=new SoftAssert();
    public void switch_to_english(){

        actions.moveToElement(accountObj.Language).build().perform();
        accountObj.English_Button.click();
        actions.moveToElement(accountObj.Account_List).build().perform();
    }
    @Test(priority = 3)
    public void orders_privilege() throws IOException {
        accountObj=new account(driver);
        switch_to_english();

        accountObj.Your_Orders.click();
        String currentUrl=driver.getCurrentUrl();
        String currentTitle=driver.getTitle();

        softAssert.assertTrue(currentUrl.contains("signin?"));
        softAssert.assertTrue(accountObj.Email_Input.isDisplayed());
        softAssert.assertFalse(currentTitle.equalsIgnoreCase("Your Orders"));
        softAssert.assertTrue(currentTitle.equalsIgnoreCase("Amazon Sign In"));
        softAssert.assertAll();
    }

    @Test(priority = 4)
    public void addresses_privilege() throws IOException {
        accountObj=new account(driver);

        switch_to_english();

        accountObj.Your_Addresses.click();
        String currentUrl=driver.getCurrentUrl();
        String currentTitle=driver.getTitle();

        softAssert.assertTrue(currentUrl.contains("signin?"));
        softAssert.assertTrue(accountObj.Email_Input.isDisplayed());
        softAssert.assertFalse(currentTitle.equalsIgnoreCase("Your Addresses"));
        softAssert.assertTrue(currentTitle.equalsIgnoreCase("Amazon Sign In"));
        softAssert.assertAll();
    }

    @Test(priority = 5)
    public void list_privilege() throws IOException {
        accountObj=new account(driver);

        switch_to_english();

        accountObj.Your_Lists.click();

        String currentUrl=driver.getCurrentUrl();
        String currentTitle=driver.getTitle();

        softAssert.assertTrue(currentUrl.contentEquals("https://www.amazon.eg/hz/wishlist/intro"));
        softAssert.assertTrue(currentTitle.contentEquals("Your List"));
        softAssert.assertTrue(accountObj.List_Banner.isDisplayed());
        softAssert.assertAll();

    }
}
