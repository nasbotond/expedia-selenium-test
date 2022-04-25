import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {
  protected WebDriver driver;
  Utilities utilities = new Utilities(driver);

  private By emailInputLocator = By.xpath("//*[@id='loginFormEmailInput']");
  private By passwordInputLocator = By.xpath("//*[@id='loginFormPasswordInput']");
  private By signInButtonLocator = By.xpath("//*[@id='loginFormSubmitButton']");

  public SignInPage(WebDriver driver){
    this.driver = driver;
  }

  /**
    * Login as valid user
    *
    * @param userName
    * @param password
    * @return HomePage object
    */
  public void loginValidUser(String email, String password) {
    utilities.waitVisibiltyAndFindElement(driver, emailInputLocator).sendKeys(email);
    utilities.waitVisibiltyAndFindElement(driver, passwordInputLocator).sendKeys(password);
    utilities.waitVisibiltyAndFindElement(driver, signInButtonLocator).click();
    // return new HomePage(driver);
  }
}
