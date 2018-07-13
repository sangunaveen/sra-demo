package helpers;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebDriverHelpers {

    static WebDriver driver;

    private static String bodyElementText(WebDriver driver)
    {
        return driver.findElement(By.tagName("body")).getText();
    }


    public static void openAdminPanel(WebDriver driver) throws InterruptedException {
        WebDriverHelpers.driver = driver;
       // driver.get("http://se.testersworld.com/");
        driver.get("https://themes.shopify.com/themes/venture/styles/outdoors/preview");
       // Log.info("I am at admin panel page");
        Thread.sleep(5000);
      //  Assert.assertTrue(driver.findElement(By.className("account-content")).isDisplayed());
        Assert.assertTrue(driver.getTitle().equals("Preview Outdoors Theme - Venture Ecommerce Website Template"));
    }

    public static boolean textExists(WebDriver driver,String text) {
        return bodyElementText(driver).contains(text);
    }

    public static void openButton(String buttonText) {
        driver.findElement(By.xpath("//button[text()='"+buttonText+"']")).click();
    }

    public static void waitForSecs(int secs) {
        try {
            Thread.sleep(secs*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
