package gun14;

import org.openqa.selenium.JavascriptExecutor;
import utils.BaseStaticDriver;

public class Scrool_High extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("https://triplebyte.com/");

        JavascriptExecutor js= (JavascriptExecutor) driver;

        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        // sayfanın sonuna gitmeye yarıyor

        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
        // sayfanın basına   gitmeye yarıyor


    }
}
