package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webactionspkg.WebUIAction;
import java.util.List;

public class DocumentPage {

    WebUIAction action;
    By titleLocator= By.xpath("//div[@class='title']");
    String document_locator= "//div[@class='product-title-container card-header']//div[contains(text(),'%s')]";
    String freeSpan_Locator = "//div[contains(text(),'%s')]/..//span";
    //String freeSpan_Locator= "//div[contains(text(),'%s')]/..//span[contains(text(),'%s')]";
    //String test = String.format("test goes here %s more text", "Testing");
    public DocumentPage(WebDriver driver)
    {
        action= new WebUIAction(driver);
    }

    public void clickOnDocument(String docName)
    {
        By locator= action.buildLocator(document_locator,docName);
        action.chooseAction(locator,"click");
        /*
        while(attempts < 2) {
            try {
                driver.findElement(locator).click();

                break;
            } catch(Exception e) {
            }
            attempts++;
        }
         */
    }

    public String getDocTitle()
    {
        String title = "";
        title= action.chooseAction(titleLocator,"getText");
        return title;

    }

    public String getFree(String document)
    {
        String free="";
        By locator= action.buildLocator(freeSpan_Locator,document);
        free= action.chooseAction(locator,"getText");
        return free;
    }

    /*
    public void clickDoc(By locator)
    {
        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).click();


    }
     */
    /*
    public String getTitle()
    {
        String title="";
        int attempts=0;
        //new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOfElementLocated(titleLocator));
      action.waitUntil(titleLocator,"visible");
        while(attempts < 2) {
            try {
               title= driver.findElement(titleLocator).getText();
                //break;
            } catch(Exception e) {

            }
            attempts++;
        }
        return title;
    }
*/

}
