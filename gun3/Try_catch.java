package gun3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

public class Try_catch extends BaseStaticDriver {
    public static void main(String[] args) {

       Login();
       try {
           WebElement urun= driver.findElement(By.cssSelector("img[alt='Sauce Labs Backpack']"));
           urun.click();
       }catch (Exception exception){
           System.out.println("Element Bulunamadı "+exception.getMessage());
       }







    }











    public static void Login(){
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }
}
