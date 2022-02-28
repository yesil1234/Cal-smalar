package gun10;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

public class GoogleOrnek extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("https://www.google.com/");
        WebElement google= driver.findElement(By.cssSelector("input.gLFyf.gsfi"));
        google.click();
        google.sendKeys("Selenium");
        Actions builder=new Actions(driver);
        Action action=builder.sendKeys(Keys.ENTER).build();
        // entera bastık
        action.perform();
    }
}
