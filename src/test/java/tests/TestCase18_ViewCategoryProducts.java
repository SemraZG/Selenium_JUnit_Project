package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestCase18_ViewCategoryProducts extends  TestBase  {

//    1. Launch browser
//    2. Navigate to url 'http://automationexercise.com'
//    3. Verify that categories are visible on left side bar
//   4. Click on 'Women' category
//   5. Click on any category link under 'Women' category, for example: Dress
//   6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
//   7. On left side bar, click on any sub-category link of 'Men' category
//   8. Verify that user is navigated to that category page

    @Test

    public void VerifyTestCasesPage() throws InterruptedException {
        // 2. Navigate to url 'https://automationexercise.com/'
         driver.get( "https://automationexercise.com/");

        //3. Verify that categories are visible on left side bar
        Thread.sleep(3000);
        assertTrue(driver.findElement(By.xpath("//h2")).isDisplayed());

        //4. Click on 'Women' category
           driver.findElement(By.xpath("//a [@data-toggle='collapse']")).click();

        // 5. Click on any category link under 'Women' category, for example: Dress
           driver.findElement(By.xpath("//a[@href='/category_products/2']")).click();
           Thread.sleep(3000);

        //6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
        //driver.findElement(By.xpath("//a[@href='/category_products/2']")).click();
        String actualText1 = driver.findElement(By.xpath("//h2[@class='title text-center']")).getText();
        assertEquals("WOMEN - TOPS PRODUCTS",actualText1);


        //7. On left side bar, click on any sub-category link of 'Men' category
        driver.findElement(By.xpath("//a[@href='#Men']")).click();


        //8. Verify that user is navigated to that category page
        driver.findElement(By.xpath("//a[@href='/category_products/3']")).click();
        String actualText2 = driver.findElement(By.xpath("//h2[@class='title text-center']")).getText();
        assertEquals("MEN - TSHIRTS PRODUCTS",actualText2);


    }
}