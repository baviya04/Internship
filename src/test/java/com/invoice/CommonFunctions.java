package com.invoice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.imageio.ImageIO;
import java.io.File;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class CommonFunctions {

    public static WebDriver driver;

    public void openBrowser(){

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.of(10, ChronoUnit.SECONDS));
            driver.get("http://3.13.126.58/AMS3.0/home");
            driver.manage().window().maximize();
            //screenshots//
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);


        }



    public void closeBrowser(){



    }


}
