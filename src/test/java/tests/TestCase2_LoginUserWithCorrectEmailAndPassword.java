package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class TestCase2_LoginUserWithCorrectEmailAndPassword extends TestBase {

        // 1. Launch browser
        // 2. Navigate to url 'https://automationexercise.com/'
        // 3. Verify that home page is visible successfully
        // 4. Click on 'Signup / Login' button
        // 5. Verify 'Login to your account' is visible
        // 6. Enter correct email address and password
        // 7. Click 'login' button
        // 8. Verify that 'Logged in as username' is visible
        // 9. Click 'Delete Account' button
        // 10. Verify that 'ACCOUNT DELETED!' is visible

@Test
    public void test02 (){
    driver.get("https://automationexercise.com/");

    // 3. Verify that home page is visible successfully
    Assert.assertEquals("https://automationexercise.com/", driver.getCurrentUrl());
    Assert.assertTrue(driver.findElement(By.xpath("//a[@style='color: orange;']")).isDisplayed());

    // 4. Click on 'Signup / Login' button
    driver.findElement(By.xpath("//a[@href='/login']")).click();

    // 5. Verify 'Login to your account' is visible
    boolean loginIsVisible = driver.findElement(By.xpath("(//h2)[1]")).isDisplayed();
    Assert.assertTrue(loginIsVisible);

    // 6. Enter correct email address and password
    driver.findElement(By.xpath("(//input[@type='email'])[1]")).sendKeys("jude.dubuque@yahoo.com");
    driver.findElement(By.xpath("//input[@type='password']")).sendKeys("12345");

    // 7. Click 'login' button
    driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();

    // 8. Verify that 'Logged in as username' is visible
    boolean loggedInAsUsernameIsDisplayed = driver.findElement(By.partialLinkText("Logged in as")).isDisplayed();
    Assert.assertTrue(loggedInAsUsernameIsDisplayed);
    // 9. Click 'Delete Account' button
    driver.findElement(By.linkText("Delete Account")).click();

    // 10. Verify that 'ACCOUNT DELETED!' is visible
    boolean deleteIsVisible = driver.findElement(By.xpath("(//b)[1]")).isDisplayed();
    Assert.assertTrue(deleteIsVisible);

    }

}