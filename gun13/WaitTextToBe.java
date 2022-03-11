package gun13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseStaticDriver;

import java.time.Duration;

public class WaitTextToBe extends BaseStaticDriver {
    /*
    *Siteye git
    * login olunuz
    * user: Kraft
    * pass : 12345
    * ilk once pass yanlış girilip alert onaylanacak
    * sonra doğru pass tekrar yollanıp login butonuna basılacak
    * Anasayfada "Welcome Kraft" yazısı görününceye kadar bekle
    *
     */
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://www.demoblaze.com/index.html");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement login = driver.findElement(By.id("login2"));
        login.click();
        String user = "Kraft";
        WebElement userName = driver.findElement(By.id("loginusername"));
        userName.sendKeys(user);

        WebElement password = driver.findElement(By.id("loginpassword"));
        password.sendKeys("12377");

        WebElement loginTekrar = driver.findElement(By.cssSelector("button[onclick='logIn()']"));
        loginTekrar.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        password.clear();
        password.sendKeys("12345");

        loginTekrar.click();

        boolean welcome = wait.until(ExpectedConditions.textToBe(By.cssSelector("a#nameofuser"), "Welcome " + user));
        // verdigimiz lokasyonda istedigimiz text görünür oluncaya kadar bekletti

//        String result = driver.findElement(By.cssSelector("a#nameofuser")).getText();
//        Thread.sleep(1000);
//        System.out.println(" = " + result.equals("Welcome " + user));


        System.out.println("welcome = " + welcome);
    }
}
