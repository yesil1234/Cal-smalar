package gun10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

import java.util.ArrayList;
import java.util.List;

public class Baskentler extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        List<WebElement>baskentler=driver.findElements(By.cssSelector("div#dropContent div[id^='box']"));
        List<WebElement>ulkeler=driver.findElements(By.cssSelector("div#countries div[id^='box']"));

        Actions builder= new Actions(driver);
        Action action;
        String capitals;

        String expected="rgba(0, 255, 0, 1)";

        for (int i = 0; i <baskentler.size() ; i++) {
            for (int j = 0; j < ulkeler.size() ; j++) {
                action=builder.dragAndDrop(baskentler.get(i), ulkeler.get(j) ).build();
                action.perform();

                capitals=baskentler.get(i).getCssValue("background-color");

                if (capitals.equals(expected)){
                    break;
                }

            }

        }
        Thread.sleep(1000);
        //driver.quit();

    }
}
