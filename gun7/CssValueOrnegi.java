package gun7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

public class CssValueOrnegi extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("https://form.jotform.com/220466667555061");

        WebElement name= driver.findElement(By.id("first_3"));

        System.out.println("Click ten önce : "+name.getCssValue("border-color"));

        name.click();
        WebElement surname= driver.findElement(By.id("last_3"));
        surname.click();


        WebElement email= driver.findElement(By.id("input_4"));
        email.click();
//        System.out.println(surname.getCssValue("border-color"));
        System.out.println("Clickten sonra : "+name.getCssValue("border-color"));

    }
}
