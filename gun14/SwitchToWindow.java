package gun14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.util.Set;

public class SwitchToWindow extends BaseStaticDriver {
    /**
     * sayafaya git
     * github linkine click yapılacak
     * wiki ye tıklanaack
     */
    public static void main(String[] args) {
        driver.get("https://www.selenium.dev/");

        String anaSayfaId=driver.getWindowHandle();



        WebElement github= driver.findElement(By.xpath("(//a[@target='_blank'])[9]"));
        github.click();

        Set<String> windowHandles = driver.getWindowHandles();// bunun içinde iki tane link var biri anasayfa diğeri github ın

        for (String e:windowHandles) {
            if (e.equals(anaSayfaId)) continue;
            System.out.println("Geçis Öncesi windowid"+ e);
            driver.switchTo().window(e);
            System.out.println("geçis sonrası id"+e);
        }





        WebElement wiki = driver.findElement(By.cssSelector("span[data-content='Wiki']"));
        wiki.click();
        driver.close();






    }
}
