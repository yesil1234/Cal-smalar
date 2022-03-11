package gun11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

public class AlertSendKeys extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        WebElement alert_4= driver.findElement(By.cssSelector("button#promtButton"));
        alert_4.click();
        Thread.sleep(1000);
        driver.switchTo().alert().sendKeys("celil sevim");
        driver.switchTo().alert().accept();
    }
}
