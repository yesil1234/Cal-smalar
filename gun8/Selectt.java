package gun8;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.BaseStaticDriver;

import java.util.List;

public class Selectt extends BaseStaticDriver {
    public static void main(String[] args) {

        driver.get("https://www.ebay.com/");
        WebElement katagori= driver.findElement(By.cssSelector("select.gh-sb"));
        Select select= new Select(katagori);
        //select.selectByValue("625"); // value ile seçme
        select.selectByIndex(10); // index ine göre seçme (index optionlarda 0 dan başlar)

        List<WebElement> options= select.getOptions();
        String secim = options.get(10).getText();   // optionlasrın textine ulaşma


        WebElement search = driver.findElement(By.cssSelector("input[type='submit']"));
        search.click();

        WebElement urunİsmi= driver.findElement(By.cssSelector("span.b-pageheader__text"));

        Assert.assertTrue(secim.contains(urunİsmi.getText()));
    }
}
