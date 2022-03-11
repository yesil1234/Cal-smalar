package gun13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseStaticDriver;

import java.time.Duration;

public class WaitInvisibility extends BaseStaticDriver {
    /*
    * Siteye gidiniz
    * Remove Butonuna bASINIZ
    * Wait Loading kaybolana kadar bekletin
    * ıts back  bu yazının görünürlüğünü onaylayın
     */
    public static void main(String[] args) {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement remove= driver.findElement(By.xpath("(//button[@type='button'])[1]"));
        remove.click();

        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
        boolean loading=wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//div[@id='loading'])[1]")));

        System.out.println("loading = "+loading);

        WebElement mesaj =wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("p#message"))));
        System.out.println("mesaj =" +mesaj.isEnabled());

    }
}
