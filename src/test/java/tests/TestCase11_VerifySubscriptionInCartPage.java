package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class TestCase11_VerifySubscriptionInCartPage extends TestBase {

        // 1. Launch browser
        // 2. Navigate to url 'https://automationexercise.com/'
        // 3. Verify that home page is visible successfully
        // 4. Click 'Cart' button
        // 5. Scroll down to footer
        // 6. Verify text 'SUBSCRIPTION'
        // 7. Enter email address in input and click arrow button
        // 8. Verify success message 'You have been successfully subscribed!' is visible
@Test
    public void verifySubscriptionInCartPageTest() throws InterruptedException {
    // 2. Navigate to url 'https://automationexercise.com/'
    driver.get("https://automationexercise.com/");
    // 3. Verify that home page is visible successfully
    boolean isVisible = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']")).isDisplayed();
    Assert.assertTrue(isVisible);
    
    // 4. Click 'Cart' button
    Thread.sleep(2000);
    driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]")).click();
    // 5. Scroll down to footer
    Actions actions=new Actions(driver);
    actions.sendKeys(Keys.PAGE_DOWN);
    // 6. Verify text 'SUBSCRIPTION'
    String subscriptionText=driver.findElement(By.xpath("//h2")).getText();
    Assert.assertEquals("SUBSCRIPTION",subscriptionText);
    // 7. Enter email address in input and click arrow button
    driver.findElement(By.id("susbscribe_email")).sendKeys("abc@gmail.com");
    driver.findElement(By.xpath("//i[@class='fa fa-arrow-circle-o-right']")).click();
    // 8. Verify success message 'You have been successfully subscribed!' is visible
    String successMessage=driver.findElement(By.xpath("//div[@class='alert-success alert']")).getText();
    Assert.assertEquals("You have been successfully subscribed!",successMessage);

}
}
