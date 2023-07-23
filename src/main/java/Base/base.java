package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class base {

    public static WebDriver driver;
    public static Properties pro;
    public static Actions actions;
    public static WebDriverWait wait;
    public static JavascriptExecutor js;
    public base() throws IOException {

        pro =new Properties();
        FileInputStream fis = new FileInputStream("F:\\frame\\src\\main\\java\\config\\config.properties");
        pro.load(fis);
    }

    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(String browser){

        if (browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        else if (browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else if (browser.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.get(pro.getProperty("URL"));

        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        wait=new WebDriverWait(driver,5);

        actions = new Actions(driver);
        js = (JavascriptExecutor)driver;

        // To handle the another UI of the website
        try {WebElement go=driver.findElement(By.xpath("//input[@title='Go']"));
            if(go.isDisplayed()){
                driver.navigate().refresh();}
        }        catch (org.openqa.selenium.NoSuchElementException ignored){}

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }



}
