import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class Browser {

    public static void main(String[]args){
        System.setProperty("webdriver.chrome.driver","C://Users/riyazp/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");

    ChromeOptions options = new ChromeOptions();

      options.addArguments("--remote-debugging-port=9222");

        WebDriver driver = new ChromeDriver(options);
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
       // driver.get("https://www.google.com");
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.findElement(By.cssSelector("a[href*='shop']")).click();
        List<WebElement> products = driver.findElements(By.xpath("//div[@class='card h-100']"));
        for (WebElement product : products)
        {
            String productNmae = product.findElement(By.xpath("div/h4/a")).getText();
            if(productNmae=="Blackberry")
            {
                product.findElement(By.xpath("div/button")).click();
            }
        }
        driver.findElement(By.cssSelector("a[class*='btn-primary']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
        driver.findElement(By.id("country")).sendKeys("ind");
        WebDriverWait wait = new WebDriverWait(driver, 7);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("India")));
        element.click();
        driver.findElement(By.xpath("//div[@class='checkbox checkbox-primary']")).click();
        driver.findElement(By.cssSelector("[type='submit']")).click();
        //WebElement successTextElement = driver.findElement(By.id("success-message-id")); // Use the actual locator for your success message
        //String successText = successTextElement.getText();

        // Assert that the success text contains the expected message
        //Assert.assertTrue(successText.contains("Success! Thank you!"), "Success text is incorrect!");

        // Take a screenshot
       // File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //FileUtils.copyfile(screenshot, new File("screen.png"));








    }
}
