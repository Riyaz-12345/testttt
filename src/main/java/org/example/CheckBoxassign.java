package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.util.List;

public class CheckBoxassign {
    public static void main(String[]args)
    {
        System.setProperty("webdriver.chrome.driver", "C://Users/riyazp/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-debugging-port=9222");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).click();
        WebElement checkBox = driver.findElement(By.xpath("//input[@id='checkBoxOption1']"));
        System.out.println(checkBox.isSelected());
        driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).click();
        System.out.println(checkBox.isSelected());
        //Assert.assertFalse(checkBox.isSelected());
        List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        System.out.println(checkBoxes.size());

    }

}
