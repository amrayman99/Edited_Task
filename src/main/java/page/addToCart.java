package page;

import Base.base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class addToCart extends base {
    public addToCart(WebDriver driver) throws IOException {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "hm-icon-label")
    public WebElement AllTab;

    @FindBy (partialLinkText = "عروض اليوم")
    public WebElement TodayDealss;

    @FindBy(xpath = "//span[@class='CheckboxFilter-module__checkboxLabelRtl_3jgOwr7xCkW_bWatBb4mtO'][contains(.,'أجهزة كمبيوتر ومكوناتها وملحقاتها')]")
    public WebElement SecondCategory;
    @FindBy(xpath = "(//img[@class='DealImage-module__imageObjectFit_1G4pEkUEzo9WEnA3Wl0XFv'])[1]")
    public WebElement FirstItem;

    @FindBy(xpath = "(//div[@class='a-section octopus-dlp-image-shield'])[2]")
    public WebElement SecondtItem;

    @FindBy(id = "quantity")
    public WebElement Quantity;

    @FindBy(id = "add-to-cart-button")
    public WebElement AddToCartButton;

    @FindBy(id = "attachSiNoCoverage-announce")
    public WebElement NoButton;

    @FindBy(xpath = "//a[@href='/cart?ref_=sw_gtc'][contains(.,'الانتقال إلى عربة التسوق')]")
    public WebElement MoveToCartButton;

    @FindBy(id = "productTitle")
    public WebElement ProductTitle;

    @FindBy(xpath = "(//span[@class='a-truncate-cut'])[1]")
    public WebElement ProductTitleAtCart;

    @FindBy(xpath = "(//span[@dir='ltr'])[7]")
    public WebElement ProductPrice;

    @FindBy(xpath = "//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']")
    public WebElement ProductPriceAtCart;

    @FindBy(xpath = "//span[@class='a-dropdown-prompt']")
    public WebElement QuantityAtCart;

    @FindBy(xpath = "(//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap'])[1]")
    public WebElement SubTotal;

}
