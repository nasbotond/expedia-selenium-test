import org.openqa.selenium.*;

public class SignInPage extends BasePage {

    private final By emailInputLocator = By.xpath("//*[@id='loginFormEmailInput']");
    private final By passwordInputLocator = By.xpath("//*[@id='loginFormPasswordInput']");
    private final By signInButtonLocator = By.xpath("//*[@id='loginFormSubmitButton']");
    private final By pageBodyLocator = By.xpath("//*[@id='app-layer-base']/div/main");

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public HomePage signInValidUser(String email, String password) {
        waitVisibiltyAndFindElement(emailInputLocator).sendKeys(email);
        waitVisibiltyAndFindElement(passwordInputLocator).sendKeys(password);
        waitVisibiltyAndFindElement(signInButtonLocator).click();
        return new HomePage(driver);
    }

    public SignInPage signInInvalidUser(String email, String password) {
        waitVisibiltyAndFindElement(emailInputLocator).sendKeys(email);
        waitVisibiltyAndFindElement(passwordInputLocator).sendKeys(password);
        waitVisibiltyAndFindElement(signInButtonLocator).click();
        return new SignInPage(driver);
    }

    public Boolean isIncorrectUsernameOrPassword() {
        WebElement pageBody = waitVisibiltyAndFindElement(pageBodyLocator);
        return !pageBody.getText().contains("Email and password don't match. Try again.");
    }
}