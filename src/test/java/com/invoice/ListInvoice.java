package com.invoice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;


public class ListInvoice extends CommonFunctions {

    public static WebDriver driver;

    public static void clickElement(String elementXpath, WebDriver driver) {
        try {
            driver.findElement(By.xpath(elementXpath)).click();
        } catch (org.openqa.selenium.StaleElementReferenceException e) {
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(elementXpath))));
            driver.findElement(By.xpath(elementXpath)).click();
        }
    }

    @Before
    public void beforeTest() {

        openBrowser();
    }


    @Test
    public void LoginAndListInvoice() {

        driver.findElement(By.id("inputEmail")).sendKeys("admin@gic.com");
        driver.findElement(By.id("inputPassword")).sendKeys("Admin123");
        driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div[2]/div/form/div[3]/div[2]/button")).click();
        driver.navigate().back();
        driver.findElement(By.xpath("/html/body/div[2]/div/nav/ul/li[2]/a")).click();
        driver.findElement(By.id("sales_index")).click();
        // Sort Feature //
        driver.findElement(By.xpath("/html/body/div[3]/div[4]/div/div[1]/div/div[3]/div[1]/div/label/select/option[2]")).click();
        driver.findElement(By.xpath("/html/body/div[3]/div[4]/div/div[1]/div/div[3]/div[1]/div/label/select/option[5]")).click();
        // Copy //
        driver.findElement(By.xpath("/html/body/div[3]/div[4]/div/div[1]/div/div[1]/div/div/a[1]/span")).click();
        // Date Sort //

        // driver.findElement(By.xpath("/html/body/div[3]/div[4]/div/div[1]/div/table/thead/tr/th[1]")).click();
        // Billing Company Sort //
        ///  driver.findElement(By.xpath("/html/body/div[3]/div[4]/div/div[1]/div/table/thead/tr/th[2]")).click();

        // Actions //

        driver.findElement(By.xpath("/html/body/div[3]/div[4]/div/div[1]/div/table/tbody/tr[1]/td[10]/div/div/button")).click();
        // view invoice and download pdf //
        driver.findElement(By.xpath("/html/body/div[3]/div[4]/div/div[1]/div/table/tbody/tr[1]/td[10]/div/div/ul/li[1]/a")).click();

        clickElement("  /html/body/div[4]/div/div/div/div/div[3]/div[5]/a", driver);

        driver.navigate().refresh();

        // view payments //

        driver.findElement(By.xpath("/html/body/div[3]/div[4]/div/div[1]/div/table/tbody/tr[1]/td[10]/div/div/button")).click();
        driver.findElement(By.xpath("/html/body/div[3]/div[4]/div/div[1]/div/table/tbody/tr[1]/td[10]/div/div/ul/li[2]/a")).click();
        //Thread. sleep(10000);
        clickElement("/html/body/div[4]/div/div/div[3]/button", driver);


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
        // Edit invoice
        // driver.findElement(By.xpath("/html/body/div[3]/div[4]/div/div[1]/div/table/tbody/tr[1]/td[10]/div/div/button")).click();
        // driver.findElement(By.xpath(" /html/body/div[3]/div[4]/div/div[1]/div/table/tbody/tr[1]/td[10]/div/div/ul/li[4]/a")).click();



    }


}
