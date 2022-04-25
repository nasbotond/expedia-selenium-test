import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.support.ui.*;


public class TestFlight extends BasePage {

    public void setUp(){
        super.setUp();
    }

    @Test
    public void findSelectedFlightTest() {
        homePage.flightButton();
        homePage.leavingFromButton();
        homePage.originTextBoxField("Warsaw, Poland (WAW-Frederic Chopin)");
    }
}