package gun7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.util.List;

public class ElementStatus extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        /**
         *
         * boolean  isSelected(); -> secili mi
         * boolean isEnabled();   -> Kullanilabilir mi
         * boolean isDisplayed();  -> Görünüyor mu
         *
         *
         * isSelected();   -> Wednesday  ->  true
         *
         * isEnabled();    -> Monday    ->  true
         * isEnabled();    -> Sunday    ->  false
         *
         * isDisplayed();   -> Monday    ->  true
         * isDisplayed();   -> Sunday    ->  true
         *
         *
         */


        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");

        Thread.sleep(3000);

        WebElement wednesday = driver.findElement(By.xpath("//input[@id='gwt-debug-cwCheckBox-Wednesday-input']"));

        System.out.println(wednesday.isEnabled());    // true
        System.out.println(wednesday.isDisplayed());  // true
        System.out.println("Secilmeden önce  : "+wednesday.isSelected());   // false

        wednesday.click();
        System.out.println("Secildikten sonra  : "+wednesday.isSelected());   //  true

        List<WebElement> days = driver.findElements(By.xpath("//label[contains(@for,'gwt-debug-cwCheckBox-')]"));

        for (WebElement e: days) {
            System.out.println(e.getText());
            System.out.println(e.isDisplayed());
            System.out.println(e.isEnabled());

            System.out.println("***************");

        }

    }
}
