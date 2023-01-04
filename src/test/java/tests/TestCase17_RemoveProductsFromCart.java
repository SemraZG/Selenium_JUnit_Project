package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class TestCase17_RemoveProductsFromCart extends TestBase {

        // 1. Launch browser
        // 2. Navigate to url 'https://automationexercise.com/'
        // 3. Verify that home page is visible successfully
        // 4. Add products to cart
        // 5. Click 'Cart' button
        // 6. Verify that cart page is displayed
        // 7. Click 'X' button corresponding to particular product
        // 8. Verify that product is removed from the cart
@Test
    public void test() throws InterruptedException {
    // 2. Navigate to url 'https://automationexercise.com/'
    driver.get("https://automationexercise.com/");
    // 3. Verify that home page is visible successfully
    Assert.assertTrue(driver.findElement(By.id("slider")).isDisplayed());
    // 4. Add products to cart
    driver.findElement(By.xpath("(//a[@data-product-id='1'])[1]")).click();
    // 5. Click 'Cart' button
    Thread.sleep(3000);
    driver.findElement(By.xpath("//u")).click();
    // 6. Verify that cart page is displayed
   Assert.assertTrue(driver.findElement(By.id("cart_items")).isDisplayed());
    // 7. Click 'X' button corresponding to particular product
    driver.findElement(By.xpath("//i[@class='fa fa-times']")).click();
    // 8. Verify that product is removed from the cart
    Thread.sleep(2000);
   String isCartEmpty=driver.findElement(By.xpath("//b[.='Cart is empty!']")).getText();
    System.out.println(isCartEmpty);
   Assert.assertEquals("Cart is empty!", isCartEmpty);

}
}
