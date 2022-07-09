import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VerifyListProductPage extends LoginToTheApplication {

    public WebDriver verifyAddProductFunctionality( WebDriver driverMethod) throws InterruptedException {
        System.out.println("In add product method!");

        driverMethod.findElement(By.linkText("Add Product")).click();
        String label=driverMethod.findElement(By.className("pull-left")).getText();
        if(label.contains("New Product")){
            System.out.println("Test passed!");
        }
        else{
            System.out.println("Test failed!");
        }
        driverMethod.findElement(By.className("mm_home")).click();
        return driverMethod;
    }

    public WebDriver verifyColumnVisibility(WebDriver driver) throws InterruptedException {
        WebDriver driverMethod=navigateToListProductsPage(driver);
        List<WebElement> columns=driverMethod.findElements(By.xpath("//*[@id=\"fileData\"]/thead/tr"));
        int size= columns.size();

        String headerName="";
        for(int i=0;i<size;i++)
        {
            headerName=columns.get(i).findElement(By.xpath("//*[@id=\"fileData\"]/thead/tr")).getText();


        }
        System.out.println(headerName);
        String[] headerNameArray=null;
        headerNameArray=headerName.split(" ");
        for(int i=0; i<headerNameArray.length;i++){
            System.out.println(headerNameArray[i]);
        }
        ArrayList<String> columnNamesPresent= new ArrayList<>();
        for(int i=0;i<headerNameArray.length;i++)
        {
            columnNamesPresent.add(headerNameArray[i]);
        }
        ArrayList<String> allColumnNames=new ArrayList<>();
        allColumnNames.add("ID");
        allColumnNames.add("Name");
        allColumnNames.add("Details");
        allColumnNames.add("Price");
        allColumnNames.add("Tax");
        allColumnNames.add("Rate");
        allColumnNames.add("Tax");
        allColumnNames.add("Method");
        allColumnNames.add("Actions");
        //allColumnNames.add("Login");
       ArrayList<String> unmatchedNames= new ArrayList<String>(allColumnNames);
       unmatchedNames.removeAll(columnNamesPresent);
        driverMethod.findElement(By.xpath("//*[@id=\"fileData_wrapper\"]/div[1]/div/div/a[5]")).click();
        Actions a=new Actions(driverMethod);

       for(String s:unmatchedNames)
       {

           if (driverMethod.findElement(By.linkText(s)) == null) {
               a.sendKeys(Keys.PAGE_DOWN).build().perform();
           }
           driverMethod.findElement(By.linkText(s)).click();
           System.out.println("unmatched column:" + s);


       }
        List<WebElement> columnsNew=driverMethod.findElements(By.xpath("//*[@id=\"fileData\"]/thead/tr"));
        int sizeNew= columnsNew.size();
        String headerNameNew="";
        for(int i=0;i<size;i++)
        {
            headerNameNew=columnsNew.get(i).findElement(By.xpath("//*[@id=\"fileData\"]/thead/tr")).getText();


        }
        System.out.println(headerNameNew);
        String[] headerNameNewArray=null;
        headerNameNewArray=headerNameNew.split(" ");
        for(int i=0; i<headerNameNewArray.length;i++){
            System.out.println(headerNameNewArray[i]);
        }
        ArrayList<String> columnNamesPresentNow= new ArrayList<>();
        for(int i=0;i<headerNameNewArray.length;i++)
        {
            columnNamesPresentNow.add(headerNameNewArray[i]);
        }
        if(columnNamesPresentNow.containsAll(unmatchedNames)){
            System.out.println("Test passed!");
        }
        else{
            System.out.println("Test failed!");
        }

        return driverMethod;
    }


}
