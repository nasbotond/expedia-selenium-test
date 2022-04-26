import org.junit.*;
import java.util.concurrent.TimeUnit;

public class FlightBookingTest extends BaseTest {

    public void setUp() {
        super.setUp();
    }

    @Test
    public void findSelectedFlightTest() {
        homePage.flightButton();
        homePage.leavingFromButton();
        homePage.originTextBoxField("Warsaw, Poland (WAW-Frederic Chopin)");
    }
}