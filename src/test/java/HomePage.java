import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.*;

import org.openqa.selenium.support.ui.*;

public class HomePage extends BasePage {

    private final By flightsButtonLocator = By.xpath("//*[@id='wizardMainRegionV2']/div/div/div/div/ul/li[2]/a");
    private final By hotelsButtonLocator = By.xpath("//a[@href='?pwaLob=wizard-flight-pwa']");
    private final By leavingFromButtonLocator = By.xpath("//*[@id='location-field-leg1-origin-menu']/div[1]/div[1]/button");
    private final By leavingFromInputLocator = By.xpath("//*[@id='location-field-leg1-origin']");
    private final By signInTabLocator = By.xpath("//*[@id='app-layer-base']/div[1]/div[1]/header/div/div/div[2]/div/button");
    private final By signInButtonLocator = By.xpath("//*[@id='app-layer-base']/div[1]/div[1]/header/div/div/div[2]/div/div/div[2]/a");
    private final By signUpButtonLocator = By.xpath("//*[@id='app-layer-base']/div[1]/div[1]/header/div/div/div[2]/div/div/div[3]/a");
    private final By loggedInTextLocator = By.xpath("//*[@id='app-layer-base']/div[1]/div[1]/header/div/div/div[2]/div/button/div");
    private final By signOutButtonLocator = By.xpath("//*[@id='app-layer-base']/div[1]/div[1]/header/div/div/div[2]/div/div/div[5]/a");
    private final By tripsTabLocator = By.xpath("//*[@id='app-layer-base']/div[1]/div[1]/header/div/div/div[2]/a[3]");
    private final By languageSelectorTabLocator = By.xpath("//*[@id='app-layer-base']/div[1]/div[1]/header/div/div/div[2]/button");
    private final By languageSelectElementLocator = By.xpath("//*[@id='site-selector']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getLoggedInText() {
        WebElement loggedInText = waitVisibiltyAndFindElement(loggedInTextLocator);
        return loggedInText.getText();
    }

    public void originTextBoxField(String origin) {
        WebElement leavingFromInput = waitVisibiltyAndFindElement(leavingFromInputLocator);
        leavingFromInput.sendKeys(origin);
    }

    public SignInPage signInButton() {
        WebElement signInButton = waitVisibiltyAndFindElement(signInButtonLocator);
        signInButton.click();
        return new SignInPage(driver);
    }

    public SignUpPage signUpButton() {
        WebElement signUpButton = waitVisibiltyAndFindElement(signUpButtonLocator);
        signUpButton.click();
        return new SignUpPage(driver);
    }

    public void signInTab() {
        WebElement signInTab = waitVisibiltyAndFindElement(signInTabLocator);
        signInTab.click();
        signInTab.click();
    }

    public void signOutTab() {
        WebElement signOutTab = waitVisibiltyAndFindElement(signInTabLocator);
        signOutTab.click();
    }

    public HomePage signOutButton() {
        WebElement signOutButton = waitVisibiltyAndFindElement(signOutButtonLocator);
        signOutButton.click();
        return new HomePage(driver);
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

    public TripsPage tripsTab() {
        WebElement tripsTab = waitVisibiltyAndFindElement(tripsTabLocator);
        tripsTab.click();
        return new TripsPage(driver);
    }

    public Select languageSelectorDialog() {
        WebElement languageSelectorTab = waitVisibiltyAndFindElement(languageSelectorTabLocator);
        languageSelectorTab.click();
        WebElement languageSelectElement = waitVisibiltyAndFindElement(languageSelectElementLocator);
        Select languageSelect = new Select(languageSelectElement);
        return languageSelect;
    }

    public String getSelectedCountry() {
        WebElement languageSelectElement = waitVisibiltyAndFindElement(languageSelectElementLocator);
        Select languageSelect = new Select(languageSelectElement);
        WebElement firstSelectedOption = languageSelect.getFirstSelectedOption();
        return firstSelectedOption.getText();
    }
}
