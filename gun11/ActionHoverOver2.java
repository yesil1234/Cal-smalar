package gun11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

import java.util.List;

public class ActionHoverOver2 extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://www.etsy.com/");

       // WebElement kleidung= driver.findElement(By.cssSelector("span#catnav-primary-link-10923"));
        //WebElement kinder=driver.findElement(By.cssSelector("span#side-nav-category-link-10941"));

        Actions builder= new Actions(driver);

        //Action action=builder.moveToElement(kleidung).build();
       // action.perform();

        Thread.sleep(1000);

        //action=builder.moveToElement(kinder).build();
       // action.perform();

        Thread.sleep(1000);

        //todo https://www.birtwhistle.com/workers-compensation-insurance/
        // Ödev Menu yü liste yaparak Hover _Over ile dolasiniz

        List<WebElement>menü=driver.findElements(By.cssSelector("ul[role='menubar'] li"));


        for (WebElement e:menü) {
            Action action=builder.moveToElement(e).build();
            action.perform();
            Thread.sleep(1000);
        }

        driver.quit();



    }
}
