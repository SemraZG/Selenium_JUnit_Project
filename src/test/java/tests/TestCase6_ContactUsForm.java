package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCase6_ContactUsForm extends TestBase {

        // 1. Launch browser
        // 2. Navigate to url 'https://automationexercise.com/'
        // 3. Verify that home page is visible successfully
        // 4. Click on 'Contact Us' button
        // 5. Verify 'GET IN TOUCH' is visible
        // 6. Enter name, email, subject and message
        // 7. Upload file
        // 8. Click 'Submit' button
        // 9. Click OK button
        // 10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        // 11. Click 'Home' button and verify that landed to home page successfully

    @Test
    public void contactUsFormTest() throws InterruptedException {

        // 2. Navigate to url 'https://automationexercise.com/'
        driver.get("https://automationexercise.com/");

        // 3. Verify that home page is visible successfully
        boolean sliderIsDisplayed = driver.findElement(By.id("slider")).isDisplayed();
        Assert.assertTrue(sliderIsDisplayed);

        // 4. Click on 'Contact Us' button
        driver.findElement(By.linkText("Contact us")).click();

        // 5. Verify 'GET IN TOUCH' is visible
        boolean getInTouchIsDisplayed = driver.findElement(By.xpath("(//h2[@class='title text-center'])[2]")).isDisplayed();
        Assert.assertTrue(getInTouchIsDisplayed);

        // 6. Enter name, email, subject and message
        driver.findElement(By.name("name")).sendKeys("Steve");
        driver.findElement(By.name("email")).sendKeys("steve@jobs.com");
        driver.findElement(By.name("subject")).sendKeys("apple");
        driver.findElement(By.id("message")).sendKeys("Apple Inc. is an American multinational technology company");

        // 7. Upload file
        WebElement chooseAFileButton = driver.findElement(By.name("upload_file"));
        Thread.sleep(2000);

        String userHome = System.getProperty("user.home");
        String pathOfFile = userHome + "\\Desktop\\logo.jpeg";

        chooseAFileButton.sendKeys(pathOfFile);

        // 8. Click 'Submit' button
        driver.findElement(By.name("submit")).submit();

        // 9. Click OK button
        driver.switchTo().alert().accept();

        // 10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        boolean successMessageIsDisplayed = driver.findElement(By.xpath("//div[@class='status alert alert-success']")).isDisplayed();
        Assert.assertTrue(successMessageIsDisplayed);

        // 11. Click 'Home' button and verify that landed to home page successfully

        driver.findElement(By.linkText("Home")).click();

        //AD CLOSE
        driver.navigate().refresh();
        Thread.sleep(5000);
        driver.findElement(By.linkText("Home")).click();

        Thread.sleep(3000);
        boolean sliderIsDisplayed2 = driver.findElement(By.id("slider")).isDisplayed();
        Assert.assertTrue(sliderIsDisplayed2);

    }
}
