package TestN;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class Form_submit extends BaseTest{
    @Test
    public void E2e() throws IOException {
        launchApplication();
        FormSubmit submitform=new FormSubmit(driver);
        submitform.input();
        submitform.getSelect();
        submitform.action();
       // closeApplication();
    }

   // @DataProvider
   // public Object[][] getData()
   // {
      // return new Object[][] {"rahul","hello@abc.com","123456"};
   // }

}
