package gun16;


import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.BaseStaticDriver;


import java.io.IOException;

public class Main extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException, IOException {

        By usernameText=By.cssSelector("input#txtUsername");
        By passwordText=By.cssSelector("input#txtPassword");
        By loginButton=By.cssSelector("input#btnLogin");
        By welcome=By.cssSelector("a#welcome");

        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");

        sendKeysTo(usernameText,("Admin"));

        sendKeysTo(passwordText,("admin123"));

        clickTo(loginButton);

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(welcome));
        }catch (Exception e){
            takeScreenShot();
        }







    }
}
