import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.support.ui.*;

public class BasePage {

    public WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl;
    public HomePage homePage;

    @Before
    public void setUp(){
        baseUrl = "https://www.expedia.com";        

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
        driver.get(baseUrl);
    }

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}