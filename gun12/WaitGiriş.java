package gun12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WaitGiriş extends BaseStaticDriver {
    public static void main(String[] args) {

        driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html");
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);  // driver ilk acilirken yuklenmesini bekletiyoruz
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));  // pageLoadTimeout güncel kullanimi
//        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);     // her element icin bekleme suresi.
        // Element bulundugu anda beklemeyi birakir

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));  // ImpilicitlyWait Güncel Kullanimi
//        Thread.sleep(1000);      // Java ait bir bekletme kodu
        // Elementi bulsada verilen sureyi bekler
        WebElement button = driver.findElement(By.cssSelector("button[onclick='timedText()']"));
        button.click();

        // buttona click yapildiktan sonra olusan lokasyon
        WebElement webDriver = driver.findElement(By.xpath("//p[text()='WebDriver']"));
        // impilicitlyWait aktif olmadigi zaman driver da bu lokasyonun gelmesini beklemedigi icin hata verdi
        System.out.println("webDriver = " + webDriver.getText());

    }
}
