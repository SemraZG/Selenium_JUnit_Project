package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class TestCase19_ViewAndCartBrandProducts extends TestBase {

        // 1. Launch browser
        // 2. Navigate to url 'https://automationexercise.com/'
        // 3. Click on 'Products' button
        // 4. Verify that Brands are visible on left side bar
        // 5. Click on any brand name
        // 6. Verify that user is navigated to brand page and brand products are displayed
        // 7. On left side bar, click on any other brand link
        // 8. Verify that user is navigated to that brand page and can see products


    @Test
    public void test02 () {
        driver.get("https://automationexercise.com/");

        // 3. Click on 'Products' button
        driver.findElement(By.xpath("(//a[@href='/products'])[1]")).click();

        // 4. Verify that Brands are visible on left side bar

        boolean brandsIsVisible = driver.findElement(By.xpath("(//h2)[2]")).isDisplayed();
        Assert.assertTrue(brandsIsVisible);

        // 5. Click on any brand name
        driver.findElement(By.xpath("//a[@href='/brand_products/Polo']")).click();

        // 6. Verify that user is navigated to brand page and brand products are displayed
        boolean poloIsVisible = driver.findElement(By.xpath("//h2[@class='title text-center']")).isDisplayed();
        Assert.assertTrue(poloIsVisible);

        // 7. On left side bar, click on any other brand link
        driver.findElement(By.xpath("//a[@href='/brand_products/Madame']")).click();

        // 8. Verify that user is navigated to that brand page and can see products
        boolean madamIsVisible = driver.findElement(By.xpath("//h2[@class='title text-center']")).isDisplayed();
        Assert.assertTrue(madamIsVisible);

    }
}
