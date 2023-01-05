package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class TestCase21_AddReviewOnProduct extends TestBase {

    //1. Launch browser
    //2. Navigate to url 'https://automationexercise.com/'
    //3. Click on 'Products' button
    //4. Verify user is navigated to ALL PRODUCTS page successfully
    //5. Click on 'View Product' button
    //6. Verify 'Write Your Review' is visible
    //7. Enter name, email and review
    //8. Click 'Submit' button
    //9. Verify success message 'Thank you for your review.'

    //1. Launch browser
    @Test
    public void AddReviewOnProduct() throws NoSuchElementException, InterruptedException {
//        WebDriverManager.chromedriver().setup();
//        ChromeDriver driver = new ChromeDriver();
//        //2. Navigate to url 'https://automationexercise.com/'
        driver.get("https://www.google.com/");
//        driver.manage().window().maximize();
        driver.navigate().to("https://automationexercise.com/");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //3. Click on 'Products' button
        Thread.sleep(4000);
        driver.findElement(By.xpath("//a[@href='/products']")).click();

//        4. Verify user is navigated to ALL PRODUCTS page successfully
        Thread.sleep(4000);
//
        Assert.assertEquals("https://automationexercise.com/products", driver.getCurrentUrl());
        Assert.assertTrue(driver.findElement(By.xpath("//h2[@class='title text-center']")).isDisplayed());
//
//        5. Click on 'View Product' button
        JavascriptExecutor js= (JavascriptExecutor)driver;
        WebElement button= driver.findElement(By.xpath("//a[@href='/product_details/1']"));
        js.executeScript("arguments[0].click();",button);
//
//        //6. Verify 'Write Your Review' is visible
        Thread.sleep(7000);
        boolean writeYourRevıIsVisible= driver.findElement(By.xpath("//a[@href='#reviews']")).isDisplayed();
        Assert.assertTrue(writeYourRevıIsVisible);
//
//        //7. Enter name, email and review
        Thread.sleep(4000);
//
        driver.findElement(By.id("name")).click();
        Thread.sleep(4000);
        driver.findElement(By.id("name")).sendKeys("Admin");
        driver.findElement(By.id("email")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("email")).sendKeys("admin@gmail.com");
        driver.findElement(By.id("review")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("review")).sendKeys("Great Product");

//       8. Click 'Submit' button

        JavascriptExecutor js2= (JavascriptExecutor)driver;
        WebElement button2= driver.findElement(By.id("button-review"));
        js.executeScript("arguments[0].click();",button2);
        Thread.sleep(4000);
///
////
//        9. Verify success message 'Thank you for your review.'

//       String allertIsVisible = driver.findElement(By.xpath("//div[@class='alert-success alert']//span")).getText();
//        Thread.sleep(7000);
//        Assert.assertEquals("Thank you for your review.",allertIsVisible);

//        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
//        WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert-success alert']//span")));
//        Assert.assertEquals("Thank you for your review.",element.getText());

    }


}