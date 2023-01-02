package tests;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class TestCase15_PlaceOrderRegisterBeforeCheckout extends TestBase {

        // 1. Launch browser
        // 2. Navigate to url 'https://automationexercise.com/'
        // 3. Verify that home page is visible successfully
        // 4. Click 'Signup / Login' button
        // 5. Fill all details in Signup and create account
        // 6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        // 7. Verify ' Logged in as username' at top
        // 8. Add products to cart
        // 9. Click 'Cart' button
        // 10. Verify that cart page is displayed
        // 11. Click Proceed To Checkout
        // 12. Verify Address Details and Review Your Order
        // 13. Enter description in comment text area and click 'Place Order'
        // 14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        // 15. Click 'Pay and Confirm Order' button
        // 16. Click 'Delete Account' button
        // 17. Verify 'ACCOUNT DELETED!' and click 'Continue' button

    @Test
    public void placeOrderRegisterBeforeCheckoutTest() throws InterruptedException {

        // 2. Navigate to url 'https://automationexercise.com/'
        driver.get("https://automationexercise.com/");

        // 3. Verify that home page is visible successfully
        boolean sliderIsDisplayed = driver.findElement(By.id("slider")).isDisplayed();
        Assert.assertTrue(sliderIsDisplayed);

        // 4. Click 'Signup / Login' button
        driver.findElement(By.linkText("Signup / Login")).click();

        // 5. Fill all details in Signup and create account
        Faker faker = new Faker();
        String fakerEmail = faker.internet().emailAddress();

        driver.findElement(By.name("name")).sendKeys("Steve");
        driver.findElement(By.xpath("//*[@data-qa='signup-email']")).sendKeys(fakerEmail);
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

        driver.findElement(By.id("uniform-id_gender1")).click();
        driver.findElement(By.id("password")).sendKeys("12345");

        WebElement dropdownDays = driver.findElement(By.id("days"));
        Select selectDay = new Select(dropdownDays);
        selectDay.selectByVisibleText("17");

        WebElement dropdownMonth = driver.findElement(By.id("months"));
        Select selectMonth = new Select(dropdownMonth);
        selectMonth.selectByVisibleText("March");

        WebElement dropdownYears = driver.findElement(By.id("years"));
        Select selectYear = new Select(dropdownYears);
        selectYear.selectByVisibleText("1987");

        WebElement checkbox1 = driver.findElement(By.id("newsletter"));
        Actions actions = new Actions(driver);
        actions.moveToElement(checkbox1).click().perform();

        WebElement checkbox2 = driver.findElement(By.xpath("//input[@name='optin']"));
        actions.moveToElement(checkbox2).click().perform();

        driver.findElement(By.id("first_name")).sendKeys("Mary");
        driver.findElement(By.id("last_name")).sendKeys("Star");
        driver.findElement(By.id("company")).sendKeys("Google");
        driver.findElement(By.id("address1")).sendKeys("Mountain View, California, United States");
        driver.findElement(By.id("address2")).sendKeys("1600 Amphitheatre Parkway Mountain View, CA 94043");

        WebElement dropdownCountry = driver.findElement(By.id("country"));
        Select selectCountry = new Select(dropdownCountry);
        selectCountry.selectByVisibleText("United States");

        driver.findElement(By.id("state")).sendKeys("California");
        driver.findElement(By.id("city")).sendKeys("California");
        driver.findElement(By.id("zipcode")).sendKeys("CA 94043");
        driver.findElement(By.id("mobile_number")).sendKeys("94043");

        driver.findElement(By.xpath("//button[@data-qa='create-account']")).submit();

        // 6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        boolean accountCreatedIsDisplayed = driver.findElement(By.xpath("//b[.='Account Created!']")).isDisplayed();
        Assert.assertTrue(accountCreatedIsDisplayed);
        driver.findElement(By.linkText("Continue")).click();

        //AD CLOSE
        driver.navigate().refresh();
        Thread.sleep(5000);
        driver.findElement(By.linkText("Continue")).click();

        // 7. Verify ' Logged in as username' at top
        boolean loggedInAsUsernameIsDisplayed = driver.findElement(By.partialLinkText("Logged in as")).isDisplayed();
        Assert.assertTrue(loggedInAsUsernameIsDisplayed);

        // 8. Add products to cart
        Thread.sleep(7000);
        WebElement cart = driver.findElement(By.xpath("(//a[@data-product-id='2'])[1]"));
        Actions action = new Actions(driver);
        Thread.sleep(7000);
        action.moveToElement(cart).click().perform();

        //9. Click 'Cart' button
        Thread.sleep(3000);
        driver.findElement(By.linkText("View Cart")).click();

        // 10. Verify that cart page is displayed
        boolean cartPageIsDisplayed = driver.findElement(By.xpath("//li[.='Shopping Cart']")).isDisplayed();
        Assert.assertTrue(cartPageIsDisplayed);

        // 11. Click Proceed To Checkout
        driver.findElement(By.linkText("Proceed To Checkout")).click();

        // 12. Verify Address Details and Review Your Order
        boolean addressDetailsIsDisplayed = driver.findElement(By.xpath("//h2[.='Address Details']")).isDisplayed();
        Assert.assertTrue(addressDetailsIsDisplayed);

        // 13. Enter description in comment text area and click 'Place Order'
        driver.findElement(By.name("message")).sendKeys("Men > Tshirts");
        driver.findElement(By.linkText("Place Order")).click();

        // 14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        driver.findElement(By.name("name_on_card")).sendKeys("Steve Jobs");
        driver.findElement(By.name("card_number")).sendKeys("123456789");
        driver.findElement(By.name("cvc")).sendKeys("311");
        driver.findElement(By.name("expiry_month")).sendKeys("12");
        driver.findElement(By.name("expiry_year")).sendKeys("2022");

        // 15. Click 'Pay and Confirm Order' button
        driver.findElement(By.id("submit")).submit();

        // 16. Click 'Delete Account' button
        driver.findElement(By.partialLinkText("Delete Account")).click();

        // 17. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        Thread.sleep(3000);
        boolean accountDeletedIsDisplayed = driver.findElement(By.xpath("//b[.='Account Deleted!']")).isDisplayed();
        Assert.assertTrue(accountDeletedIsDisplayed);

        driver.findElement(By.linkText("Continue")).click();

    }

}

