package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;

public class TestCase12_AddProductsInCart extends TestBase {
    @Test
    public void test12() throws InterruptedException {

        // 1. Launch browser
        // 2. Navigate to url 'https://automationexercise.com/'
        driver.get("https://automationexercise.com/");
        // 3. Verify that home page is visible successfully
        Assert.assertTrue(driver.getPageSource().contains("AutomationExercise"));
        // 4. Click 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@href='/products']")).click();

        // 5. Hover over first product and click 'Add to cart'
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement blueTop= driver.findElement(By.xpath("(//div[@class='product-overlay'])[1]"));
        actions.moveToElement(blueTop).perform();
        driver.findElement(By.xpath("//a[@data-product-id='1']")).click();

        // 6. Click 'Continue Shopping' button
        driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();

        // 7. Hover over second product and click 'Add to cart'
        Actions actions1=new Actions(driver);
        WebElement tshirt= driver.findElement(By.xpath("(//div[@class='product-overlay'])[2]"));
        actions1.moveToElement(tshirt).perform();
        JavascriptExecutor js=(JavascriptExecutor)driver;
        WebElement element=driver.findElement(By.xpath("//a[@data-product-id='2']"));
        js.executeScript("arguments[0].click()",element);
        driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();

        // 8. Click 'View Cart' button
        WebElement element1=driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]"));
        js.executeScript("arguments[0].click()",element1);
        driver.navigate().refresh();

        // 9. Verify both products are added to Cart
        WebElement cartTable=driver.findElement(By.xpath("(//div[@class='container'])[2]"));
        cartTable.getText().contains("Blue Top");
        cartTable.getText().contains("Men Tshirt");

        // 10. Verify their prices, quantity and total price
        String blueTopPrice=driver.findElement(By.xpath("(//*[.='Rs. 500'])[1]")).getText();
        assertEquals("Rs. 500",blueTopPrice);
        String blueToptotalPrice=driver.findElement(By.xpath("(//*[.='Rs. 500'])[2]")).getText();
        assertEquals("Rs. 500",blueToptotalPrice);
        String blueTopQuantity=driver.findElement(By.xpath("(//button[@class='disabled'])[1]")).getText();
        assertEquals("1",blueTopQuantity);

        String menTshirtPrice=driver.findElement(By.xpath("(//*[.='Rs. 400'])[1]")).getText();
        assertEquals("Rs. 400",menTshirtPrice);
        String menTshirttotalPrice=driver.findElement(By.xpath("(//*[.='Rs. 400'])[2]")).getText();
        assertEquals("Rs. 400",menTshirttotalPrice);
        String menTshirtQuantity=driver.findElement(By.xpath("(//button[@class='disabled'])[2]")).getText();
        assertEquals("1",menTshirtQuantity);






    }




}
