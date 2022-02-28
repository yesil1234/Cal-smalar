package gun3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

public class CssSenaryo extends BaseStaticDriver {
    /*
    * https://formsmarts.com/form/yu?mode=h5  siteye git
    * ilk kısımından business secin
    * ikinci ksından Online advertising seçin
    * diğerinde Every Day seçin
    * sonra Avvarge yi secin
    * I am using XYZ for about a week secin
    * Message alanına bir mesaj yazın
    *
    *
     */

    public static void main(String[] args) throws InterruptedException {

        driver.get("https://formsmarts.com/form/yu?mode=h5");
        WebElement business = driver.findElement(By.cssSelector("input[name='u_Vml_4586']"));
        business.click();
        WebElement advertising= driver.findElement(By.cssSelector("select[name='u_Vml_4588']>:nth-child(4)"));
        advertising.click();
        WebElement XYZ =driver.findElement(By.cssSelector("input[name='u_Vml_89585']"));
        XYZ.click();
        WebElement avvarage= driver.findElement(By.cssSelector("label[for='u_Vml_4589_1']"));
        avvarage.click();



        Thread.sleep(1000);
        driver.quit();
    }
}
