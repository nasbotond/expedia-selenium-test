import org.junit.*;
import java.util.concurrent.TimeUnit;

public class HomePageTest extends BaseTest {

    public void setUp() {
        super.setUp();
    }

    @Test
    public void pageTitleMatchesExpected() {
        String pageTitle = homePage.getTitleText();
        Assert.assertTrue(pageTitle.contains("Expedia Travel: Vacation Homes, Hotels, Car Rentals, Flights & More"));
    }
}