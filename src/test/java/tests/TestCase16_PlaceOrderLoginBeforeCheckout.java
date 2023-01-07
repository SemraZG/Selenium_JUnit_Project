package tests;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestCase16_PlaceOrderLoginBeforeCheckout extends TestBase {

        // 1. Launch browser
        // 2. Navigate to url 'https://automationexercise.com/'
        // 3. Verify that home page is visible successfully
        // 4. Click 'Signup / Login' button
        // 5. Fill email, password and click 'Login' button
        // 6. Verify 'Logged in as username' at top
        // 7. Add products to cart
        // 8. Click 'Cart' button
        // 9. Verify that cart page is displayed
        // 10. Click Proceed To Checkout
        // 11. Verify Address Details and Review Your Order
        // 12. Enter description in comment text area and click 'Place Order'
        // 13. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        // 14. Click 'Pay and Confirm Order' button
        // 15. Verify success message 'Your order has been placed successfully!'
        // 16. Click 'Delete Account' button
        // 17. Verify 'ACCOUNT DELETED!' and click 'Continue' button

    @Test
    public void placeOrderLoginBeforeCheckout() throws InterruptedException {
        // 2. Navigate to url 'https://automationexercise.com/'
        driver.get("https://automationexercise.com/");

        // 3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.linkText("Home"));
        Assert.assertTrue(homePage.isDisplayed());

        // 4. Click 'Signup / Login' button
        Thread.sleep(7000);
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        // 5. Fill email, password and click 'Login' button
        driver.findElement(By.xpath("//input[@type='email'][1]")).sendKeys("christian.aufderhar@yahoo.com");
        Thread.sleep(7000);
        driver.findElement(By.name("password")).sendKeys("54321");
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();

        // 6. Verify 'Logged in as username' at top
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.className("pull-right")).isDisplayed());

        // 7. Add products to cart

        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        WebElement tshirt= driver.findElement(By.xpath("//div[@class='product-overlay']"));
        actions.moveToElement(tshirt).perform();
        Thread.sleep(5000);
        //driver.findElement(By.xpath("(//a[@data-product-id='2'])[2]")).click();

       // driver.findElement(By.xpath("(//a[@data-product-id='1'])[1]")).submit();


        // 8. Click 'Cart' button
       driver.findElement(By.linkText("View Cart")).click();

        // 9. Verify that cart page is displayed
       // Assert.assertTrue(driver.findElement(By.className("active")).isDisplayed());

        // 10. Click Proceed To Checkout
        //Thread.sleep(10000);
        //WebElement proceedToCheckoutButton=driver.findElement(By.xpath("//a[@class='btn btn-default check_out']"));
        //proceedToCheckoutButton.click();

        // 11. Verify Address Details and Review Your Order
        //String addressDetails=driver.findElement(By.id("address_delivery")).getText();
        //Assert.assertTrue(addressDetails.contains("Mrs. Ali Can"));
        //Assert.assertTrue(addressDetails.contains("TechPro"));
        //Assert.assertTrue(addressDetails.contains("3524 78TH ST JACKSON HEIGHTS NY 11372-4739 USA"));
        //Assert.assertTrue(addressDetails.contains("Ny asdfg 11372-4739"));
        //Assert.assertTrue(addressDetails.contains("New Zealand"));
        //Assert.assertTrue(addressDetails.contains("05325555555"));

        //List<WebElement> reviewOrder = driver.findElements(By.xpath("//table[@class='table table-condensed']//tr//td"));
        //int order = 1;
        //for(WebElement w : reviewOrder){
        //    System.out.println(w.getText());
        //    order++;
        //}

        // 12. Enter description in comment text area and click 'Place Order'
        //driver.findElement(By.name("message")).sendKeys("Thank you!");
        //driver.findElement(By.xpath("//a[@href='/payment']")).click();
        //driver.navigate().refresh();
        //driver.findElement(By.xpath("//a[@href='/payment']")).click();

        // 13. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        //driver.findElement(By.className("form-control")).sendKeys("Akbank");
        //driver.findElement(By.name("card_number")).sendKeys("123456789");
        //driver.findElement(By.name("cvc")).sendKeys("123");
        //driver.findElement(By.name("expiry_month")).sendKeys("03");
        //driver.findElement(By.name("expiry_year")).sendKeys("2023");

        // 14. Click 'Pay and Confirm Order' button
        //driver.findElement(By.id("submit")).click();

        // 15. Verify success message 'Your order has been placed successfully!'
        //String successMessage = driver.findElement(By.linkText("Congratulations! Your order has been confirmed!")).getText();
        //assertEquals("Your order has been placed successfully!",successMessage);

        // 16. Click 'Delete Account' button
        // 17. Verify 'ACCOUNT DELETED!' and click 'Continue' button
    }
}
