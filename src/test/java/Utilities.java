import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities {
    
    WebDriver driver;

    public Utilities(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitVisibiltyAndFindElement(WebDriver driver, By locator) {
        WebElement element = driver.findElement(locator);
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch(Exception e){
            System.out.println("Element not visible, " + e.getMessage());
        }
        return element;
    }
    
}
