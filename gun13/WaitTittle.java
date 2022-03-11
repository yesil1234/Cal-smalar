package gun13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseStaticDriver;

import java.time.Duration;

public class WaitTittle extends BaseStaticDriver {
    /*
        https://www.yogaalliance.org/  siteye gidiniz
        Action ile Become a Member uzerine geliniz
        Teacher click yapiniz
        title  "Teachers | Yoga Alliance"  olana kadar beklet

     */
    public static void main(String[] args) {

        driver.get("https://www.yogaalliance.org/");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Actions builder= new Actions(driver);


        WebElement becomeEMember= driver.findElement(By.xpath("//a[text()='Become a Member']"));
        Action action=builder.moveToElement(becomeEMember).build();
        action.perform();

        WebElement teacher= driver.findElement(By.xpath("//li[@class='category child-3']/a[text()='Teachers']"));
        teacher.click();

        String expected= "Teachers | Yoga Alliance";

        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));

        boolean title_1= wait.until(ExpectedConditions.titleIs(expected));
        String resulttitle=driver.getTitle(); //bulunduğumuz sayfanın titlesi

        System.out.println(resulttitle);

        driver.quit();
    }
}
