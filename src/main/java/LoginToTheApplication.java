import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;

public class LoginToTheApplication {


    public WebDriver loginToTheApplication(WebDriver driver){

        driver.get("http://3.13.126.58/AMS3.0/home");
        driver.findElement(By.id("inputEmail")).sendKeys("admin@gic.com");
        driver.findElement(By.id("inputPassword")).sendKeys("Admin123");
        driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div[2]/div/form/div[3]/div[2]/button")).click();
        driver.get("http://3.13.126.58/AMS3.0/home");
        return driver;
    }
    public WebDriver navigateToAddNewUser(WebDriver sameDriver) throws InterruptedException {

        sameDriver.findElement(By.className("mm_auth")).click();
        sleep(4000);
        sameDriver.findElement(By.xpath("//*[@id=\"auth_create_user\"]")).click();
        return sameDriver;
    }
    public WebDriver navigateToListProductsPage(WebDriver driver) throws InterruptedException {
        System.out.println("In navigate to list product page method.");
        driver.findElement(By.className("mm_products")).click();
        sleep(4000);
        driver.findElement(By.xpath("//*[@id=\"products_index\"]")).click();
        return driver;

    }

}
