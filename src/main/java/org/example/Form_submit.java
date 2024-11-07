package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Form_submit {
    public static void main(String[]args)
    {
        System.setProperty("webdriver.chrome.driver", "C://Users/riyazp/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-debugging-port=9222");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        driver.findElement(By.name("name")).sendKeys("rahul");

        driver.findElement(By.name("email")).sendKeys("hello@abc.com");

        driver.findElement(By.id("exampleInputPassword1")).sendKeys("123456");

        driver.findElement(By.id("exampleCheck1")).click();

        WebElement dropdown = driver.findElement(By.id("exampleFormControlSelect1"));

        Select abc = new Select(dropdown);

        abc.selectByVisibleText("Male");

        driver.findElement(By.id("inlineRadio1")).click();

        driver.findElement(By.name("bday")).sendKeys("02/02/1992");

        driver.findElement(By.cssSelector(".btn-success")).click();

        System.out.println(driver.findElement(By.cssSelector(".alert-success")).getText());
    }
}

