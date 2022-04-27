import org.junit.*;
import java.util.concurrent.TimeUnit;

public class OpenTripsTest extends BaseTest {

    public void setUp() {
        super.setUp();
    }

    @Test
    public void tripsOpensCorrectly() {
        TripsPage tripsPage = homePage.tripsTab();
        Assert.assertTrue(tripsPage.getHeaderText().contains("Trips"));
    }
}