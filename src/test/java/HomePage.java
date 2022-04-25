import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.support.ui.*;

public class HomePage {
    protected WebDriver driver;

    // <h1>Hello userName</h1>
    // private By messageBy = By.tagName("h1");

    private final By flightsButtonLocator = By.xpath("//*[@id='wizardMainRegionV2']/div/div/div/div/ul/li[2]/a");
    private final By hotelsButtonLocator = By.xpath("//a[@href='?pwaLob=wizard-flight-pwa']");
    private final By leavingFromButtonLocator = By.xpath("//*[@id='location-field-leg1-origin-menu']/div[1]/div[1]/button");
    private final By leavingFromInputLocator = By.xpath("//*[@id='location-field-leg1-origin']");

    private WebElement waitVisibiiltyAndFindElement(By locator) {
        // this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this.driver.findElement(locator);
    }

    public HomePage(WebDriver driver){
        this.driver = driver;
        // if (!driver.getTitle().equals("Home Page of logged in user")) {
        //   throw new IllegalStateException("This is not Home Page of logged in user," +
        //         " current page is: " + driver.getCurrentUrl());
        // }
    }

    /**
    * Get message (h1 tag)
    *
    * @return String message text
    */
    // public String getMessageText() {
    //     return driver.findElement(messageBy).getText();
    // }

    // public HomePage manageProfile() {
    //     // Page encapsulation to manage profile functionality
    //     return new HomePage(driver);
    // }

    public void originTextBoxField(String origin) {
        WebElement leavingFromInput = waitVisibiiltyAndFindElement(leavingFromInputLocator);
        leavingFromInput.sendKeys(origin);
    }

    public void leavingFromButton() {
        WebElement leavingFromButton = waitVisibiiltyAndFindElement(leavingFromButtonLocator);
        leavingFromButton.click();
    }

    public void flightButton() {
        WebElement flightButton = waitVisibiiltyAndFindElement(flightsButtonLocator);
        flightButton.click();
    }

    public void hotelsButton() {
        WebElement hotelsButton = waitVisibiiltyAndFindElement(hotelsButtonLocator);
        hotelsButton.click();
    }
}
