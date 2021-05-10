package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webactionspkg.WebUIAction;

public class HomePage {

    WebUIAction action;
    By createDocBtn_locator = By.xpath("//a[@class='btn btn-info btn-outline mob-dropdown-btn']");
    //By createDocBtn_locator = By.xpath("//a[text()='Create a Document ']");
    String homeURL ="https://www.levelset.com/";
    WebDriver driver;

    public HomePage(WebDriver driver)
    {
        //this.driver=driver;
        action = new WebUIAction(driver);
        //navigate to home mn l action
    }

    public void createDocument()
    {
        action.chooseAction(createDocBtn_locator,"click");
    }
    public  void navigateToHome()
    {
       action.navigateToURL(homeURL);
    }
}
