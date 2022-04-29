import org.openqa.selenium.*;
import java.util.concurrent.TimeUnit;

public class SignUpPage extends BasePage {

    private final By emailInputLocator = By.xpath("//*[@id='signupFormEmailInput']");
    private final By passwordInputLocator = By.xpath("//*[@id='signupFormPasswordInput']");
    private final By firstNameInputLocator = By.xpath("//*[@id='signupFormFirstNameInput']");
    private final By lastNameInputLocator = By.xpath("//*[@id='signupFormLastNameInput']");

    private final By signUpButtonLocator = By.xpath("//*[@id='signupFormSubmitButton']");
    private final By headerLocator = By.xpath("//*[@id='app-layer-base']/div/div/div/h1");
    private final By continueButtonLocator = By.xpath("//*[@id='app-layer-base']/div/div/div/a");

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public HomePage signUpValidUser(String email, String firstName, String lastName, String password) {
        waitVisibiltyAndFindElement(emailInputLocator).sendKeys(email);
        waitVisibiltyAndFindElement(firstNameInputLocator).sendKeys(firstName);
        waitVisibiltyAndFindElement(lastNameInputLocator).sendKeys(lastName);
        waitVisibiltyAndFindElement(passwordInputLocator).sendKeys(password);
        waitVisibiltyAndFindElement(signUpButtonLocator).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        waitVisibiltyAndFindElement(continueButtonLocator).click();
        return new HomePage(driver);
    }

    public void getEmail(String email) {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String url = "https://endtest.io/mailbox?email=" + email;
        driver.get(url);
        WebElement emailItem = waitVisibiltyAndFindElement(By.className("email_item"));
        emailItem.click();
    }

    public String getEmailSender(String email) {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String url = "https://endtest.io/mailbox?email=" + email;
        driver.get(url);
        WebElement emailItem = waitVisibiltyAndFindElement(By.className("email_from"));
        return emailItem.getText();
    }

    public String getHeader() {
        return waitVisibiltyAndFindElement(headerLocator).getText();
    }
}