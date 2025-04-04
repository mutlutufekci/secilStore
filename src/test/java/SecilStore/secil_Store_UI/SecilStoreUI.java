package SecilStore.secil_Store_UI;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.time.DurationUtils;
import org.apache.hc.core5.util.TimeValue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SecilStoreUI {


    public static void main(String[] args) {

        WebDriverManager.edgedriver().setup();
        EdgeDriver driver = new EdgeDriver(new EdgeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://secilstore.com");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement cerez = driver.findElement(By.xpath("//*[text()='Kabul Et']"));
        cerez.click();

        WebElement giris_yap = driver.findElement(By.xpath("(//*[text()=\"Giriş Yap\"])[2]"));
        giris_yap.click();



    }



}
