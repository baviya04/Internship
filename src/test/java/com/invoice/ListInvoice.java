package com.invoice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;


public class ListInvoice extends CommonFunctions {


    @Before
    public void beforeTest() {

        openBrowser();

    }

    public void clickElement(String elementXpath, WebDriver driver) {
        try {
            driver.findElement(By.xpath(elementXpath)).click();
        } catch (org.openqa.selenium.StaleElementReferenceException e) {
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(elementXpath))));
            driver.findElement(By.xpath(elementXpath)).click();
        }
    }

    public void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
        //Call getScreenshotAs method to create image file
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        //Move image file to new destination
        File DestFile=new File(fileWithPath);
        //Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);

    }



    @Test
    public void LoginAndListInvoice() throws Exception {

        driver.findElement(By.id("inputEmail")).sendKeys("admin@gic.com");
        driver.findElement(By.id("inputPassword")).sendKeys("Admin123");
        driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div[2]/div/form/div[3]/div[2]/button")).click();
        this.takeSnapShot(driver, "C:\\Users\\saiso\\IdeaProjects\\InvoiceManager\\src\\test\\screenshoots\\login.jpeg") ;
        driver.navigate().back();
        this.takeSnapShot(driver, "C:\\Users\\saiso\\IdeaProjects\\InvoiceManager\\src\\test\\screenshoots\\homepage.jpeg") ;
        driver.findElement(By.xpath("/html/body/div[2]/div/nav/ul/li[2]/a")).click();
        this.takeSnapShot(driver, "C:\\Users\\saiso\\IdeaProjects\\InvoiceManager\\src\\test\\screenshoots\\Modules.jpeg") ;
        driver.findElement(By.id("sales_index")).click();

        // Sort Feature //
        driver.findElement(By.xpath("/html/body/div[3]/div[4]/div/div[1]/div/div[3]/div[1]/div/label/select/option[2]")).click();
        this.takeSnapShot(driver, "C:\\Users\\saiso\\IdeaProjects\\InvoiceManager\\src\\test\\screenshoots\\sort_25.jpeg") ;
        driver.findElement(By.xpath("/html/body/div[3]/div[4]/div/div[1]/div/div[3]/div[1]/div/label/select/option[5]")).click();
        this.takeSnapShot(driver, "C:\\Users\\saiso\\IdeaProjects\\InvoiceManager\\src\\test\\screenshoots\\sort_All.jpeg") ;
        // Copy //
        driver.findElement(By.xpath("/html/body/div[3]/div[4]/div/div[1]/div/div[1]/div/div/a[1]/span")).click();
        this.takeSnapShot(driver, "C:\\Users\\saiso\\IdeaProjects\\InvoiceManager\\src\\test\\screenshoots\\copy.jpeg") ;
        // Date Sort //

        // driver.findElement(By.xpath("/html/body/div[3]/div[4]/div/div[1]/div/table/thead/tr/th[1]")).click();
        // Billing Company Sort //
        ///  driver.findElement(By.xpath("/html/body/div[3]/div[4]/div/div[1]/div/table/thead/tr/th[2]")).click();

        // Actions //

        driver.findElement(By.xpath("/html/body/div[3]/div[4]/div/div[1]/div/table/tbody/tr[1]/td[10]/div/div/button")).click();
        this.takeSnapShot(driver, "C:\\Users\\saiso\\IdeaProjects\\InvoiceManager\\src\\test\\screenshoots\\action.jpeg") ;
        // view invoice and download pdf //
        driver.findElement(By.xpath("/html/body/div[3]/div[4]/div/div[1]/div/table/tbody/tr[1]/td[10]/div/div/ul/li[1]/a")).click();

        clickElement("  /html/body/div[4]/div/div/div/div/div[3]/div[5]/a", driver);
        this.takeSnapShot(driver, "C:\\Users\\saiso\\IdeaProjects\\InvoiceManager\\src\\test\\screenshoots\\Viewinvoice.jpeg") ;
        driver.navigate().refresh();

        // view payments //

        driver.findElement(By.xpath("/html/body/div[3]/div[4]/div/div[1]/div/table/tbody/tr[1]/td[10]/div/div/button")).click();
        driver.findElement(By.xpath("/html/body/div[3]/div[4]/div/div[1]/div/table/tbody/tr[1]/td[10]/div/div/ul/li[2]/a")).click();
        this.takeSnapShot(driver, "C:\\Users\\saiso\\IdeaProjects\\InvoiceManager\\src\\test\\screenshoots\\viewpayments.jpeg") ;
        clickElement("/html/body/div[4]/div/div/div[3]/button", driver);
        this.takeSnapShot(driver, "C:\\Users\\saiso\\IdeaProjects\\InvoiceManager\\src\\test\\screenshoots\\viewpayments1.jpeg") ;

        // Add Payment without details entered //
        driver.findElement(By.xpath("/html/body/div[3]/div[4]/div/div[1]/div/table/tbody/tr[1]/td[10]/div/div/button")).click();
        driver.findElement(By.xpath("/html/body/div[3]/div[4]/div/div[1]/div/table/tbody/tr[1]/td[10]/div/div/ul/li[3]/a")).click();
        driver.findElement(By.id("add-payment")).click();
        Alert alt = driver.switchTo().alert();
        alt.accept();
        driver.findElement(By.xpath("/html/body/div[5]/div/div/div[3]/button[1]")).click();

        // Add Payment with details entered //

        driver.findElement(By.xpath("/html/body/div[3]/div[4]/div/div[1]/div/table/tbody/tr[1]/td[10]/div/div/button")).click();
        driver.findElement(By.xpath("/html/body/div[3]/div[4]/div/div[1]/div/table/tbody/tr[1]/td[10]/div/div/ul/li[3]/a")).click();
        driver.findElement(By.name("date")).sendKeys("02021995");
        driver.findElement(By.name("amount")).sendKeys("225");
        driver.findElement(By.id("add-payment")).click();
        this.takeSnapShot(driver, "C:\\Users\\saiso\\IdeaProjects\\InvoiceManager\\src\\test\\screenshoots\\addpayments.jpeg") ;
        // Edit invoice
        // driver.findElement(By.xpath("/html/body/div[3]/div[4]/div/div[1]/div/table/tbody/tr[1]/td[10]/div/div/button")).click();
        // driver.findElement(By.xpath(" /html/body/div[3]/div[4]/div/div[1]/div/table/tbody/tr[1]/td[10]/div/div/ul/li[4]/a")).click();



    }


}
