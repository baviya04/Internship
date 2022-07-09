package test.com.invoice;

import com.invoice.CommonFunctions;
import org.junit.After;
import org.junit.Before;

public class Start extends CommonFunctions {

    @Before
    public void beforeTest() {

        openBrowser();


    }

    @After
    public void afterTest() {
      //  closeBrowser();

    }


}
