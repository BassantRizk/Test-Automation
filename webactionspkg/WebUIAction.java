package webactionspkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebUIAction {
     WebDriver driver;

    public WebUIAction(WebDriver driver)
   {
       this.driver=driver;
   }

    public  void navigateToURL(String url)
    {
        driver.get(url);
    }
    public   void waitUntil(By locator, String expectedCondition)
    {
        int attempts = 0;

        switch(expectedCondition)
        {

            case "visible":
                while(attempts < 2) {
                    try {
                        new WebDriverWait(driver,5).
                                until(ExpectedConditions.visibilityOfElementLocated(locator));
                    } catch(Exception e) {
                    }
                    attempts++;
                }
                break;

            case "invisible":
                while(attempts < 2) {
                    try {
                        new WebDriverWait(driver,5).
                                until(ExpectedConditions.invisibilityOfElementLocated(locator));
                    } catch(Exception e) {
                    }
                    attempts++;
                }
                break;

            case "present":
                while(attempts < 2) {
                    try {
                        new WebDriverWait(driver,5).
                                until(ExpectedConditions.presenceOfElementLocated(locator));
                    } catch(Exception e) {
                    }
                    attempts++;
                }
                break;

            case "clickable":
                while(attempts < 2) {
                    try {
                        new WebDriverWait(driver,5).
                                until(ExpectedConditions.elementToBeClickable(locator));
                    } catch(Exception e) {
                    }
                    attempts++;
                }
                break;
        }


    }
/*
    public String getTitle(By locator)
    {
        String title="";
        int attempts=0;
        while(attempts < 2) {
            try {
                System.out.println();
                title= driver.findElement(locator).getText();

                //break;
            } catch(Exception e) {

            }
            attempts++;
        }
        return title;
    }
*/
    public String chooseAction(By locator,String action)
    {
        String result="";
        switch (action) {

            case "click":
                try {
                    waitUntil(locator,"visible");
                    waitUntil(locator,"clickable");
                    driver.findElement(locator).click();
                }
                catch(Exception exception)
                {
                    //do something
                    driver.navigate().refresh();
                    waitUntil(locator,"visible");
                    waitUntil(locator,"clickable");
                    driver.findElement(locator).click();
                    System.out.println("click failed "+locator+" "+exception.getMessage());
                }
                break;

            case "getText":
                try {
                    //////get text hnaa hrg3 el stringg ezayyyy
                    waitUntil(locator,"visible");
                    result= driver.findElement(locator).getText();
                }
                catch(Exception exception)
                {
                    //do something
                    driver.navigate().refresh();
                    waitUntil(locator,"visible");
                    result= driver.findElement(locator).getText();
                }
                break;
        }
        return result;
    }

    public By buildLocator(String baseLocator, String variable)
    {
        String customizedLocator = String.format(baseLocator,variable);
        By finalLocator =By.xpath(customizedLocator);
        return finalLocator;
    }
}


