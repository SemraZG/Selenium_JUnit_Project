package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class TestCase8_VerifyAllProductsAndProductDetailPage extends TestBase {
        // 1. Launch browser
    @Test
    public void VerifyAllProductsAndProductDetailPage() throws InterruptedException {
        // 2. Navigate to url 'https://automationexercise.com/'
        driver.get("https://automationexercise.com/");

        // 3. Verify that home page is visible successfully
        Assert.assertEquals("https://automationexercise.com/", driver.getCurrentUrl());
        Assert.assertTrue(driver.findElement(By.xpath("//a[@style='color: orange;']")).isDisplayed());

        // 4. Click on 'Products' button
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@href='/products']")).click();

        // 5. Verify user is navigated to ALL PRODUCTS page successfully
        boolean allProducts = driver.findElement(By.xpath("//h2[@class='title text-center']")).isDisplayed();
        Assert.assertTrue(allProducts);

        // 6. The products list is visible
        boolean productList = driver.findElement(By.xpath("//div[@class='features_items']")).isDisplayed();
        Assert.assertTrue(productList);


        // 7. Click on 'View Product' of first product
        Thread.sleep(5000);
        driver.navigate().refresh();
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement viewProduct = driver.findElement(By.xpath("//a[@href='/product_details/1']"));
        js.executeScript("arguments[0].click()", viewProduct);

        // 8. User is landed to product detail page
        String title = driver.getTitle();
        Assert.assertEquals(title, "Automation Exercise - Product Details");

        // 9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
        boolean productName = driver.findElement(By.xpath("//h2[.='Blue Top']")).isDisplayed();
        boolean category = driver.findElement(By.xpath("//p[.='Category: Women > Tops']")).isDisplayed();
        boolean price = driver.findElement(By.xpath("//span[.='Rs. 500']")).isDisplayed();
        boolean availability = driver.findElement(By.xpath("//b[.='Availability:']")).isDisplayed();
        boolean condition = driver.findElement(By.xpath("//b[.='Condition:']")).isDisplayed();
        boolean brand = driver.findElement(By.xpath("//b[.='Brand:']")).isDisplayed();

        Assert.assertTrue(productName);
        Assert.assertTrue(category);
        Assert.assertTrue(price);
        Assert.assertTrue(availability);
        Assert.assertTrue(condition);
        Assert.assertTrue(brand);

    }
}
