package gun7;

import gun3.Try_catch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.util.ArrayList;
import java.util.List;

public class RandomUrunKontrol extends BaseStaticDriver {
    public static void main(String[] args) {
        /*
        * https://www.saucedemo.com/ siteye git
        * random bir ürün sec
        * urune tıkla
        * bilgilerini kontrol et
        *
         */
        Try_catch.Login();

        List<WebElement> urunList1=driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        List<String> list1= elementToString(urunList1);



        List<WebElement> urunPrice1=driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        List<String> price1= elementToString(urunPrice1);

        List<WebElement> addToCart=driver.findElements(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']"));

        int randomElemanNumarasi= randomSayi(list1.size());
        System.out.println(randomElemanNumarasi);

        String randomUrunText=urunList1.get(randomElemanNumarasi).getText();
        String randomUrunPrice=urunPrice1.get(randomElemanNumarasi).getText();

        addToCart.get(randomElemanNumarasi).click();
        urunList1.get(randomElemanNumarasi).click();


        double a=stringToDouble(randomUrunPrice);

    }

    public static int randomSayi(int size){

        return (int)(Math.random()*(size));
    }

    public static List<String> elementToString(List<WebElement> list) {

        List<String> textList = new ArrayList<>();

        for (WebElement element : list) {
            textList.add(element.getText());
        }

        return textList;
    }
    public static void stringListKontrol(List<String> list1, List<String> list2) {

        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i).equals(list2.get(i))) {
                System.out.println(list1.get(i) + " Urun sepette var...");
            }

//            Assert.assertEquals("Bilgiler eslesmedi",list1.get(i),list2.get(i));
        }

    }
    public static double  stringToDouble(String text){

        //($12.9) (Item total: $9.99)  rakam ve . disinda herseyi temizle dedigimiz icin ikisi icinde gecerli oldu
        String rakamText = text.replaceAll("[^0-9,.]","");  // todo   text.replaceAll("[$]","")

        return Double.parseDouble(rakamText);
    }

}
