package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;

    // Define the page elements (locators)
    private final By fromField = By.id("from");
    private final By destinationField = By.id("to");
    private final By dateField = By.xpath("/html/body/div[1]/main/div/form/div[2]/fieldset[3]/div/button/span");
    private final By searchButton = By.xpath("//*[@id='__nuxt']/main/div/form/div[2]/button");
    private final By flightResults = By.xpath("//*[@id='__nuxt']/main/div/section/ul");

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to enter flight details
    public void enterFlightDetails(String departureCity, String destinationCity, String date) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for and interact with the "from" field
        WebElement fromInput = wait.until(ExpectedConditions.visibilityOfElementLocated(fromField));
        fromInput.clear();
        fromInput.sendKeys(departureCity);

        // Wait for and interact with the "to" field
        WebElement destinationInput = wait.until(ExpectedConditions.visibilityOfElementLocated(destinationField));
        destinationInput.clear();
        destinationInput.sendKeys(destinationCity);

        // Interact with the date field
        WebElement dateInput = wait.until(ExpectedConditions.elementToBeClickable(dateField));
        dateInput.click(); // Interact with the calendar widget if needed
        // Add a 2-second delay before pressing Enter
        try {
            Thread.sleep(1000); // 2000 milliseconds = 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Create an Actions object to simulate pressing the Enter key
        Actions actions = new Actions(driver);
        actions.sendKeys(dateInput, Keys.ENTER).perform();
      // dateInput.sendKeys(date);
    }

    // Method to click on search button
    public void clickSearch() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchBtn.click();
    }

    // Method to verify if flight results are displayed
    public boolean areFlightResultsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(flightResults)).isDisplayed();
    }
}
