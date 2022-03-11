package gun14;

import org.openqa.selenium.JavascriptExecutor;
import utils.BaseStaticDriver;

public class Scrool_Intro extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("https://triplebyte.com/");

        JavascriptExecutor js= (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,2000)");
        js.executeScript("window.scrollBy(0,-2000)");

    }
}
