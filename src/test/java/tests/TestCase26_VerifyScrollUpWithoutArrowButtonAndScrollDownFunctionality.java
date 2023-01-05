package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.time.Duration;

public class TestCase26_VerifyScrollUpWithoutArrowButtonAndScrollDownFunctionality extends TestBase {

    // 1. Launch browser
    // 2. Navigate to url 'https://automationexercise.com/'
    // 3. Verify that home page is visible successfully
    // 4. Scroll down page to bottom
    // 5. Verify 'SUBSCRIPTION' is visible
    // 6. Scroll up page to top
    // 7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen

    @Test
    public void VerifyScrollUp()throws InterruptedException{
        // 1. Launch browser

        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        // 2. Navigate to url 'https://automationexercise.com/'
        driver.navigate().to("https://automationexercise.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 3. Verify that home page is visible successfully
        boolean verifyHomePage= driver.findElement(By.xpath("//a[@href='/']")).isDisplayed();
        Assert.assertTrue(verifyHomePage);

        // 4. Scroll down page to bottom
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
        Thread.sleep(4000);

        // 5. Verify 'SUBSCRIPTION' is visible
        boolean subscription=driver.findElement(By.xpath("//h2[.='Subscription']")).isDisplayed();
        Assert.assertTrue(subscription);

        Thread.sleep(4000);

        // 6. Scroll up page to top

        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");



    }

}