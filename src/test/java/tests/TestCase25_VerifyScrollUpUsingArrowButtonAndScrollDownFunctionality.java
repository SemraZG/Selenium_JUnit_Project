package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class TestCase25_VerifyScrollUpUsingArrowButtonAndScrollDownFunctionality extends TestBase {
    @Test
    public void test(){
        // 1. Launch browser
        // 2. Navigate to url 'https://automationexercise.com/'
        driver.get("https://automationexercise.com/");

        // 3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("(//a[@href='/'])[1]"));
        Assert.assertTrue(homePage.isDisplayed());

        // 4. Scroll down page to bottom
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
        // 5. Verify 'SUBSCRIPTION' is visible
       WebElement subscription = driver.findElement(By.xpath("//div[@class='single-widget']"));
       Assert.assertTrue(subscription.isDisplayed());
        // 6. Click on arrow at bottom right side to move upward
        driver.findElement(By.xpath("//i[@class='fa fa-angle-up']")).click();
        // 7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
        WebElement ffp =driver.findElement(By.xpath("//*[.='Full-Fledged practice website for Automation Engineers']"));
        Assert.assertTrue(ffp.isDisplayed());

    }



}
