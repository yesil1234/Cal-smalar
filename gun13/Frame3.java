package gun13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.time.Duration;

public class Frame3 extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("https://chercher.tech/practice/frames");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.switchTo().frame("frame1");


        WebElement textbox= driver.findElement(By.cssSelector("body>input"));
        textbox.sendKeys("sfdgfdsghegh");

    }
}
