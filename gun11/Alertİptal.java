package gun11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

public class Alertİptal extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("https://demoqa.com/alerts");
        WebElement alert_3= driver.findElement(By.cssSelector("button#confirmButton"));
        alert_3.click();
        driver.switchTo().alert().dismiss();

    }
}
