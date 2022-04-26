import org.openqa.selenium.*;

public class SignInPage {

  protected WebDriver driver;
  Utilities utilities = new Utilities(driver);

  private By emailInputLocator = By.xpath("//*[@id='loginFormEmailInput']");
  private By passwordInputLocator = By.xpath("//*[@id='loginFormPasswordInput']");
  private By signInButtonLocator = By.xpath("//*[@id='loginFormSubmitButton']");
  private By pageBodyLocator = By.xpath("//*[@id='app-layer-base']/div/main");

  public SignInPage(WebDriver driver) {
    this.driver = driver;
  }

  /**
  * Login as valid user
  *
  * @param userName
  * @param password
  * @return HomePage object
  */
  public HomePage loginValidUser(String email, String password) {
    utilities.waitVisibiltyAndFindElement(driver, emailInputLocator).sendKeys(email);
    utilities.waitVisibiltyAndFindElement(driver, passwordInputLocator).sendKeys(password);
    utilities.waitVisibiltyAndFindElement(driver, signInButtonLocator).click();
    return new HomePage(driver);
  }

  public SignInPage loginInvalidUser(String email, String password) {
    utilities.waitVisibiltyAndFindElement(driver, emailInputLocator).sendKeys(email);
    utilities.waitVisibiltyAndFindElement(driver, passwordInputLocator).sendKeys(password);
    utilities.waitVisibiltyAndFindElement(driver, signInButtonLocator).click();
    return this;
  }

  public Boolean isIncorrectUsernameOrPassword() {
    WebElement pageBody = utilities.waitVisibiltyAndFindElement(driver, pageBodyLocator);
    return !pageBody.getText().contains("Email and password don't match. Try again.");
  }

}
