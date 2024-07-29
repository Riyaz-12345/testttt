package TestN;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Form_submit {
    @Test
            public void E2e()

      {
        System.setProperty("webdriver.chrome.driver", "C://Users/riyazp/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-debugging-port=9222");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        FormSubmit submitform=new FormSubmit(driver);
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        submitform.input();
        submitform.getSelect();
        submitform.action();
    }
}
