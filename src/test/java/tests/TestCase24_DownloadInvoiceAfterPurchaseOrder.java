package tests;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class TestCase24_DownloadInvoiceAfterPurchaseOrder extends TestBase {


        // 1. Launch browser
        // 2. Navigate to url 'https://automationexercise.com/'
        // 3. Verify that home page is visible successfully
        // 4. Add products to cart
        // 5. Click 'Cart' button
        // 6. Verify that cart page is displayed
        // 7. Click Proceed To Checkout
        // 8. Click 'Register / Login' button
        // 9. Fill all details in Signup and create account
        // 10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        // 11. Verify ' Logged in as username' at top
        // 12.Click 'Cart' button
        // 13. Click 'Proceed To Checkout' button
        // 14. Verify Address Details and Review Your Order
        // 15. Enter description in comment text area and click 'Place Order'
        // 16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        // 17. Click 'Pay and Confirm Order' button
        // 18. Verify success message 'Your order has been placed successfully!'
        // 19. Click 'Download Invoice' button and verify invoice is downloaded successfully.
        // 20. Click 'Continue' button
        // 21. Click 'Delete Account' button
        // 22. Verify 'ACCOUNT DELETED!' and click 'Continue' button
    @Test
    public void downloadInvoiceAfterPurchaseOrderTest() throws InterruptedException {
        // 2. Navigate to url 'https://automationexercise.com/'
        driver.get("https://automationexercise.com/");
        // 3. Verify that home page is visible successfully
        boolean isVisible = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']")).isDisplayed();
        Assert.assertTrue(isVisible);
        // 4. Add products to cart
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        WebElement tshirt= driver.findElement(By.className("product-overlay"));
        actions.moveToElement(tshirt).perform();
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//a[@data-product-id='2'])[1]")).click();
        // 5. Click 'Cart' button
        Thread.sleep(2000);
        WebElement cartClick=driver.findElement(By.linkText("View Cart"));
        cartClick.click();
        // 6. Verify that cart page is displayed
        Assert.assertTrue(driver.findElement(By.className("active")).isDisplayed());
        // 7. Click Proceed To Checkout
        Thread.sleep(2000);
        WebElement proceedToCheckoutButton=driver.findElement(By.linkText("Proceed To Checkout"));
        proceedToCheckoutButton.click();
        // 8. Click 'Register / Login' button
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[@href='/login'])[2]")).click();
        // 9. Fill all details in Signup and create account
        Thread.sleep(2000);
        driver.findElement(By.name("name")).sendKeys("Ali");
        Faker faker=new Faker();
        String email=faker.internet().emailAddress();
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys(email);
        Thread.sleep(7000);
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
        Thread.sleep(2000);
        // 10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        WebElement title=driver.findElement(By.id("id_gender2"));
        title.click();
        driver.findElement(By.id("password")).sendKeys("54321");
        WebElement day=driver.findElement(By.id("days"));
        new Select(day).selectByIndex(20);
        WebElement month=driver.findElement(By.id("months"));
        new Select(month).selectByIndex(2);
        WebElement year=driver.findElement(By.id("years"));
        new Select(year).selectByValue("1999");
        driver.findElement(By.id("optin")).click();
        driver.findElement(By.id("first_name")).sendKeys("Ali");
        driver.findElement(By.id("last_name")).sendKeys("Can");
        driver.findElement(By.id("company")).sendKeys("TechPro");
        driver.findElement(By.id("address1")).sendKeys("3524 78TH ST JACKSON HEIGHTS NY 11372-4739 USA");
        WebElement country=driver.findElement(By.id("country"));
        new Select(country).selectByIndex(5);
        driver.findElement(By.id("state")).sendKeys("asdfg");
        driver.findElement(By.id("city")).sendKeys("Ny");
        driver.findElement(By.id("zipcode")).sendKeys("11372-4739");
        driver.findElement(By.id("mobile_number")).sendKeys("05325555555");
        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//h2")).isDisplayed());
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();


        driver.navigate().refresh();

        // 11. Verify ' Logged in as username' at top
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
        Assert.assertTrue(driver.findElement(By.className("pull-right")).isDisplayed());

        // 12.Click 'Cart' button
        Thread.sleep(10000);
        WebElement cart=driver.findElement(By.partialLinkText("Cart"));
        Thread.sleep(2000);
        cart.click();
        // 13. Click 'Proceed To Checkout' button
        Thread.sleep(10000);
        WebElement checkoutButton=driver.findElement(By.xpath("//a[@class='btn btn-default check_out']"));
        checkoutButton.click();
        // 14. Verify Address Details and Review Your Order
        String addressDetails=driver.findElement(By.id("address_delivery")).getText();
                Assert.assertTrue(addressDetails.contains("Mrs. Ali Can"));
                Assert.assertTrue(addressDetails.contains("TechPro"));
                Assert.assertTrue(addressDetails.contains("3524 78TH ST JACKSON HEIGHTS NY 11372-4739 USA"));
                Assert.assertTrue(addressDetails.contains("Ny asdfg 11372-4739"));
                Assert.assertTrue(addressDetails.contains("New Zealand"));
                Assert.assertTrue(addressDetails.contains("05325555555"));

        driver.findElement(By.linkText("Men Tshirt")).isDisplayed();
        Thread.sleep(10000);
        WebElement totalAmount=driver.findElement(By.className("cart_total_price"));
        totalAmount.getText().contains("Rs. 400");

        // 15. Enter description in comment text area and click 'Place Order'
        Thread.sleep(2000);
        driver.findElement(By.name("message")).sendKeys("Please gift wrap");
        driver.findElement(By.linkText("Place Order")).click();

        // 16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        driver.findElement(By.className("form-control")).sendKeys("Ziraat");
        driver.findElement(By.name("card_number")).sendKeys("7474858596962323");
        driver.findElement(By.name("cvc")).sendKeys("333");
        driver.findElement(By.name("expiry_month")).sendKeys("03");
        driver.findElement(By.name("expiry_year")).sendKeys("2029");
        // 17. Click 'Pay and Confirm Order' button
        Thread.sleep(7000);
        driver.findElement(By.id("submit")).click();
        // 18. Verify success message 'Your order has been placed successfully!'
        Thread.sleep(10000);
        boolean orderPlaced = driver.findElement(By.xpath("//h2[@class='title text-center']")).isDisplayed();
        Assert.assertTrue(orderPlaced);
        // 19. Click 'Download Invoice' button and verify invoice is downloaded successfully.
        Thread.sleep(3000);
        driver.findElement(By.linkText("Download Invoice")).click();

        String homeDirectory = System.getProperty("user.home");
        String filePath = homeDirectory+"/Downloads/invoice.txt"; //"C:\Users\Toshiba\Downloads\invoice.txt"
        Thread.sleep(5000);
        boolean isDownloaded = Files.exists(Paths.get(filePath));
        Assert.assertTrue(isDownloaded);
        // 20. Click 'Continue' button
        Thread.sleep(5000);
        driver.findElement(By.linkText("Continue")).click();
        // 21. Click 'Delete Account' button
        Thread.sleep(10000);
        driver.findElement(By.xpath("(//a[@style='color:brown;'])[2]")).click();
        // 22. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        Thread.sleep(5000);
        String deletedMessage=driver.findElement(By.xpath("//h2[@data-qa='account-deleted']")).getText();
        Assert.assertEquals("ACCOUNT DELETED!",deletedMessage);
        Thread.sleep(5000);
        driver.findElement(By.className("pull-right")).click();




    }

}
