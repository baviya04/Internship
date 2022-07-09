import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class VerifyAddCustomerWithWrongEmail {
    public void verifyWithWrongEmail() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://3.13.126.58/AMS3.0/home");
        driver.findElement(By.xpath("//*[@id=\"inputEmail\"]")).sendKeys(" admin@gic.com");
        driver.findElement(By.xpath("//*[@id=\"inputPassword\"]")).sendKeys("Admin123");
        driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div[2]/div/form/div[3]/div[2]/button")).click();
        driver.get("http://3.13.126.58/AMS3.0/home");


        driver.findElement(By.xpath("/html/body/div[2]/div/nav/ul/li[4]/a")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"customers_add\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"company\"]")).sendKeys("Testcompany3");
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("xyz");
        driver.findElement(By.xpath("//*[@id=\"email_address\"]")).sendKeys("pqrs");
        driver.findElement(By.xpath("//*[@id=\"phone\"]")).sendKeys("123456");
        driver.findElement(By.xpath("//*[@id=\"address\"]")).sendKeys("1 road");
        driver.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys("london");
        driver.findElement(By.xpath("//*[@id=\"state\"]")).sendKeys("UK");
        driver.findElement(By.xpath("//*[@id=\"postal_code\"]")).sendKeys("abcd");
        driver.findElement(By.xpath("//*[@id=\"country\"]")).sendKeys("United Kingdom");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[3]/div[4]/div[2]/div/input")).click();

        String actualText = driver.findElement(By.xpath("/html/body/div[3]/div[2]/p")).getText();
        String expectedText="The Email Address field must contain a valid email address.";


        driver.quit();
        if (expectedText.equals(actualText)){
            System.out.println("Test is success");

        } else{
            System.out.println("Test failed");
        }


    }
}

