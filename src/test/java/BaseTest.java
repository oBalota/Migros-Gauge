import com.thoughtworks.gauge.Step;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
    static WebDriver driver;
    public static WebDriverWait wait;
    @BeforeAll
   @Step("migros.com.tr websitesine gidilir.")
    public void setUp(){

        System.setProperty("webdriver.chrome.driver","properties/chromedriver.exe");
        //driver  = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver  = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.navigate().to("https://www.migros.com.tr/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterAll
   // @Step("Driver kapatılır.")
    public void testDown(){
       // driver.close();
        driver.quit();
    }
}
