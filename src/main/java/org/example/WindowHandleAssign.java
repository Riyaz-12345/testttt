package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Iterator;
import java.util.Set;

public class WindowHandleAssign {
    public static void main(String[]args)
    {
        System.setProperty("webdriver.chrome.driver", "C://Users/riyazp/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-debugging-port=9222");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Multiple Windows")).click();
        driver.findElement(By.cssSelector("a[href*='windows']")).click();
        Set<String> abc=driver.getWindowHandles();
        Iterator<String> it=abc.iterator();
        String parentWindow=it.next();
        driver.switchTo().window(it.next());
        System.out.println(driver.findElement(By.xpath("//div/h3")).getText());
        driver.switchTo().window(parentWindow);
        System.out.println(driver.findElement(By.xpath("//div[@id='content']/div/h3")).getText());
    }
}
