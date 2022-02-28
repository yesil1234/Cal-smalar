package gun6;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.util.ArrayList;
import java.util.List;

public class xpath extends BaseStaticDriver {
    /*
    * siteye git
    * bütün ürünleri sepete ekle
    * sepete git
    * önceki ürünler ile sepettekileri kıyasla
    * dogruysa checkout yap
    * cıkan formu dolfur
    * contunue tıkla
    * total fiyatı kıayasla
    * finish butonuna tıkla
    * thank you for order yazısını sayfada oldugunu onayla
    * back home tıkla bulundugu sayfanın urlsini kontrol et https://www.saucedemo.com/inventory.html

     */
    public static void main(String[] args) throws InterruptedException {

        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        List<WebElement> urunList1=driver.findElements(By.xpath("//div[@class='inventory_item_name']"));

        List<String> list1=new ArrayList<>();

        for (WebElement urun:urunList1) {
            list1.add(urun.getText());
        }

        List<WebElement> urunPrice1=driver.findElements(By.xpath("//div[@class='inventory_item_price']"));

        List<String> price1=new ArrayList<>();
        for (WebElement urun:urunPrice1) {
            price1.add(urun.getText());
        }


        List<WebElement> addToCart=driver.findElements(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']"));
        for (WebElement e: addToCart) {
            e.click();
        }

        WebElement sepet= driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        sepet.click();

        List<WebElement> cardlistName=driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        List<String> urunList2=new ArrayList<>();
        for (WebElement urun:cardlistName) {
            urunList2.add(urun.getText());
        }

        List<WebElement> urunPrice2=driver.findElements(By.xpath("//div[@class='inventory_item_price']"));

        List<String> price2=new ArrayList<>();
        for (WebElement urun:urunPrice2) {
            price2.add(urun.getText());
        }
        double toplam=0;
        for (int i = 0; i <price2.size() ; i++) {
            String a=price2.get(i).substring(1);
            double b=Double.parseDouble(a);
            System.out.println(b);
            toplam+=b;
            //String sayilar=text.replaceAll("[^0-9]",""); //todo metot yazdığımızda sayılar ve nokta haricindekini temizlemek icin
        }
        System.out.println(toplam+" toplam");

        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i).equalsIgnoreCase(urunList2.get(i))){
                System.out.println(list1.get(i)+" ürün sepette");
            }else {
                System.out.println(list1.get(i)+" ürün onaylanamdı");
            }
        }


        Thread.sleep(2000);
        WebElement chehckout= driver.findElement(By.xpath("//button[@class='btn btn_action btn_medium checkout_button']"));
        chehckout.click();

        WebElement firstName= driver.findElement(By.xpath("//input[@id='first-name']"));
        firstName.sendKeys("celil");

        WebElement lastName= driver.findElement(By.xpath("//input[@id='last-name']"));
        lastName.sendKeys("sevim");

        WebElement zepCode= driver.findElement(By.xpath("//input[@id='postal-code']"));
        zepCode.sendKeys("123");

        WebElement conttinue=driver.findElement(By.xpath("//input[@id='continue']"));
        conttinue.click();

        WebElement totalPrice=driver.findElement(By.xpath("//div[@class='summary_total_label']"));
        String a=totalPrice.getText().substring(8);
        double b=Double.parseDouble(a);
        System.out.println(b);
        System.out.println(totalPrice.getText());

        Thread.sleep(2000);

        if (b==toplam){
            System.out.println("Fiyatlar Eşittir");
        }
        else {
            System.out.println("Fiyatlar Tutarsız");
        }

        WebElement finish=driver.findElement(By.xpath("//button[@class='btn btn_action btn_medium cart_button']"));
        finish.click();

        try {
            WebElement text= driver.findElement(By.xpath("//h2[@class='complete-header']"));
            String ttext=text.getText();
            Assert.assertTrue(ttext.contains("THANK YOU FOR YOUR ORDER"));
            System.out.println("Test İşlemi Tamamlandı");
        }catch (AssertionError e){
            System.out.println("Farklı Bir Sayfadasınız");
        }

    }
}
