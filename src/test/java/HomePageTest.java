import org.openqa.selenium.*;
import org.junit.*;
import java.util.concurrent.TimeUnit;
import java.util.*;
import org.openqa.selenium.support.ui.Select;

public class HomePageTest extends BaseTest {

    public void setUp() {
        super.setUp();
    }

    @Test
    public void pageTitleMatchesExpected() {
        String pageTitle = homePage.getTitleText();
        Assert.assertTrue(pageTitle.contains("Expedia Travel: Vacation Homes, Hotels, Car Rentals, Flights & More"));
    }

    @Test
    public void languageSelectionTest() {
        Select languageOptions = homePage.languageSelectorDialog();
        languageOptions.selectByVisibleText("Austria");

        Assert.assertTrue(homePage.getSelectedCountry().contains("Austria"));
    }

    @Test
    public void multipleStaticPageTest() {
        Select languageOptions = homePage.languageSelectorDialog();
        int numberOfOptions = languageOptions.getOptions().size();
        Boolean correct = false;

        for(int i = 0; i < 5; i++) // StaleElement exception if replace the number with numberOfOptions (because of DOM size)
        {
            languageOptions.selectByIndex(i);
            String pageTitle = homePage.getTitleText();
            correct = correct || !pageTitle.contains("Expedia Travel: Vacation Homes, Hotels, Car Rentals, Flights & More");
        }
        Assert.assertFalse(correct);
    }    
}