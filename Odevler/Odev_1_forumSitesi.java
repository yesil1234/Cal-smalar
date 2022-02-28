package Odevler;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

public class Odev_1_forumSitesi extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        /*
            https://form.jotform.com/220466667555061   -  Ödev Form sıtesı

            Formdaki Tüm alanlari doldurarak
            submit butouna basiniz ve ekanda Cikan "Thank You!" yazisini Onaylayiniz
            Bulundugunuz sayfanin linkinin "https://submit.jotformeu.com/220466667555061"  oldgunu Assert ile test ediniz
         */

        driver.get("https://form.jotform.com/220466667555061");
        driver.manage().window().maximize();
        WebElement name= driver.findElement(By.id("first_3"));
        name.sendKeys("Celil");
        WebElement surname= driver.findElement(By.id("last_3"));
        surname.sendKeys("Sevim");
        WebElement email= driver.findElement(By.id("input_4"));
        email.sendKeys("celilsvm24@gmail.com");
        WebElement adress= driver.findElement(By.id("input_5_addr_line1"));
        adress.sendKeys("Ümraniye Santral");
        WebElement city= driver.findElement(By.id("input_5_city"));
        city.sendKeys("İstanbul");
        WebElement code = driver.findElement(By.id("input_5_postal"));
        code.sendKeys("34760");
        WebElement country = driver.findElement(By.cssSelector("select[class='form-dropdown form-address-country noTranslate']>:nth-child(226)"));
        country.click();
        Thread.sleep(1000);
        WebElement itBrans=driver.findElement(By.cssSelector("select[name='q6_itBransiniz']>:nth-child(3)"));
        itBrans.click();
        WebElement date=driver.findElement(By.id("lite_mode_10"));
        date.sendKeys("01-30-1997");
        WebElement text= driver.findElement(By.cssSelector("textarea[id='input_8']"));
        text.sendKeys("Merhaba Bu Bir Testtir");
        WebElement submit=driver.findElement(By.cssSelector("button[class='form-submit-button submit-button jf-form-buttons jsTest-submitField']"));
        submit.click();


        try {
            WebElement thank= driver.findElement(By.cssSelector("h1[class='thankyou-main-text ty-text']"));
            String textThank=thank.getText();
            Assert.assertTrue(textThank.equalsIgnoreCase("Thank You!"));
            System.out.println("Form Başarılı Bir Şekilde Dolduruldu");
        }catch (Exception e){
            System.out.println("Form Doldurulamadı");
        }


    }
}
