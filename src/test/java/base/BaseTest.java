package base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import reader.ReadDataFromJson;
import utils.ScreenRecorderUtil;
import utils.UtilsTests;
import java.lang.reflect.Method;

public class BaseTest {
   protected WebDriver driver;
    protected HomePage homePage;
   protected ReadDataFromJson readDataFromJson;
   ChromeOptions chromeOptions;
   FirefoxOptions firefoxOptions;
   UtilsTests utilsTests;
    @BeforeClass
    @Parameters("browser")
    public void setUP(@Optional("chrome") String browser){
       // driver = new ChromeDriver();
        setUpBrowser(browser);
        driver.manage().window().maximize();
        homePage = new HomePage(driver);

    }
    @Parameters("browser")
    public void setUpBrowser(String browser){
      if(browser.equalsIgnoreCase("chrome")) {
          driver = new ChromeDriver();
      }
      else if (browser.equalsIgnoreCase("firefox")) {
          driver = new FirefoxDriver();
      }
      else if (browser.equalsIgnoreCase("headlessChrome")) {
          chromeOptions = new ChromeOptions();
          chromeOptions.addArguments("--headless");
          driver = new ChromeDriver(chromeOptions);
      }
      else if (browser.equalsIgnoreCase("headlessFirefox")) {
          firefoxOptions = new FirefoxOptions();
          firefoxOptions.addArguments("--headless");
          driver = new FirefoxDriver(firefoxOptions);

      }

    }
    @BeforeMethod
    public void goHome(Method method) throws Exception {
        ScreenRecorderUtil.startRecord(method.getName());
        readDataFromJson = new ReadDataFromJson();
        driver.get(readDataFromJson.readJsonFile().URL);
        utilsTests = new UtilsTests(driver);
        utilsTests.createTestCaseInReport(method);
    }
    @BeforeSuite
    public void beforeSuite(){
        utilsTests = new UtilsTests(driver);
        utilsTests.createReport();
    }
    @AfterSuite
    public void afterSuite(){
        utilsTests = new UtilsTests(driver);
        utilsTests.flushReport();
    }

    @AfterMethod
    public void afterMethod(Method method, ITestResult result) throws Exception {
        utilsTests = new UtilsTests(driver);
        utilsTests.takeScreenShot(method);
        ScreenRecorderUtil.stopRecord();
        utilsTests.endsOfSteps();
        utilsTests.setStatus(result);
        utilsTests.addAttachment(method);

    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
