package gun1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main1 {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:/Users/hp/Selenium/Choreme-Driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");


        /*

        /*
        burada findElement komutu bana bu elamnı bul demek
        icine yazdığımız By.name name ile bulmak istiyorum dedim
        sendKeys kısmı ise oraya yazmak istediğim yazıyı ifade ediyor
         */
        //Thread.sleep(500);
       // driver.quit();  // alternatifi close() dur farkları quit tüm hepsini kappatır
                        // close() ise sadece o anki açık olanı kapatır
    }
}
