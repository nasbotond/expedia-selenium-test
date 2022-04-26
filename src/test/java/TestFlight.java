import org.junit.*;
import java.util.concurrent.TimeUnit;

public class TestFlight extends BasePage {

    public void setUp() {
        super.setUp();
    }

    @Test
    public void findSelectedFlightTest() {
        homePage.flightButton();
        homePage.leavingFromButton();
        homePage.originTextBoxField("Warsaw, Poland (WAW-Frederic Chopin)");
    }

    @Test
    public void login() {
        homePage.signInTab();
        SignInPage sip = homePage.signInButton();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); // for manual captch handling
        sip.loginValidUser("nas.botond@gmail.com", "password");
    }
}