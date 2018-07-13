package pageobjects;

import helpers.WebDriverHelpers;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BaseClass{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //locators/////

    @FindBy(how = How.XPATH, using = "//a[@href='#TOURS']")
    private static WebElement tourTab;

    @FindBy(how = How.LINK_TEXT, using = "VISA")
    private static WebElement visaTab;

    @FindBy(how = How.XPATH, using = "//a[@href='#HOTELS']")
    private static WebElement hotelsTab;

    @FindBy(how = How.XPATH, using = "//button[text()='Next']")
            private static WebElement submitButton;


    @FindBy(how = How.XPATH, using = "(//button[contains(text(),'Search')])[2]")
    private static WebElement searchTours;

    /////////actions/methods-------//////

    public void gotoToursTab(String tabName) {
        if(tabName.equalsIgnoreCase("tours"))
            tourTab.click();
        else if(tabName.equalsIgnoreCase("visa"))
            visaTab.click();
        else if(tabName.equalsIgnoreCase("hotels"))
            hotelsTab.click();
    }

    public void search(){


    }

    public void waitAndClickOnSearch() {
        WebDriverWait webDriverWait = new WebDriverWait(driver,60);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[contains(text(),'Search')])[2]")));
        searchTours.click();
    }

    public void selectTravelMode(String mode) {
        Select select = new Select(driver.findElement(By.xpath("//select[@data-ivisa-name='traveling_by']")));
        select.selectByVisibleText(mode);

    }

    public void submitTheForm() {
           submitButton.click();
    }

    public void checkErrorMessage(String error) {
        if(error.equalsIgnoreCase(""))
        {
            Assert.assertFalse(WebDriverHelpers.textExists(driver,"ETA is only required for arrival via Air"));
        }
        Assert.assertTrue(WebDriverHelpers.textExists(driver,error));
    }
}
