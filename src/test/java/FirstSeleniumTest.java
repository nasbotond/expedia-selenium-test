import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.support.ui.*;


public class FirstSeleniumTest {

    // private WebDriver driver;
    // private WebDriverWait wait;

    // @Before
    // public void setup() {
    //     WebDriverManager.chromedriver().setup();
    //     driver = new ChromeDriver();
    //     driver.manage().window().maximize();

    //     wait = new WebDriverWait(driver, 10);
    // }

    // private final By bodyLocator = By.tagName("body");
    // private final By requestPasswordLocator = By.xpath("//a[@id='requestPassword']");
    // private final By textFieldLocator = By.xpath("//div[@class='container']/div/form/label/input");


    // private WebElement waitVisibiiltyAndFindElement(By locator) {
    //     this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    //     return this.driver.findElement(locator);
    // }

    // @Test
    // public void multiplicationTest() {
    //     this.driver.get("http://selenium.thinkcode.se");

    //     WebElement resultElement = waitVisibiiltyAndFindElement(bodyLocator );
    //     System.out.println(resultElement.getText());
    //     Assert.assertTrue(resultElement.getText().contains("This is a collection of sample web pages that can be used to interact with using Selenium."));
        
        
    //     WebElement requestPasswordElement = waitVisibiiltyAndFindElement(requestPasswordLocator );
    //     requestPasswordElement.click();
        
    //     WebElement textFieldElement = waitVisibiiltyAndFindElement(textFieldLocator);
    //     textFieldElement.sendKeys("newpassword \n");
        
    //     WebElement bodyElement = waitVisibiiltyAndFindElement(bodyLocator);
    //     System.out.println(bodyElement.getText());
    //     Assert.assertTrue(bodyElement.getText().contains("newpassword"));
        
    // }
    
    // @After
    // public void close() {
    //     if (driver != null) {
    //         driver.quit();
    //     }
    // }
}
