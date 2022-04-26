import org.junit.*;
import java.util.concurrent.TimeUnit;

public class LoginTest extends BaseTest {

    public void setUp() {
        super.setUp();
    }
    @Test
    public void validLogin() {
        homePage.signInTab();
        SignInPage sip = homePage.signInButton();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); // for manual captcha handling
        HomePage loggedInHomePage = sip.loginValidUser("nas.botond@gmail.com", "ixGM2L6RGNucKmq");
        Assert.assertTrue(loggedInHomePage.getLoggedInText().contains("Botond"));
    }

    @Test
    public void wrongPassword() {
        homePage.signInTab();
        SignInPage sip = homePage.signInButton();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); // for manual captcha handling
        SignInPage wrongUsernameOrPasswordPage = sip.loginInvalidUser("abcdef@gmail.com", "password");
        Assert.assertTrue(wrongUsernameOrPasswordPage.isIncorrectUsernameOrPassword());
    }
}
