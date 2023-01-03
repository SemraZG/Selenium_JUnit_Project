package tests;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class TestCase14_PlaceOrderRegisterWhileCheckout extends TestBase {

    @Test
    public void test14() throws InterruptedException {
        // 1. Launch browser
        // 2. Navigate to url 'https://automationexercise.com/'
        driver.get("https://automationexercise.com/");
        // 3. Verify that home page is visible successfully
        Assert.assertEquals("https://automationexercise.com/", driver.getCurrentUrl());
        Assert.assertTrue(driver.findElement(By.linkText("Home")).isDisplayed());
        // 4. Add products to cart
        Thread.sleep(7000);
        WebElement addToCart = driver.findElement(By.xpath("(//a[@data-product-id='2'])[1]"));
        Thread.sleep(7000);
        Actions actions= new Actions(driver);
        Thread.sleep(7000);
        actions.moveToElement(addToCart).click().perform();
        driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();



//        // 5. Click 'Cart' button
       driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]")).click();
//        // 6. Verify that cart page is displayed
        driver.findElement(By.xpath("//li[@class='active']")).isDisplayed();
//
//        // 7. Click Proceed To Checkout
       driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
//        // 8. Click 'Register / Login' button
        Faker faker= new Faker();
        String email= faker.internet().emailAddress();
        String name = faker.name().fullName();
       driver.findElement(By.xpath("(//a[@href='/login'])[2]")).click();
        // 9. Fill all details in Signup and create account
        driver.findElement(By.name("name")).sendKeys(name);
        driver.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys(email);
        driver.findElement(By.xpath("(//button[@class='btn btn-default'])[2]")).click();
        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.id("password")).sendKeys("123456");

        WebElement dropdownDays = driver.findElement(By.id("days"));
        Select selectDay = new Select(dropdownDays);
        selectDay.selectByVisibleText("1");

        WebElement dropdownMonth = driver.findElement(By.id("months"));
        Select selectMonth = new Select(dropdownMonth);
        selectMonth.selectByVisibleText("January");

        WebElement dropdownYears = driver.findElement(By.id("years"));
        Select selectYear = new Select(dropdownYears);
        selectYear.selectByVisibleText("1983");

        driver.findElement(By.id("first_name")).sendKeys("Joe");
        driver.findElement(By.id("last_name")).sendKeys("Brown");
        driver.findElement(By.id("company")).sendKeys("Techpro");
        driver.findElement(By.id("address1")).sendKeys("Miami, LA");

        WebElement dropdownCountry = driver.findElement(By.id("country"));
        Select selectCountry = new Select(dropdownCountry);
        selectCountry.selectByVisibleText("United States");
        driver.findElement(By.id("state")).sendKeys("Los Angeles");
        driver.findElement(By.id("city")).sendKeys("Acton");
        driver.findElement(By.id("zipcode")).sendKeys("90001");
        driver.findElement(By.id("mobile_number")).sendKeys("55563223");
        Thread.sleep(7000);
        driver.findElement(By.xpath("(//button[@class='btn btn-default'])[1]")).click();

        // 10. Verify 'ACCOUNT CREATED!' and click 'Continue' button

        boolean verify= driver.findElement(By.xpath("//h2[@class='title text-center']")).isDisplayed();
        Assert.assertTrue(verify);
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();

        // 11. Verify ' Logged in as username' at top
        boolean loggedInAsUsernameIsDisplayed = driver.findElement(By.partialLinkText("Logged in as")).isDisplayed();
        Assert.assertTrue(loggedInAsUsernameIsDisplayed);
        // 12.Click 'Cart' button
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]")).click();
        // 13. Click 'Proceed To Checkout' button
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
        // 14. Verify Address Details and Review Your Order
        boolean addressVerify = driver.findElement(By.xpath("(//h2[@class='heading'])[1]")).isDisplayed();
        Assert.assertTrue(addressVerify);
        boolean reviewOrder = driver.findElement(By.xpath("(//h2[@class='heading'])[2]")).isDisplayed();
        Assert.assertTrue(reviewOrder);
        // 15. Enter description in comment text area and click 'Place Order'
        driver.findElement(By.xpath("//textarea[@class='form-control']")).sendKeys("Nice Shopping");
        driver.findElement(By.xpath("//a[@href='/payment']")).click();
        // 16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        driver.findElement(By.name("name_on_card")).sendKeys("Joe Brown");
        driver.findElement(By.name("card_number")).sendKeys("4444555566662222");
        driver.findElement(By.name("cvc")).sendKeys("165");
        driver.findElement(By.name("expiry_month")).sendKeys("11");
        driver.findElement(By.name("expiry_year")).sendKeys("2026");

        // 17. Click 'Pay and Confirm Order' button
        driver.findElement(By.id("submit")).click();
        // 18. Verify success message 'Your order has been placed successfully!'
        boolean orderPlaced = driver.findElement(By.xpath("//h2[@class='title text-center']")).isDisplayed();
        Assert.assertTrue(orderPlaced);
        // 19. Click 'Delete Account' button
        driver.findElement(By.partialLinkText("Delete Account")).click();
        // 20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        boolean accountDeletedIsDisplayed = driver.findElement(By.xpath("//b[.='Account Deleted!']")).isDisplayed();
        Assert.assertTrue(accountDeletedIsDisplayed);



    }




}

