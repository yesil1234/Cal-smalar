package gun3;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

public class NavigateTo extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {

             //try catch classındaki metodu çağırdım
        driver.navigate().to("https://www.saucedemo.com/");
        Login();

        WebElement urun_1= driver.findElement(By.linkText("Sauce Labs Backpack"));
        System.out.println(urun_1.getText());
        urun_1.click();
        Thread.sleep(5000);
        driver.navigate().back();
        String backSite=driver.getCurrentUrl();
        try {
            String expevted1="https://www.saucedemo.com/inventory.html";
            Assert.assertEquals("YANLIS URL!",expevted1,backSite);
        }catch (AssertionError e){ //asserrt işlemine karşı bir hata alınmasına karşı kendi özel type yazılması gerek AssertionError
            System.out.println("massage"+e.toString());
            System.out.println("assert işlemi yapılamadı");
        }

        Thread.sleep(5000);
        driver.navigate().forward();
        String forwardSite=driver.getCurrentUrl();
        String expected2="https://www.saucedemo.com/inventory-item.html?id=4";
        Assert.assertEquals("YANLIS URL!",expected2,forwardSite);


        Thread.sleep(1000);

        driver.quit();







    }



    public static void Login(){
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }
}
