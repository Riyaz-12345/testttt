package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.util.List;

public class Calendar {
    public static void main(String[]args)
    {
        System.setProperty("webdriver.chrome.driver", "C://Users/riyazp/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-debugging-port=9222");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        String monthNumber = "6";
        String date = "15";
        String year = "2027";
        String[] expectedList = {monthNumber,date,year};
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
        driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(monthNumber)-1).click();
        driver.findElement(By.xpath("//abbr[text()='"+date+"']")).click();
        List<WebElement> actualList = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
        for(int i =0; i<actualList.size();i++)
        {
            System.out.println(actualList.get(i).getAttribute("value"));
            Assert.assertEquals(actualList.get(i).getAttribute("value"), expectedList[i]);
        }
        driver.close();
    }
}
