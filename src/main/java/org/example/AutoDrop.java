package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AutoDrop {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C://Users/riyazp/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-debugging-port=9222");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://qaclickacademy.com/practice.php");
        driver.findElement(By.id("autocomplete")).sendKeys("ind");
        Thread.sleep(2000);
        driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
        driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
        System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));




    }
}
