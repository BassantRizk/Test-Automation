package testpkg;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.DocumentPage;
import pages.HomePage;
import utilities.ExcelFileManager;
import webactionspkg.BrowserAction;

import java.io.File;

import static org.testng.Assert.assertTrue;

public class DocumentTest {

    DocumentPage documentPage;
    BrowserAction browserAction;
    WebDriver driver;
    HomePage homePage;
   // ExcelFileManager fileManager;

    //  @Parameters("browser")

    @BeforeClass
    // public void setUp(String browser)
    public void setUp() {
        browserAction = new BrowserAction();
        // driver=browserAction.initializeDriver(browser);
        driver = browserAction.initializeDriver("Chrome");
        homePage = new HomePage(driver);
        documentPage = new DocumentPage(driver);
        homePage.navigateToHome();
        homePage.createDocument();
       // fileManager = new ExcelFileManager(new File("src/main/resources/TestData/DataSheet.xlsx"));
       // fileManager.switchToSheet("Sheet1");


    }
    //   @BeforeMethod
    // public void navigateToHome()
    // {
    //   homePage.navigateToHome();
    // }


    @AfterClass
    public void afterClass() {
        //driver.quit();
        browserAction.tearDown();
    }


    @Test(dataProvider = "DocumentName")
     //@Test
    public void PreliminaryTest(String documentName) {
        //click on doc
        //documentName="Preliminary";
        documentPage.clickOnDocument(documentName);
        assertTrue(documentPage.getDocTitle().
                contains(documentName), "Title is incorrect");
        assertTrue(documentPage.getFree(documentName).contains("Free"));

    }
/*    @Test
    public void PreliminaryTest() {//String documentName) {
        //click on doc
        //documentName="Preliminary";
        documentPage.clickOnDocument(fileManager.getCellData("Document Name",2));
        assertTrue(documentPage.getDocTitle().
                contains(fileManager.getCellData("Document Name",2)), "Title is incorrect");
        assertTrue(documentPage.getFree(fileManager.getCellData("Document Name",2)).contains("Free"));

    }*/
    @DataProvider(name = "DocumentName")
    public Object[] getDocumentName() {
        return new Object[]
                {
                        "Preliminary",
                        "Intent",
                        "Bond",
                        "Waiver"


                };
    }

/*
    @Test
    public void IntentTest()
    {
        //click on doc

        documentPage = homePage.createDocument();
        documentName="Intent";
        documentPage.clickOnDocument(documentName);

        //validate title
        assertTrue(documentPage.getDocTitle().contains(documentName),"Title is incorrect");
        //assertTrue(documentPage.getTitle().contains(documentName),"Title is incorrect");

        System.out.println(documentPage.getDocTitle());

        //getfree
        int attempts = 0;
        while(attempts < 2) {
            try {
                assertTrue(documentPage.getFree(documentName).contains("Free"), "Title is incorrect");
            } catch(Exception e) {

                System.out.println(e.getMessage());
                Assert.fail();
            }
            attempts++;
        }

    }


    @Test
    public void BondTest()
    {
        //click on doc
        documentPage = homePage.createDocument();
        documentName="Bond";
        documentPage.clickOnDocument(documentName);

        //validate title
        try {
            assertEquals(documentPage.getDocTitle(),"Lien / Bond Claim", "Title is incorrect");
            //assertEquals(documentPage.getTitle(),"Lien / Bond Claim", "Title is incorrect");

        }
        catch(Exception ex){
            System.out.println("bond test exception"+ ex.getMessage());
        }

        //getfree
        int attempts = 0;
        while(attempts < 2) {
            try {
                System.out.println(documentPage.getFree(documentName));
                assertEquals(documentPage.getFree(documentName).contains("Free"), "Title is incorrect");
            } catch(Exception e) {
                System.out.println(e.getMessage());
                Assert.fail();


            }
            attempts++;
        }

    }

    @Test
    public void WaiverTest()
    {
        //click on doc
        documentPage = homePage.createDocument();
        documentName="Waiver";
        documentPage.clickOnDocument(documentName);

        //validate title
        assertTrue(documentPage.getDocTitle().contains(documentName),"Title is incorrect");
        //assertTrue(documentPage.getTitle().contains(documentName),"Title is incorrect");


        int attempts = 0;
        while(attempts < 2) {
            try {
                assertTrue(documentPage.getFree(documentName).contains("Free"), "Title is incorrect");
            } catch(Exception e) {
                System.out.println(e.getMessage());
                Assert.fail();

            }
            attempts++;
        }

    }
    */


}
