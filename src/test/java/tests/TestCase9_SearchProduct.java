package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCase9_SearchProduct extends TestBase {

        // 1. Launch browser
        // 2. Navigate to url 'https://automationexercise.com/'
        // 3. Verify that home page is visible successfully
        // 4. Click on 'Products' button
        // 5. Verify user is navigated to ALL PRODUCTS page successfully
        // 6. Enter product name in search input and click search button
        // 7. Verify 'SEARCHED PRODUCTS' is visible
        // 8. Verify all the products related to search are visible


    @Test
    public void searchProduct() throws InterruptedException {
        // 2. Navigate to url 'https://automationexercise.com/'
        driver.get("https://automationexercise.com/");

        // 3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.linkText("Home"));
        Assert.assertTrue(homePage.isDisplayed());

        // 4. Click on 'Products' button
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        Thread.sleep(5000);
        driver.navigate().refresh();
        driver.findElement(By.xpath("//a[@href='/products']")).click();

        // 5. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement allProduct = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(allProduct.isDisplayed());


        // 6. Enter product name in search input and click search button
        driver.findElement(By.id("search_product")).sendKeys("Blue Top");
        driver.findElement(By.id("submit_search")).click();

        // 7. Verify 'SEARCHED PRODUCTS' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//h2[@class='title text-center']")).isDisplayed());
        driver.navigate().refresh();
        Thread.sleep(7000);
        WebElement searchProducts = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(searchProducts.isDisplayed());

        // 8. Verify all the products related to search are visible
        WebElement relatedProducts = driver.findElement(By.className("features_items"));
        Assert.assertTrue(relatedProducts.isDisplayed());
    }

}
