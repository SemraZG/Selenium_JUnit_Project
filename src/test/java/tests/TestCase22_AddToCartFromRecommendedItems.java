package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class TestCase22_AddToCartFromRecommendedItems extends TestBase {

        // 1. Launch browser
        // 2. Navigate to url 'https://automationexercise.com/'
        // 3. Scroll to bottom of page
        // 4. Verify 'RECOMMENDED ITEMS' are visible
        // 5. Click on 'Add To Cart' on Recommended product
        // 6. Click on 'View Cart' button
        // 7. Verify that product is displayed in cart page

    @Test
    public void test() throws InterruptedException {

        // 2. Navigate to url 'https://automationexercise.com/'
        driver.navigate().to("https://automationexercise.com/");

        // 3. Scroll to bottom of page
        Actions actions=new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();

        // 4. Verify 'RECOMMENDED ITEMS' are visible
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='recommended_items']")).isDisplayed());

        // 5. Click on 'Add To Cart' on Recommended product
        driver.findElement(By.xpath("(//a[@data-product-id='4'])[3]")).click();

        // 6. Click on 'View Cart' button
        driver.findElement(By.xpath("//u[.='View Cart']")).click();

        // 7. Verify that product is displayed in cart page
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.xpath("//img[@src='get_product_picture/4']")).isDisplayed());

    }

}
