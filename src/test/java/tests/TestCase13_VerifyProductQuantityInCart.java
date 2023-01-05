package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class TestCase13_VerifyProductQuantityInCart extends TestBase {

        // 1. Launch browser
        // 2. Navigate to url 'https://automationexercise.com/'
        // 3. Verify that home page is visible successfully
        // 4. Click 'View Product' for any product on home page
        // 5. Verify product detail is opened
        // 6. Increase quantity to 4
        // 7. Click 'Add to cart' button
        // 8. Click 'View Cart' button
        // 9. Verify that product is displayed in cart page with exact quantity

    @Test
    public void test() throws InterruptedException {
        // 2. Navigate to url 'https://automationexercise.com/'
        driver.navigate().to("https://automationexercise.com/");

        // 3. Verify that home page is visible successfully
         Assert.assertTrue(driver.findElement(By.id("slider-carousel")).isDisplayed());

        // 4. Click 'View Product' for any product on home page---->(1.ürünü seçtim)
         driver.findElement(By.xpath("(//a[@style='color: brown;'])[1]")).click();

            Thread.sleep(7000);
            driver.navigate().refresh();
            driver.findElement(By.xpath("(//a[@style='color: brown;'])[1]")).click();

        // 5. Verify product detail is opened

          WebElement productDetail= driver.findElement(By.xpath("//div[@class='product-information']"));
          Assert.assertTrue(productDetail.isDisplayed());

        // 6. Increase quantity to 4
        driver.findElement(By.xpath("//input[@value='1']")).clear();
        driver.findElement(By.xpath("//input[@value='1']")).sendKeys("4");

         Thread.sleep(2000);

        // 7. Click 'Add to cart' button
        driver.findElement(By.xpath("//button[@type='button']")).click();

        // 8. Click 'View Cart' button
        driver.findElement(By.xpath("//a[@href='/view_cart']//u")).click();

        // 9. Verify that product is displayed in cart page with exact quantity
       Assert.assertTrue(driver.findElement(By.xpath("//img[@src='get_product_picture/1']")).isDisplayed());
       String exactQuantity= driver.findElement(By.xpath("//button[@class='disabled']")).getText();
       Assert.assertEquals("4", exactQuantity);


    }

}
