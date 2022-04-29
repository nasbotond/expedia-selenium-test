import org.openqa.selenium.*;
import org.junit.*;
import java.util.concurrent.TimeUnit;
import java.util.*;
import org.openqa.selenium.support.ui.Select;

public class SignUpTest extends BaseTest {

    public void setUp() {
        super.setUp();
    }

    @Test
    public void signUpSuccessful() {
        String email = "jamesbond66@endtest-mail.io";
        SignUpPage signUpPage = homePage.signUpButton();
        HomePage signedUpPage = signUpPage.signUpValidUser(email, "James", "Bond", "passssssssWORD33##");
        signUpPage.getEmail(email);
        Assert.assertTrue(signUpPage.getEmailSender(email).contains("Expedia"));
    }
}