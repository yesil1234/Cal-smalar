package gun2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class getAttiribute {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:/Users/hp/Selenium/Choreme-Driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        WebElement urun_1= driver.findElement(By.linkText("Sauce Labs Backpack"));
        String attiributeDeger= urun_1.getAttribute("Sauce Labs Backpack");
        System.out.println(attiributeDeger);
    }
}
