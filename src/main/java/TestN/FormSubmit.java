package TestN;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FormSubmit extends AbstractComponent {

    WebDriver driver;
    public FormSubmit(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(name = "name")
    WebElement name;
    @FindBy(name = "email")
    WebElement email;
    @FindBy(id = "exampleInputPassword1")
    WebElement password;
    @FindBy(id = "exampleCheck1")
    WebElement button;
    @FindBy(id = "inlineRadio1")
    WebElement radioButton;
    @FindBy(name = "bday")
    WebElement BirthDate;
    @FindBy(css = ".btn-success")
    WebElement submit;
    @FindBy(css = ".alert-success")
    WebElement message;
    @FindBy(id = "exampleFormControlSelect1")
    WebElement dropdown;

    //By results= By.xpath("//input[@type='username");


    public void input()
    {
        name.sendKeys("rahul");
        email.sendKeys("hello@abc.com");
        password.sendKeys("123456");
        button.click();

    }

    public void getSelect()
    {
        Select abc = new Select(dropdown);

        abc.selectByVisibleText("Male");
    }

    public void action()
    {
        radioButton.click();
        BirthDate.sendKeys("02/02/1992");
        submit.click();
        System.out.println(message);
    }



}
