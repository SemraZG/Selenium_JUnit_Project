package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class TestCase10_VerifySubscriptionInHomePage extends TestBase {

    // 1. Launch browser
    // 2. Navigate to url 'https://automationexercise.com/'
    // 3. Verify that home page is visible successfully
    // 4. Scroll down to footer
    // 5. Verify text 'SUBSCRIPTION'
    // 6. Enter email address in input and click arrow button
    // 7. Verify success message 'You have been successfully subscribed!' is visible
    @Test
    public void VerifySubscriptionInHomePageTest() throws InterruptedException {
        // 2. Navigate to url 'https://automationexercise.com/'
        driver.get("https://automationexercise.com/");
        // 3. Verify that home page is visible successfully
        boolean isVisible = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']")).isDisplayed();
        Assert.assertTrue(isVisible);
        // 4. Scroll down to footer
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();

        // 5. Verify text 'SUBSCRIPTION'
        String subscriptionText = driver.findElement(By.xpath("//h2[.='Subscription']")).getText();
        Assert.assertEquals("SUBSCRIPTION", subscriptionText);
        // 6. Enter email address in input and click arrow button
        Thread.sleep(5000);
        driver.findElement(By.id("susbscribe_email")).sendKeys("abd@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//i[@class='fa fa-arrow-circle-o-right']")).click();
        // 7. Verify success message 'You have been successfully subscribed!' is visible
       WebElement successMessage=driver.findElement(By.xpath("//div[@class='alert-success alert']"));
       successMessage.isDisplayed();
    }
}