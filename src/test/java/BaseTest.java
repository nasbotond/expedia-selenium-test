import org.junit.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.support.ui.*;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String baseUrl;
    protected HomePage homePage;

    @Before
    public void setUp(){
        baseUrl = "https://www.expedia.com";        

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
        driver.get(baseUrl);
        // System.out.println("Page title is : " + driver.getTitle());
    }

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}