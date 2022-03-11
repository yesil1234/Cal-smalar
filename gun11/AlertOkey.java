package gun11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

public class AlertOkey extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {

        driver.get("https://demoqa.com/alerts");

        WebElement alert_1= driver.findElement(By.cssSelector("button#alertButton"));
        alert_1.click();
        Thread.sleep(1000);
        driver.switchTo().alert().accept();

        Thread.sleep(2000);

        WebElement alert_2= driver.findElement(By.cssSelector("button#timerAlertButton"));
        alert_2.click();
        Thread.sleep(1000);
        driver.switchTo().alert().accept();

        Thread.sleep(2000);

        WebElement alert_3= driver.findElement(By.cssSelector("button#confirmButton"));
        alert_3.click();


        Thread.sleep(2000);

        WebElement alert_4= driver.findElement(By.cssSelector("button#promtButton"));
        alert_4.click();
        Thread.sleep(1000);
        driver.switchTo().alert().sendKeys("celil sevim");

        //
    }
}
