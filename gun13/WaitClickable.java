package gun13;

import net.bytebuddy.dynamic.DynamicType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseStaticDriver;

import java.time.Duration;

public class WaitClickable extends BaseStaticDriver {
    public static void main(String[] args) {

        driver.get("https://www.demoblaze.com/index.html");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement product_S6 = driver.findElement(By.linkText("Samsung galaxy s6"));
        product_S6.click();

        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[onclick='addToCart(1)']")));
        WebElement addToCart = driver.findElement(By.cssSelector("a[onclick='addToCart(1)']"));
        addToCart.click();


        wait.until(ExpectedConditions.alertIsPresent());// alert mesajı çıkana kadar beklemek
        driver.switchTo().alert().accept();
        driver.quit();
    }
}
