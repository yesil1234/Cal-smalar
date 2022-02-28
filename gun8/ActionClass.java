package gun8;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

public class ActionClass extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
       // driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        driver.get("https://demoqa.com/buttons");

        WebElement ciftTiklama= driver.findElement(By.id("doubleClickBtn"));
        Actions builder= new Actions(driver);  // bu işlemler tarayıcı üzerinden yapıldığı için drivera yazdık
        Action build =builder.moveToElement(ciftTiklama).doubleClick().build();
                    // yapılacak aksiyon tanımlandı
        build.perform();  // asıl aksiyon burada gerçekleşti
        Thread.sleep(1000);
        WebElement sagTiklama= driver.findElement(By.id("rightClickBtn"));
        Action sagClik=builder.moveToElement(sagTiklama).contextClick().build();
        sagClik.perform();
        Thread.sleep(1000);
        WebElement solTiklama= driver.findElement(By.xpath("//button[text()='Click Me']"));
        Action solTik=builder.moveToElement(solTiklama).click().build();
        solTik.perform();

        WebElement doubleMessage= driver.findElement(By.id("doubleClickMessage"));
        String message =doubleMessage.getText();

        



    }
}
