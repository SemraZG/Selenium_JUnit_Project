package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class TestCase20_SearchProductsAndVerifyCartAfterLogin extends TestBase {
    @Test
    public void test20() throws InterruptedException {
        //1. Launch browser
        driver.get("https://www.google.com.tr/");
        //2. Navigate to url 'https://automationexercise.com/'
        driver.navigate().to("https://automationexercise.com/");

        //3. Click on 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        //4. Verify user is navigated to ALL PRODUCTS page successfully
        boolean allProducts = driver.findElement(By.xpath("//h2[@class='title text-center']")).isDisplayed();
        Assert.assertTrue(allProducts);
        //5. Enter product name in search input and click search button
        driver.findElement(By.id("search_product")).sendKeys("Blue top");
        //6. Verify 'SEARCHED PRODUCTS' is visible
        boolean searchedProducts =driver.findElement(By.xpath("//h2[@class='title text-center']")).isDisplayed();
        Assert.assertTrue(searchedProducts);
        //7. Verify all the products related to search are visible

        //8. Add those products to cart
        WebElement addToCart = driver.findElement(By.xpath("(//a[@data-product-id='1'])[1]"));
        Thread.sleep(7000);
        Actions actions= new Actions(driver);
        Thread.sleep(7000);
        actions.moveToElement(addToCart).click().perform();
        driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();
        //9. Click 'Cart' button and verify that products are visible in cart
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]")).click();
        boolean isVisible = driver.findElement(By.xpath("//a[@href='/product_details/1']")).isDisplayed();
        Assert.assertTrue(isVisible);

        //10. Click 'Signup / Login' button and submit login details
        driver.findElement(By.xpath("(//a[@href='/login'])[1]")).click();
        driver.findElement(By.xpath("(//input[@name='email'])[1]")).sendKeys("Jbrwn12@gmail.com");
        driver.findElement(By.name("password")).sendKeys("123456");
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();

        //11. Again, go to Cart page
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]")).click();

        //12. Verify that those products are visible in cart after login as well
        boolean isVisibleAfterLogin = driver.findElement(By.xpath("//a[@href='/product_details/1']")).isDisplayed();
        Assert.assertTrue(isVisibleAfterLogin);

    }



}
