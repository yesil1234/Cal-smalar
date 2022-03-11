package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseStaticDriver {

    public static WebDriver driver;
    public static WebDriverWait wait;





    static {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        System.setProperty("webdriver.chrome.driver","C:/Users/hp/Selenium/Choreme-Driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // aranan her bir element için precence(olusması) olmasını bekler 10 sn bekleyecek
        // Her yarım saniyede bir kontrol eder
        // bulduğu anda gecer

        driver.manage().deleteAllCookies();
        wait= new WebDriverWait(driver,Duration.ofSeconds(10));


    }
    public static void clickTo(By locator){
        //driver.findElement(locator).click();
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    public static void sendKeysTo(By locator, String str){
        //driver.findElement(locator).sendKeys(str);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(str);
    }
    public static void takeScreenShot() throws IOException {
        TakesScreenshot srcShot=(TakesScreenshot) driver;
        String fileName= "ScreenShot "+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd_HH.mm.ss"));
        File scrFile= srcShot.getScreenshotAs(OutputType.FILE);
        File destFile= new File("screenShots\\"+fileName+".png");
        FileUtils.copyFile(scrFile,destFile);

    }
}
