package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Dropdown {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C://Users/riyazp/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-debugging-port=9222");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000L);
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
        for(int i=1;i<5;i++)
        {

            driver.findElement(By.id("hrefIncAdt")).click();

        }

        driver.findElement(By.id("btnclosepaxoption")).click();

        //Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");

        //System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
    }
}