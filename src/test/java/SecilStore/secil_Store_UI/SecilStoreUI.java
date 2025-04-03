package SecilStore.secil_Store_UI;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.time.Duration;

public class SecilStoreUI {

    public static void main(String[] args) {

        WebDriverManager.edgedriver().setup();
        EdgeDriver driver = new EdgeDriver(new EdgeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://secilstore.com");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement cerez = driver.findElement(By.xpath("//*[text()='Kabul Et']"));
        cerez.click();

        WebElement giris_yap = driver.findElement(By.xpath("(//*[text()=\"Giriş Yap\"])[2]"));
        giris_yap.click();



    }



}
