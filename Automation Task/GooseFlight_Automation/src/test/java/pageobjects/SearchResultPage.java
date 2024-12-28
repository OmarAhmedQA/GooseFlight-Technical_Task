package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage {
    WebDriver driver;
    By flightResults = By.xpath("//*[@id=\"__nuxt\"]/main/div/section/ul");

    // Constructor
    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to check if flight results are visible
    public boolean areFlightResultsVisible() {
        return driver.findElement(flightResults).isDisplayed();
    }

}

