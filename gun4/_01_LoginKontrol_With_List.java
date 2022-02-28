package gun4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.util.List;

public class _01_LoginKontrol_With_List extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
         /*
     1- https://www.saucedemo.com/  sitesini acin
     2- Ekranda gorunen usernameleri bir string diziye atiniz
     3- Bu username ve passwordlarını hepsinin login olup olamadığını
        login olduktan sonraki sayfada Products kelimesinin kontrol ederek
        doğrulayınız.
        diğer login kontrolleri için navigate.back kullanınız.
     4- Login olamayan userları ve hata bilgisini yazdırınız.
     */

        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        WebElement usernames=driver.findElement(By.cssSelector("div[ id='login_credentials']"));
        String names=usernames.getText();
       // System.out.println(names);
        String[] userNames = names.split("\n");
        for (int i = 1; i < userNames.length ; i++) {
            WebElement username= driver.findElement(By.id("user-name"));
            username.clear();
            username.sendKeys(userNames[i]);

            WebElement password=driver.findElement(By.id("password"));
            password.clear();
            password.sendKeys("secret_sauce");

            WebElement login = driver.findElement(By.id("login-button"));
            login.click();

            List<WebElement> products = driver.findElements(By.cssSelector("span[class='title']"));

            if (products.size()==1){
                System.out.println(userNames[i] + " : Bu username ile Login olundu....");
                Thread.sleep(1000);
                driver.navigate().back();
            }else{
                WebElement erorMessage = driver.findElement(By.cssSelector("div[class='error-message-container error']"));
                System.out.println(userNames[i] + " : Bu username ile Login olunumadi.... " + erorMessage.getText() );
            }



        }

    }
}
