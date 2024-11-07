package TestN;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    WebDriver driver;
    public WebDriver initializeDriver() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("C://Users//riyazp//IdeaProjects//TestProject//src//main//java//browser//resourses//GlobalData.properties");
        prop.load(fis);
        String browserName = prop.getProperty("browser");
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C://Users/riyazp/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-debugging-port=9222");
             driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.get("https://rahulshettyacademy.com/angularpractice/");
        }
        return driver;
    }



    @BeforeMethod
    public void launchApplication() throws IOException {
        driver=initializeDriver();
    }
    @AfterMethod
    public void closeApplication()
    {
        driver.close();
    }
   public String getScreenShot(String testCaseName, WebDriver driver) throws IOException {

        TakesScreenshot ts = (TakesScreenshot) driver;
        File source= ts.getScreenshotAs(OutputType.FILE);
        File file=new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
        FileUtils.copyFile(source,file);
        return System.getProperty(("user.dir")+"//reports//"+testCaseName+".png");
   }






}
