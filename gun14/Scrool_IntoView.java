package gun14;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

public class Scrool_IntoView extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://triplebyte.com/");

        Thread.sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement element = driver.findElement(By.cssSelector("div[class='text-center font-bold text-3xl']"));

//      js.executeScript("arguments[0].scrollIntoView();",element);  // lokasyonunu verdigim elemente kadar scroll yap
        // default olarak window un ust kismina konuclaniyor
//        js.executeScript("arguments[0].scrollIntoView(true);",element);   // lokasyonunu verdigim elemente kadar scroll yap
        // window un ust kismina konuclaniyor
        js.executeScript("arguments[0].scrollIntoView(false);",element);// lokasyonunu verdigim elemente kadar scroll yap
        // window un alt kismina konuclaniyor
    }
}
