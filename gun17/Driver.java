package gun17;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Driver {

    private static WebDriver driver;
    public static WebDriver getDriver(){
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        System.setProperty("webdriver.chrome.driver","C:/Users/hp/Selenium/Choreme-Driver/chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }
    public static WebDriver getDriver(Browser browser){

        switch (browser) {
            case FIREFOX -> {
                System.setProperty("webdriver.gecko.driver", "Geckodriver\\geckodriver.exe");
                System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
                driver = new FirefoxDriver();
            }
            case IE -> {
                System.setProperty("webdriver.msedge.driver", "C:/Users/hp/Selenium/Edgedriver/msedgedriver.exe");
                driver = new EdgeDriver();
            }
            case OPERA -> {
                System.setProperty("webdriver.opera.driver", "C:/Users/hp/Selenium/Operadriver/operadriver.exe");
                driver = new OperaDriver();
            }
            default -> {
                System.setProperty("webdriver.chrome.driver", "C:/Users/hp/Selenium/Choreme-Driver/chromedriver.exe");
                driver = new ChromeDriver();
            }
        }
       return driver;

    }
    public static void quitDriver(){
        driver.quit();
    }
}
