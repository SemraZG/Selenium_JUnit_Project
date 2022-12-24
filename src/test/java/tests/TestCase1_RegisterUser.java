package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class TestCase1_RegisterUser extends TestBase { git


        // 1. Launch browser
        // 2. Navigate to url 'https://automationexercise.com/'
        // 3. Verify that home page is visible successfully
        // 4. Click on 'Signup / Login' button
        // 5. Verify 'New User Signup!' is visible
        // 6. Enter name and email address
        // 7. Click 'Signup' button
        // 8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        // 9. Fill details: Title, Name, Email, Password, Date of birth
        // 10. Select checkbox 'Sign up for our newsletter!'
        // 11. Select checkbox 'Receive special offers from our partners!'
        // 12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        // 13. Click 'Create Account button'
        // 14. Verify that 'ACCOUNT CREATED!' is visible
        // 15. Click 'Continue' button
        // 16. Verify that 'Logged in as username' is visible
        // 17. Click 'Delete Account' button
        // 18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button


    @Test
    public void registerUserTest() throws InterruptedException {

        // 2. Navigate to url 'http://automationexercise.com/'
            driver.get("https://automationexercise.com/");

        // 3. Verify that home page is visible successfully
        Assert.assertEquals("https://automationexercise.com/", driver.getCurrentUrl());
        Assert.assertTrue(driver.findElement(By.linkText("Home")).isDisplayed());

        // 4. Click on 'Signup / Login' button
        driver.findElement(By.linkText("Signup / Login")).click();

        // 5. Verify 'New User Signup!' is visible
        boolean newUserSignUpIsVisible = driver.findElement(By.xpath("//h2[.='New User Signup!']")).isDisplayed();
        Assert.assertTrue(newUserSignUpIsVisible);

        // 6. Enter name and email address
        driver.findElement(By.name("name")).sendKeys("Mary");
        driver.findElement(By.xpath("//*[@data-qa='signup-email']")).sendKeys("mys@gmail.com");

        // 7. Click 'Signup' button
        driver.findElement(By.xpath("//*[@data-qa='signup-button']")).click();

        // 8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        boolean enterAccountInformationIsVisible = driver.findElement(By.xpath("//b[.='Enter Account Information']")).isDisplayed();
        Assert.assertTrue(enterAccountInformationIsVisible);

        // 9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.id("uniform-id_gender2")).click();
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

        // 10. Select checkbox 'Sign up for our newsletter!'
        WebElement checkbox1 = driver.findElement(By.id("newsletter"));
        Actions actions = new Actions(driver);
        actions.moveToElement(checkbox1).click().perform();

        // 11. Select checkbox 'Receive special offers from our partners!'
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@name='optin']"));
        actions.moveToElement(checkbox2).click().perform();

        // 12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
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

        // 13. Click 'Create Account button'
        driver.findElement(By.xpath("//button[@data-qa='create-account']")).submit();

        // 14. Verify that 'ACCOUNT CREATED!' is visible
        boolean accountCreatedIsDisplayed = driver.findElement(By.xpath("//b[.='Account Created!']")).isDisplayed();
        Assert.assertTrue(accountCreatedIsDisplayed);

        // 15. Click 'Continue' button
        driver.findElement(By.linkText("Continue")).click();

        //driver.switchTo().frame("ad_iframe");
        //driver.findElement(By.id("dismiss-button")).click();

        // 16. Verify that 'Logged in as username' is visible
        boolean loggedInAsUsernameIsDisplayed = driver.findElement(By.partialLinkText("Logged in as")).isDisplayed();
        Assert.assertTrue(loggedInAsUsernameIsDisplayed);

        // 17. Click 'Delete Account' button
        driver.findElement(By.partialLinkText("Delete Account")).click();

        // 18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        boolean accountDeletedIsDisplayed = driver.findElement(By.xpath("//b[.='Account Deleted!']")).isDisplayed();
        Assert.assertTrue(accountDeletedIsDisplayed);

    }
}
