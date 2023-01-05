package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class TestCase3_LoginUserWithIncorrectEmailAndPassword extends TestBase {
    @Test
    public void test03(){
        // 1. Launch browser
        // 2. Navigate to url 'https://automationexercise.com/'
        driver.get("https://automationexercise.com/");
        // 3. Verify that home page is visible successfully
        Assert.assertTrue(driver.getPageSource().contains("AutomationExercise"));
        // 4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        // 5. Verify 'Login to your account' is visible
        Assert.assertTrue(driver.getPageSource().contains("Login to your account"));
        // 6. Enter incorrect email address and password
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("my@gmail.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("1234");
        // 7. Click 'login' button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        // 8. Verify error 'Your email or password is incorrect!' is visible
        Assert.assertTrue(driver.getPageSource().contains("Your email or password is incorrect!"));

    }




}
