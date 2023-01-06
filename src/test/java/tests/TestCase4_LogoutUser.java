package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class TestCase4_LogoutUser extends TestBase {

        // 1. Launch browser

    @Test
    public void test04(){
        // 2. Navigate to url 'https://automationexercise.com/'
        driver.get("https://automationexercise.com/");
        // 3. Verify that home page is visible successfully
        assertTrue(driver.getPageSource().contains("AutomationExercise"));
        // 4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        // 5. Verify 'Login to your account' is visible
        Boolean isDisplayed=driver.getPageSource().contains("Login to your account");
        assertTrue(isDisplayed);
        // 6. Enter correct email address and password
        driver.findElement(By.name("email")).sendKeys("yilmazmehmet6427@gmail.com");
        driver.findElement(By.name("password")).sendKeys("898815hb");
        // 7. Click 'login' button
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
        // 8. Verify that 'Logged in as username' is visible
        Boolean isDisplayed1=driver.getPageSource().contains("Logged in as username");
        //assertTrue(isDisplayed1);
        // 9. Click 'Logout' button
        driver.findElement(By.xpath("//a[@href='/logout']")).click();
        // 10. Verify that user is navigated to login page
        assertTrue(driver.getPageSource().contains("Login to your account"));
    }



}
