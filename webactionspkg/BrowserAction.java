package webactionspkg;

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserAction {

    WebDriver driver;

    public WebDriver initializeDriver(String webDriver) {
        switch (webDriver) {
            case "FireFox" -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            case "Edge" -> {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
            case "Explorer" -> {
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
            }
            default -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
        }

        return driver;
    }

    //quit
    public void tearDown() {
    this.driver.quit();
    }
}