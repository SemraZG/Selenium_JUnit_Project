package utilities;

import dev.failsafe.internal.util.Durations;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public abstract class TestBase {

    protected WebDriver driver;
    @Before
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

//    @After
//    public void tearDown(){
//        driver.quit();
//    }


    //    TAKE SCREENSHOT OF ENTIRE PAGE WITH THIS REUSABLE METHOD
    public void takeScreenshotOfPage() {
        File image = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());//getting the current local date and time
        String path = System.getProperty("user.dir") + "/test-output/Screenshots/" + currentTime + ".png";//Where we save the image
        try {
            FileUtils.copyFile(image, new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //    TAKE SCREENSHOT OF SPECIFIC ELEMENT WITH THIS REUSABLE METHOD

    public void takeScreenshotOfTheElement(WebElement element) {

        File image = element.getScreenshotAs(OutputType.FILE);
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());//getting the current local date and time
        String path = System.getProperty("user.dir") + "/test-output/Screenshots/" + currentTime + ".png";//Where we save the image
        try {
            FileUtils.copyFile(image, new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
