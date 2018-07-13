package step_definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.WebDriverHelpers;
import javafx.event.WeakEventHandler;
import org.junit.Assert;
import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.HomePage;
import pageobjects.ToursPage;

import java.util.concurrent.TimeUnit;

public class toursStepDefs {

    public WebDriver driver;
    HomePage homePage;
    ToursPage toursPage;

    public toursStepDefs() {
        driver = Hooks.driver;
    }


    @Given("^user is in landing page$")
    public void user_is_in_landing_page() throws Throwable {

        Assert.assertTrue(driver.findElement(By.className("navbar-brand")).isDisplayed());
    }



    @When("^fill the destination as \"(.*?)\"$")
    public void fill_the_destination_as(String destination) throws Throwable {
        System.out.println(destination);
        WebDriverHelpers.waitForSecs(3);
        driver.findElement(By.id("s2id_autogen10")).sendKeys(destination);
        WebDriverHelpers.waitForSecs(3);
        driver.findElement(By.className("select2-result-label")).click();
    }

    @When("^leave the default option and search$")
    public void leave_the_default_option_and_search() throws Throwable {

        homePage.waitAndClickOnSearch();
    }


    @Then("^he should see \"(.*?)\" text$")
    public void he_should_see_text(String text) throws Throwable {

        System.out.println(text);
        toursPage = new ToursPage(driver);
        toursPage.checkifUserIsInToursPage(text);
    }

    @When("^he select to \"([^\"]*)\"$")
    public void heSelectTo(String button) throws Throwable {
        toursPage = new ToursPage(driver);
        toursPage.selectOption(button);

    }

    @Given("^user is in landing pages$")
    public void userIsInLandingPages() throws Throwable {


    }

    @When("^he select to \"([^\"]*)\" and \"([^\"]*)\"$")
    public void heSelectToAnd(String arg0, String arg1) throws Throwable {
        System.out.println(arg0);
        System.out.println(arg1);
    }

    @When("^he go to \"([^\"]*)\" tab$")
    public void heGoToTab(String tab) throws Throwable {
        homePage = new HomePage(driver);
        homePage.gotoToursTab(tab);
    }

    @When("^he select the travelling by option$")
    public void heSelectTheTravellingByOption() throws Throwable {

    }

    @And("^he select the travelling by option as \"([^\"]*)\"$")
    public void heSelectTheTravellingByOptionAs(String mode) throws Throwable {
        System.out.println(mode);
        homePage.selectTravelMode(mode);
    }

    @And("^submits the form$")
    public void submitsTheForm() throws Throwable {
        homePage.submitTheForm();
    }

    @Then("^he should not see an error message$")
    public void heShouldNotSeeAnErrorMessage() throws Throwable {

    }

    @Then("^he should see and error message \"([^\"]*)\"$")
    public void heShouldSeeAndErrorMessage(String error) throws Throwable {

        homePage.checkErrorMessage(error);
    }
}
