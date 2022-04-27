import org.openqa.selenium.*;

public class TripsPage extends BasePage {

    private final By headerTextLocator = By.xpath("//*[@id='app-layer-base']/div[2]/div/div/div/div/div[2]/h1");

    public TripsPage(WebDriver driver) {
        super(driver);
    }

    public String getHeaderText() {
        return waitVisibiltyAndFindElement(headerTextLocator).getText();
    }
}
