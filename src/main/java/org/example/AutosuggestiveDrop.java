package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class AutosuggestiveDrop {
    public static void main(String[]args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C://Users/riyazp/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-debugging-port=9222");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("autosuggest")).sendKeys("ind");

        Thread.sleep(3000);

        List<WebElement> AllOptions =driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

        for(WebElement option :AllOptions)

        {

            if(option.getText().equalsIgnoreCase("India"))

            {

                option.click();

                break;

            }

        }
    }
}



