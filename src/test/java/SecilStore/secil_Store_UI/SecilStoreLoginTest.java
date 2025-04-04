package SecilStore.secil_Store_UI;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.time.Instant;

import static org.junit.Assert.assertTrue;

public class SecilStoreLoginTest {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new EdgeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void loginTest() {
        driver.get("https://secilstore.com");

        WebElement cerez = driver.findElement(By.xpath("//*[text()='Kabul Et']"));
        cerez.click();

        WebElement girisYap = driver.findElement(By.xpath("(//*[text()='Giriş Yap'])[2]"));
        girisYap.click();

        WebElement mailGir = driver.findElement(By.name("email"));
        mailGir.sendKeys("mutlu.tufekci1@gmail.com");

        WebElement sifreGir = driver.findElement(By.name("password"));
        sifreGir.sendKeys("Sifre123");

        WebElement girisYapButon = driver.findElement(By.xpath("//button[contains(text(), 'Giriş')]"));
        girisYapButon.click();

        WebElement hataMesaji = driver.findElement(By.xpath("//div[text()='E-Posta,Telefon numarası yada Şifre hatalı']"));
        boolean actualData = hataMesaji.isDisplayed();
        String expectedData = "E-Posta,Telefon numarası yada Şifre hatalı";
        assertTrue(expectedData,actualData);

        Actions actions = new Actions(driver);
        actions.moveByOffset(50, 50).click().perform();

        WebElement kayitOl = driver.findElement(By.xpath("//a[contains(text(),'Kayıt Ol')]"));
        kayitOl.click();

        driver.findElement(By.xpath("//input[@placeholder='Ad']")).sendKeys("Mutlu");
        driver.findElement(By.xpath("//input[@placeholder='Soyad']")).sendKeys("Tüfekci");
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("mutlu.tufekci@gmail.com.com");
        driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys("Mutlu12345*");
        driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys("Mutlu12345*");
        driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("5305303030");

        driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();

        driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();

        System.out.println("Tüm bilgiler başarıyla dolduruldu. Kayıt butonuna tıklanmadı.");
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}

