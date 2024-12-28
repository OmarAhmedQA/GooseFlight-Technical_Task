package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.HomePage;

import java.time.Duration;

public class FlightSearchTest {
    WebDriver driver;
    HomePage homePage;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://travel-agency-booking-app.netlify.app/");
        homePage = new HomePage(driver);
    }

    @Test
    public void testFlightSearch() {
        try {
            homePage.enterFlightDetails("New York", "London", "2024-12-25");
            homePage.clickSearch();
            Assert.assertTrue(homePage.areFlightResultsDisplayed(), "Flight results are not displayed.");
        } catch (Exception e) {
           // Assert.assertTrue("Test passed without exceptions.", true);

            Assert.fail("Test failed due to an unexpected exception: " + e.getMessage());
        }
    }


    @Test
    public void testHomepageLoad() {
        try {
            String pageTitle = driver.getTitle();
            Assert.assertTrue(pageTitle.contains("Travel Booking App"), "Homepage title does not contain expected text.");
        } catch (Exception e) {
            Assert.fail("Test failed due to an unexpected exception: " + e.getMessage());
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
