package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ToursPage extends BaseClass{
    @FindBy(how = How.TAG_NAME, using = "body")
    private static WebElement body;

    public ToursPage(WebDriver driver) {
        super(driver);
    }

    public void checkifUserIsInToursPage(String text) {
        Assert.assertTrue(body.getText().contains(text));
    }

    public void selectOption(String button) {
        System.out.println(button);
        driver.findElement(By.xpath("(//button[contains(text(),'" + button + "')])")).click();
    }
}
