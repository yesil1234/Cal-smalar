package gun8;

import gun3.Try_catch;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import utils.BaseStaticDriver;

import java.util.List;

public class CssveXpathChild extends BaseStaticDriver {
    /**
     *                              --CSS--
     *   ul li --> ul tagnamenin altında li olanları verir(ul boşluk li
     *   ul>li --> ul tagnamenin altında li olanları verir(ul boşluk li
     *   ul.social li:first-child --> listenin ilk child almak için
     *   ul.social li:last-child  --> son eleman almak için
     *   ul.social li:nth-child() --> listede istediğim sıradaki childı seçmak için
     *
     *                              --XPATH--
     *   //ul/li  --> ul altındaki li oalnı bulmak için
     *   //ul/li[1] --> listenin ilk child almak için
     *   //ul/li[last()] --> son eleman almak için
     *   //ul[@class='social']/li[1] --> listenin ilk child almak için
     *   //ul[@class='social']/li[2] --> istede istediğim sıradaki childı seçmak için
     */
    public static void main(String[] args) {

        Try_catch.Login();

        WebElement facebookLokasyon= driver.findElement(By.cssSelector("ul.social li:nth-child(2)"));
        System.out.println("facebookLokasyon = " + facebookLokasyon.getText());
        //facebookLokasyon.click();


        List<WebElement> social=driver.findElements(By.xpath("//ul/li"));
        for (WebElement e:social) {
            System.out.println(e.getText());

            JavascriptExecutor js = (JavascriptExecutor) driver;  // todo  sayfayı kaydırmak icin yapılır
            js.executeScript("window.scrollBy(0,100)", "");  //x ekseninde 0 y ekseninde 100 oranında kaydır
        }
    }
}
