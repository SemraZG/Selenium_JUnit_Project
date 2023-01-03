package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import static org.junit.Assert.*;

public class TestCase7_VerifyTestCasesPage extends TestBase {
    private Object assertTrue;

        // 1. Launch browser
        // 2. Navigate to url 'https://automationexercise.com/'
        // 3. Verify that home page is visible successfullyT
        // 4. Click on 'Test Cases' button
        // 5. Verify user is navigated to test cases page successfully

    @Test

    public void VerifyTestCasesPage() throws InterruptedException {
       // 2. Navigate to url 'https://automationexercise.com/'
        driver.get( "https://automationexercise.com/");

      // 3. Verify that home page is visible successfullyT

        Thread.sleep(3000);

        assertTrue(driver.findElement(By.xpath("//a[@href = '/products']")).isEnabled());

        // 4. Click on 'Test Cases' button
        driver.findElement(By.xpath("//a[@href = '/test_cases']")).click();

        // 5. Verify user is navigated to test cases page successfully
        assertTrue(driver.findElement(By.partialLinkText("Test Case")).isEnabled());


    }



}
