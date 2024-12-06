package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;

public class TableGrid {

    public static <webElement> void main(String[]args)
    {
        System.setProperty("webdriver.chrome.driver", "C://Users/riyazp/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-debugging-port=9222");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://qaclickacademy.com/practice.php");
        List<WebElement> Rows = driver.findElements(By.xpath("//table[@name='courses']//tr"));
        System.out.println(Rows.size());
        List<WebElement> columns = driver.findElements(By.xpath("//table[@name='courses']//th"));
        System.out.println(columns.size());
        List<WebElement> rows1=driver.findElements(By.xpath("//table[@name='courses']//tr//td"));
        //for(int i=0;i<rows1.size();i++)
       // {
           // System.out.println(rows1.get(i).getText());
      //  }
        ArrayList<String> arr = new ArrayList<String>();
        for(WebElement ele: rows1)
        {
            arr.add((ele.getText()));
        }
        System.out.println(arr);
        driver.close();


    }

}
