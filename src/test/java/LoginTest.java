import org.junit.*;
import java.util.concurrent.TimeUnit;

public class LoginTest extends BaseTest {

    private String email = "nas.botond@gmail.com";
    private String password = "xxx"; // replace with real user password

    public void setUp() {
        super.setUp();
    }

    @Test
    public void successfulValidUserSignIn() {
        homePage.signInTab();
        SignInPage validSignInPage = homePage.signInButton();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); // for manual captcha handling
        HomePage loggedInHomePage = validSignInPage.signInValidUser(email, password);
        Assert.assertTrue(loggedInHomePage.getLoggedInText().contains("Botond"));
    }

    @Test
    public void wrongPasswordSignInAttemptDisplaysCorrectErrorMessage() {
        homePage.signInTab();
        SignInPage invalidSignInPage = homePage.signInButton();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); // for manual captcha handling
        SignInPage wrongUsernameOrPasswordPage = invalidSignInPage.signInInvalidUser("abcdef@gmail.com", "password");
        Assert.assertTrue(wrongUsernameOrPasswordPage.isIncorrectUsernameOrPassword());
    }

    @Test
    public void successfulSignInAndSignOut() {
        homePage.signInTab();
        SignInPage validSignInPage = homePage.signInButton();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); // for manual captcha handling
        HomePage signedInHomePage = validSignInPage.signInValidUser(email, password);
        signedInHomePage.signOutTab();
        HomePage signedOutHomePage = signedInHomePage.signOutButton();
        Assert.assertFalse(signedOutHomePage.getLoggedInText().contains("Botond"));
    }
}
