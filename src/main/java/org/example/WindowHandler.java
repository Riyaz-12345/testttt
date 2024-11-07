package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.Set;

public class WindowHandler {
    public static void main(String[]args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C://Users/riyazp/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-debugging-port=9222");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");

        driver.findElement(By.cssSelector(".blinkingText")).click();

        Set<String> windows = driver.getWindowHandles(); //[parentid,childid,subchildId]

        Iterator<String> it = windows.iterator();

        String parentId = it.next();

        String childId = it.next();

        driver.switchTo().window(childId);

        System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());

        driver.findElement(By.cssSelector(".im-para.red")).getText();

        String emailId= driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
        String emailid2=emailId.split("@")[1].split("\\.")[0];
        // String emailid3=emailid2.split("\\.")[0];
        driver.switchTo().window(parentId);

        driver.findElement(By.id("username")).sendKeys(emailid2);
        driver.findElement(By.id("password")).sendKeys("learning");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@value='user']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()='Okay']")).click();
        // driver.switchTo().alert().dismiss();
        WebElement dropdown = driver.findElement(By.xpath("//select[@class='form-control']"));
        Select d=new Select(dropdown);
        d.selectByVisibleText("Student");
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        driver.findElement(By.xpath("//input[@type='submit']")).click();

    }

}
