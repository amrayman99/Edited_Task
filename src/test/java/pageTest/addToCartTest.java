package pageTest;

import Base.base;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.addToCart;

import java.io.IOException;

public class addToCartTest extends base {
    public addToCartTest() throws IOException {
    }

    addToCart addToCart;
    Select quantityValue;


    @Test(priority = 2)
    public void Verify_that_Items_are_added_to_cart_correctly() throws IOException {

        addToCart=new addToCart(driver);

        String valueOfQuantity="2";
        int valueOfQuantityAsInt = Integer.parseInt(valueOfQuantity);

        addToCart.AllTab.click();
        wait.until(ExpectedConditions.elementToBeClickable(addToCart.TodayDealss));
        js.executeScript("arguments[0].click()", addToCart.TodayDealss);
        addToCart.SecondCategory.click();
        addToCart.FirstItem.click();

        // To handle if the product has more than model
        try {
            if (addToCart.SecondtItem.isDisplayed()){
                js.executeScript("arguments[0].click()", addToCart.SecondtItem);

            }

        }        catch (org.openqa.selenium.NoSuchElementException ignored){}



        String productTitleText=addToCart.ProductTitle.getText();
        String productPriceText=addToCart.ProductPrice.getText();


        quantityValue=new Select(addToCart.Quantity);
        quantityValue.selectByValue(valueOfQuantity);
        addToCart.AddToCartButton.click();

        // To handle if the product has coverage
        try {
            wait.until(ExpectedConditions.visibilityOf(addToCart.NoButton));
            if (addToCart.NoButton.isDisplayed()){
                js.executeScript("arguments[0].click()", addToCart.NoButton);
            }

        }catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException ignored){}
        addToCart.MoveToCartButton.click();


        String productTitleTextAtCart=addToCart.ProductTitleAtCart.getText();
        String productPriceTextAtCart=addToCart.ProductPriceAtCart.getText();
        String subTotalAtCart=addToCart.SubTotal.getText();

        String quantityAtCart=addToCart.QuantityAtCart.getText();

        SoftAssert softAssert=new SoftAssert();

        softAssert.assertEquals(convertToFloat(productPriceText),convertToFloat(productPriceTextAtCart),"Price is different");
        softAssert.assertTrue(containsSubstring(productTitleText,productTitleTextAtCart),"Title is different");
        softAssert.assertEquals(valueOfQuantity,quantityAtCart,"Quantity is different");
        softAssert.assertEquals((convertToFloat(productPriceText)*valueOfQuantityAsInt),convertToFloat(subTotalAtCart),"Total price is different");

        softAssert.assertAll();

    }


    public static float convertToFloat(String inputString) {

        String numericString = inputString.replaceAll("[^\\d]", "");
        int integerValue = Integer.parseInt(numericString);

        return (float) (integerValue / 100.0);
    }

    public static boolean containsSubstring(String mainString, String subString) {
        if (subString.endsWith("…")) {
            int lastIndex = subString.lastIndexOf(" ");
            if (lastIndex != -1) {
                subString = subString.substring(0, lastIndex);
            }
        }

        return mainString.contains(subString);
    }

}
