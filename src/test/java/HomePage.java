import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.support.ui.*;

public class HomePage extends BasePage {

    private final By flightsButtonLocator = By.xpath("//*[@id='wizardMainRegionV2']/div/div/div/div/ul/li[2]/a");
    private final By hotelsButtonLocator = By.xpath("//a[@href='?pwaLob=wizard-flight-pwa']");
    private final By leavingFromButtonLocator = By.xpath("//*[@id='location-field-leg1-origin-menu']/div[1]/div[1]/button");
    private final By leavingFromInputLocator = By.xpath("//*[@id='location-field-leg1-origin']");
    private final By signInTabLocator = By.xpath("//*[@id='app-layer-base']/div[1]/div[1]/header/div/div/div[2]/div/button");
    private final By signInButtonLocator = By.xpath("//*[@id='app-layer-base']/div[1]/div[1]/header/div/div/div[2]/div/div/div[2]/a");
    private final By loggedInTextLocator = By.xpath("//*[@id='app-layer-base']/div[1]/div[1]/header/div/div/div[2]/div/button/div");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    /**
    * Get message (h1 tag)
    *
    * @return String message text
    */
    public String getLoggedInText() {
        WebElement loggedInText = waitVisibiltyAndFindElement(loggedInTextLocator);
        return loggedInText.getText();
    }

    // public HomePage manageProfile() {
    //     // Page encapsulation to manage profile functionality
    //     return new HomePage(driver);
    // }

    public void originTextBoxField(String origin) {
        WebElement leavingFromInput = waitVisibiltyAndFindElement(leavingFromInputLocator);
        leavingFromInput.sendKeys(origin);
    }

    public SignInPage signInButton() {
        WebElement signInButton = waitVisibiltyAndFindElement(signInButtonLocator);
        signInButton.click();
        // signInButton.click();
        return new SignInPage(driver);
    }

    public void signInTab() {
        WebElement signInTab = waitVisibiltyAndFindElement(signInTabLocator);
        signInTab.click();
        signInTab.click();
    }

    public void leavingFromButton() {
        WebElement leavingFromButton = waitVisibiltyAndFindElement(leavingFromButtonLocator);
        leavingFromButton.click();
    }

    public void flightButton() {
        WebElement flightButton = waitVisibiltyAndFindElement(flightsButtonLocator);
        flightButton.click();
    }

    public void hotelsButton() {
        WebElement hotelsButton = waitVisibiltyAndFindElement(hotelsButtonLocator);
        hotelsButton.click();
    }
}
