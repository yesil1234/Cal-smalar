package gun14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.util.List;
import java.util.Set;

public class OpenWindow extends BaseStaticDriver {
    public static void main(String[] args) {

        driver.get("https://www.selenium.dev/");
        String anaSayfaId=driver.getWindowHandle(); // sayafada yönelme gerçekleşmeden sayfanın id sini kayıt altına aldık

        List<WebElement> targetLinks= driver.findElements(By.cssSelector("a[target='_blank']"));
        // bu liste tıklandığın  da farklı sekmede açılan linklerin listesi
        for (WebElement e:targetLinks) {
            e.click();
        }
        // bu döngüde bu linklere tıkladık

         Set<String> windowHandles = driver.getWindowHandles();
        // farklı sayfada açılan linklerin id lerini set ile kayıt altına aldık
        for (String id:windowHandles) {
            System.out.println(id);
        }
        // bu dögüde açılan linklerin id lerini yazdırdık

        /*
        CDwindow-6440318CBD737D2AE72E1147F11B0D26
        CDwindow-FEABABD155E895D60402229802CCD4E7
        CDwindow-AAD90E5F2DEC3C5821C4C50B7A51DC60
        CDwindow-21F07D6E3B2EFF2BC75D03E083B6B898
        CDwindow-505880137EB48C7F1C68B213C11321EA
        CDwindow-72326F041BECB807F5AC974AA292ED7B
        CDwindow-8E1D8D9A694F72D1A25D647FEE2919FA
        CDwindow-8C2142F477FBD5C16996359569DFCC65
        CDwindow-703516ACC822968A905FCCF509350527
        CDwindow-5A11CDC4857F667F3583120097293868
        CDwindow-3A88DAA50A495E429356D133E17BAB7D
        CDwindow-6460E013122AB6892761595045968022

        */

    }
}
