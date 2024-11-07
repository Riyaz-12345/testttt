package org.example;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ExtentReportsDemo {
    ExtentReports extent;

    @BeforeTest
    public void config() {
        // Specify the path for the report
        String path = System.getProperty("user.dir") + "/reports/index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Test Results");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Riyaz");
    }

    @Test
    public void initialDemo() {
        ExtentTest test = extent.createTest("Initial Demo");
        System.setProperty("webdriver.chrome.driver", "C://Users/riyazp/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-debugging-port=9222");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        System.out.println(driver.getTitle());
        extent.flush();
        driver.close();
    }

    @Test
    public void Alert() {
        ExtentTest test = extent.createTest("Alert");
        System.setProperty("webdriver.chrome.driver", "C://Users/riyazp/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-debugging-port=9222");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("name")).sendKeys("Riyaz");
        driver.findElement(By.cssSelector("[id='alertbtn']")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        driver.findElement(By.id("confirmbtn")).click();
        System.out.println(driver.switchTo().alert().getText());
        extent.flush();
        driver.close();
    }


    @Test
    public void dropDown() throws InterruptedException {
        ExtentTest test = extent.createTest("dropDown");
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

        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
        extent.flush();
        driver.close();
    }

    @Test
    public void formSubmit()
    {
        ExtentTest test = extent.createTest("formSubmit");
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
        extent.flush();
        driver.close();
    }
    @Test
    public void tableGrid() {
        ExtentTest test = extent.createTest("tableGrid");
        System.setProperty("webdriver.chrome.driver", "C://Users/riyazp/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-debugging-port=9222");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://qaclickacademy.com/practice.php");
        List<WebElement> Rows = driver.findElements(By.xpath("//table[@name='courses']//tr"));
        System.out.println(Rows.size());
        List<WebElement> columns = driver.findElements(By.xpath("//table[@name='courses']//th"));
        System.out.println(columns.size());
        List<WebElement> rows1 = driver.findElements(By.xpath("//table[@name='courses']//tr[4]//td"));
        for (int i = 0; i < rows1.size(); i++) {
            System.out.println(rows1.get(i).getText());
        }
        extent.flush();
        driver.close();
    }

   @Test
    public void windowHanler() throws InterruptedException {
       ExtentTest test = extent.createTest("tableGrid");
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
       extent.flush();
       driver.close();
   }

}
