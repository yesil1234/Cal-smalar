package gun11;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import utils.BaseStaticDriver;

public class ActionHoverOver extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {

        driver.get("https://demo.guru99.com/test/drag_drop.html");

        WebElement loan= driver.findElement(By.xpath("//a[text()=' LOAN ']"));
        System.out.println("sction oncesi color"+loan.getCssValue("color"));
        Actions builder=new Actions(driver);
        Action action=builder.moveToElement(loan).build();
        action.perform();

        System.out.println("sction sonrası color"+ Color.fromString(loan.getCssValue("color")).asHex());
        String result=Color.fromString(loan.getCssValue("color")).asHex();
        String expected="#ee7933";
        Assert.assertTrue(expected, Boolean.parseBoolean(result));


    }
}
/*

        Thread.sleep(1000);
        driver.switchTo().frame("gdpr-conset-notice");
        Thread.sleep(1000);
        WebElement akzeptiren= driver.findElement(By.xpath("//span[text()='Alle akzeptieren']"));
        akzeptiren.click();

        Thread.sleep(1000);
 */