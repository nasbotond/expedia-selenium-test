import org.openqa.selenium.*;

public class SignInPage extends BasePage{

  private By emailInputLocator = By.xpath("//*[@id='loginFormEmailInput']");
  private By passwordInputLocator = By.xpath("//*[@id='loginFormPasswordInput']");
  private By signInButtonLocator = By.xpath("//*[@id='loginFormSubmitButton']");
  private By pageBodyLocator = By.xpath("//*[@id='app-layer-base']/div/main");

  public SignInPage(WebDriver driver) {
    super(driver);
  }

  /**
  * Login as valid user
  *
  * @param userName
  * @param password
  * @return HomePage object
  */
  public HomePage loginValidUser(String email, String password) {
    waitVisibiltyAndFindElement(emailInputLocator).sendKeys(email);
    waitVisibiltyAndFindElement(passwordInputLocator).sendKeys(password);
    waitVisibiltyAndFindElement(signInButtonLocator).click();
    return new HomePage(driver);
  }

  public SignInPage loginInvalidUser(String email, String password) {
    waitVisibiltyAndFindElement(emailInputLocator).sendKeys(email);
    waitVisibiltyAndFindElement(passwordInputLocator).sendKeys(password);
    waitVisibiltyAndFindElement(signInButtonLocator).click();
    return this;
  }

  public Boolean isIncorrectUsernameOrPassword() {
    WebElement pageBody = waitVisibiltyAndFindElement(pageBodyLocator);
    return !pageBody.getText().contains("Email and password don't match. Try again.");
  }

}
