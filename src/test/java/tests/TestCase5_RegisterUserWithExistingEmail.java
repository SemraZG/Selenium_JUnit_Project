package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class TestCase5_RegisterUserWithExistingEmail extends TestBase {
        // 1. Launch browser
    @Test
    public void registerUser() {
        // 2. Navigate to url 'https://automationexercise.com/'
        driver.get("https://automationexercise.com/");
        // 3. Verify that home page is visible successfully
        Assert.assertEquals("https://automationexercise.com/", driver.getCurrentUrl());
        Assert.assertTrue(driver.findElement(By.xpath("//a[@style='color: orange;']")).isDisplayed());

        // 4. Click on 'Signup / Login' button
        driver.findElement(By.linkText("Signup / Login")).click();

        // 5. Verify 'New User Signup!' is visible
        boolean newUserSignUp = driver.findElement(By.xpath("//h2[.='New User Signup!']")).isDisplayed();
        Assert.assertTrue(newUserSignUp);

        // 6. Enter name and already registered email address
        driver.findElement(By.name("name")).sendKeys("merve");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("abc@gmail.com");

        // 7. Click 'Signup' button
        driver.findElement(By.xpath("//button[@data-qa=\"signup-button\"]")).submit();

        // 8. Verify error 'Email Address already exist!' is visible
        boolean registered = driver.findElement(By.xpath("//p[.='Email Address already exist!']")).isDisplayed();
        Assert.assertTrue(registered);


    }
}
