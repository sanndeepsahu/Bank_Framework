package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageObjects.LoginPage;
import utilities.ConfigReader;

//  @BeforeMethod - Before each @Test method  and it can run Multiple times.
//  @BeforeClass - Once before all methods in class and it can run Only once.

public class BaseTest {

//    public WebDriver driver;
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeMethod(alwaysRun = true)    // alwaysRun = true you can use while running groups test like smoke or regression test at that time u can use
    public void setup()
    {
        String browser = ConfigReader.getProperty("browser");

//        if you want to run different browser then go to config.properties and update browser name
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver());
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver.set(new EdgeDriver());
        } else {
            throw new RuntimeException("Browser not supported: " + browser);
        }
        getDriver().manage().window().maximize();
        getDriver().get(ConfigReader.getProperty("url"));

    }

    public void loginToApplication() {
        LoginPage login = new LoginPage(getDriver());
        login.clickLogin(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        getDriver().quit();
        driver.remove();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }
}
