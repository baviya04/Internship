import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Run {
    //private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\negip\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        LoginToTheApplication login= new LoginToTheApplication();
        WebDriver sameDriver=login.loginToTheApplication(driver);
        WebDriver driver0=login.navigateToAddNewUser(sameDriver);
        VerifyAddNewUserPage verifyAddNewUser=new VerifyAddNewUserPage();
        WebDriver driver1=verifyAddNewUser.verifyAddUserWithValidData(driver0);

        System.out.println(driver1);
        WebDriver driver2=verifyAddNewUser.verifyAddUserWithNoData(driver1);
        System.out.println(driver2);
        WebDriver driver3=verifyAddNewUser.validateConfirmPasswordWithInvalidData(driver2);
        System.out.println(driver3);
        WebDriver driver4=verifyAddNewUser.validateFirstName(driver3);
        System.out.println(driver4);
        WebDriver driver5=verifyAddNewUser.validateLastName(driver4);
        System.out.println(driver5);
        WebDriver driver6=verifyAddNewUser.validatePasswordLength(driver5);
        System.out.println(driver6);
        System.out.println("Add new user tests completed!");
        WebDriver driver7=login.navigateToListProductsPage(sameDriver);
        System.out.println("Navigation to list product page " + driver7);
        VerifyListProductPage listPage=new VerifyListProductPage();
        WebDriver driver8=listPage.verifyAddProductFunctionality(driver7);
        System.out.println(driver8);
        WebDriver driver9=listPage.verifyColumnVisibility(driver8);
        System.out.println(driver9);

    }
}
