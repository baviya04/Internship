import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static java.lang.Thread.sleep;

public class VerifyAddNewUserPage extends LoginToTheApplication {
    public WebDriver verifyAddUserWithValidData(WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"first_name\"]")).sendKeys("Micheal");
        driver.findElement(By.xpath("//*[@id=\"last_name\"]")).sendKeys("Jones");
        driver.findElement(By.name("company")).sendKeys("Tesco");
        driver.findElement(By.name("phone")).sendKeys("0742485961");
        driver.findElement((By.name("email"))).sendKeys("micheal@yahoo.com");
        driver.findElement(By.id("optionsRadios3")).click();
        driver.findElement(By.name("password")).sendKeys("password");
        driver.findElement((By.name("password_confirm"))).sendKeys("password");
        driver.findElement(By.name("submit")).click();
        String message=driver.findElement(By.xpath("/html/body/div[3]/div[2]")).getText();
        System.out.println(message);
        if(message.contains("success"))
        {
            System.out.println("Test passed!");
        }
        else {
            System.out.println("Test failed!");
        }
        driver.findElement(By.className("mm_home")).click();
       return driver;
    }
   public WebDriver verifyAddUserWithNoData(WebDriver driver) throws InterruptedException {

        WebDriver driverMethod=navigateToAddNewUser(driver);

        driverMethod.findElement(By.name("submit")).click();
        String message=driverMethod.findElement(By.xpath("/html/body/div[3]/div[2]")).getText();
        System.out.println(message);
        if(message.contains("success"))
        {
            System.out.println("Test passed!");
        }
        else {
            System.out.println("Test failed!");
        }
       driverMethod.findElement(By.className("mm_home")).click();
        return driverMethod;
    }
    public WebDriver validateConfirmPasswordWithInvalidData(WebDriver driver) throws InterruptedException {
        WebDriver driverMethod = navigateToAddNewUser(driver);
        driverMethod.findElement(By.xpath("//*[@id=\"first_name\"]")).sendKeys("Micheal");
        driverMethod.findElement(By.xpath("//*[@id=\"last_name\"]")).sendKeys("Jones");
        driverMethod.findElement(By.name("company")).sendKeys("Tesco");
        driverMethod.findElement(By.name("phone")).sendKeys("0742485961");
        driverMethod.findElement((By.name("email"))).sendKeys("micheal@yahoo.com");
        driverMethod.findElement(By.id("optionsRadios3")).click();
        driverMethod.findElement(By.name("password")).sendKeys("password");
        driverMethod.findElement((By.name("password_confirm"))).sendKeys("abcdefgh");
        driverMethod.findElement(By.name("submit")).click();
        String message=driverMethod.findElement(By.xpath("/html/body/div[3]/div[2]")).getText();
        System.out.println(message);
        if(message.contains("does not match"))
        {
            System.out.println("Test passed!");
        }
        else {
            System.out.println("Test failed!");
        }
        driverMethod.findElement(By.className("mm_home")).click();

        return driverMethod;
    }

    public WebDriver validateFirstName(WebDriver driver) throws InterruptedException {
        WebDriver driverMethod = navigateToAddNewUser(driver);
        driverMethod.findElement(By.xpath("//*[@id=\"first_name\"]")).sendKeys("1896pou");
        driverMethod.findElement(By.xpath("//*[@id=\"last_name\"]")).sendKeys("Jones");
        driverMethod.findElement(By.name("company")).sendKeys("Tesco");
        driverMethod.findElement(By.name("phone")).sendKeys("0742485961");
        driverMethod.findElement((By.name("email"))).sendKeys("micheal@yahoo.com");
        driverMethod.findElement(By.id("optionsRadios3")).click();
        driverMethod.findElement(By.name("password")).sendKeys("password");
        driverMethod.findElement((By.name("password_confirm"))).sendKeys("password");
        driverMethod.findElement(By.name("submit")).click();
        String message=driverMethod.findElement(By.xpath("/html/body/div[3]/div[2]")).getText();
        System.out.println(message);
        if(message.contains("should only contain characters"))
        {
            System.out.println("Test passed!");
        }
        else {
            System.out.println("Test failed!");
        }
        driverMethod.findElement(By.className("mm_home")).click();

        return driverMethod;
    }

    public WebDriver validateLastName(WebDriver driver) throws InterruptedException {
        WebDriver driverMethod = navigateToAddNewUser(driver);
        driverMethod.findElement(By.xpath("//*[@id=\"first_name\"]")).sendKeys("Micheal");
        driverMethod.findElement(By.xpath("//*[@id=\"last_name\"]")).sendKeys("1234rft");
        driverMethod.findElement(By.name("company")).sendKeys("Tesco");
        driverMethod.findElement(By.name("phone")).sendKeys("0742485961");
        driverMethod.findElement((By.name("email"))).sendKeys("micheal@yahoo.com");
        driverMethod.findElement(By.id("optionsRadios3")).click();
        driverMethod.findElement(By.name("password")).sendKeys("password");
        driverMethod.findElement((By.name("password_confirm"))).sendKeys("password");
        driverMethod.findElement(By.name("submit")).click();
        String message=driverMethod.findElement(By.xpath("/html/body/div[3]/div[2]")).getText();
        System.out.println(message);
        if(message.contains("should only contain characters"))
        {
            System.out.println("Test passed!");
        }
        else {
            System.out.println("Test failed!");
        }
        driverMethod.findElement(By.className("mm_home")).click();

        return driverMethod;
    }
    public WebDriver validatePasswordLength(WebDriver driver) throws InterruptedException {
        WebDriver driverMethod=navigateToAddNewUser(driver);
        driverMethod.findElement(By.xpath("//*[@id=\"first_name\"]")).sendKeys("Mike");
        driverMethod.findElement(By.xpath("//*[@id=\"last_name\"]")).sendKeys("Richardson");
        driverMethod.findElement(By.name("company")).sendKeys("Tesco");
        driverMethod.findElement(By.name("phone")).sendKeys("0742485961");
        driverMethod.findElement((By.name("email"))).sendKeys("mikerichardson@yahoo.com");
        driverMethod.findElement(By.id("optionsRadios3")).click();
        driverMethod.findElement(By.name("password")).sendKeys("123456");
        driverMethod.findElement((By.name("password_confirm"))).sendKeys("123456");
        driverMethod.findElement(By.name("submit")).click();
        String message=driverMethod.findElement(By.xpath("/html/body/div[3]/div[2]")).getText();
        System.out.println(message);
        if(message.contains("length should be atleast 8 characters long"))
        {
            System.out.println("Test passed!");
        }
        else {
            System.out.println("Test failed!");
        }
        driverMethod.findElement(By.className("mm_home")).click();
        return driverMethod;
    }

}
