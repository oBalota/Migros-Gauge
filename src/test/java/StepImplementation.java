import com.thoughtworks.gauge.Step;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;

public class StepImplementation extends BaseTest {
    private static final Logger logger = Logger.getLogger(StepImplementation.class);
    String istenenText;
    public String selectedPrice;
    static JavascriptExecutor jsExecutor = (JavascriptExecutor)  driver;



   public static WebElement find(By locator) {
            return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    //tıklama metodları
    @Step("<locator> Css'le Tıklandı")
    public static void clickByCss(String locator) {
        find(By.cssSelector(locator)).click();
        logger.info(locator + " " + "Element tıklandı");

    }
    @Step("<idPath> id'le Tıklandı")
    public static void clickById(String idPath) {
        find(By.id(idPath)).click();
        logger.info(idPath + " " + "Element tıklandı");

    }
    @Step("<xPath> xPath'le Tıklandı")
    public static void clickByXPath(String xPath) {
        find(By.xpath(xPath)).click();
        logger.info(xPath + " " + "Element tıklandı");

    }



    //Text-Box'a idlocator metin yazdırma metodu.
    @Step("id ile <locator> ve <text> yazıldı")
    public static void sendTextId(String locator, String text) throws InterruptedException {
        Thread.sleep(3000);
        find(By.id(locator)).sendKeys(text);
    }
    //Text-Box'a cssSelector metin yazdırma metodu.
    @Step("css ile <locator> ve <text> yazıldı")
    public static void sendTextCss(String locator, String text) throws InterruptedException {
        find(By.cssSelector(locator)).sendKeys(text);
        logger.info(locator + " " +text+" "+ "yazıldı");
    }

    //e-posta kontrol
    @Step("<xpathMail>,e-posta <elementText> e-postası ile uyuşuyor mu kontrol edilmesi.")
    public void assertVisibilityOfElement(String xpathMail, String elementText) {
        WebElement element = find(By.xpath(xpathMail));
        istenenText = element.getText();
        Assertions.assertEquals(elementText, istenenText, "istenen e-posta uyuşmuyor.");
        logger.info(elementText + " " + "Elementinin içerik text'i kontrol edildi");
    }

    @Step("<second> saniye kadar bekle")
    public void waitForsecond(int second) throws InterruptedException {
        Thread.sleep(1000 * second);
        logger.info(second + " " + "saniye kadar bekletildi");
    }
    // scrolldown metodu
    @Step("<elementScroll> elementine kaydırma yap")
    public static void scrollToElement(String scrollElement) throws InterruptedException {
        Thread.sleep(2000);
        WebElement elementScroll = find(By.id(scrollElement));
        jsExecutor.executeScript("arguments[0].scrollIntoView();", elementScroll);
        logger.info(scrollElement + " " + "Elemente kaydırıldı");

    }
    @Step("<elementScrollXpath> elementine scroll yap")
    public static void scrollToElementXpath(String scrollElementXpath) throws InterruptedException {
        Thread.sleep(2000);
        WebElement elementScroll = find(By.xpath(scrollElementXpath));
        jsExecutor.executeScript("arguments[0].scrollIntoView();", elementScroll);
        logger.info(scrollElementXpath + " " + "Elemente kaydırıldı");

    }
    //Hover methodu
    @Step("<hoverId> id elementinin üstüne gelindi")
    public static void hoverElementId(String hoverId) {
        WebElement webElement = find(By.id(hoverId));
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).build().perform();
        logger.info(hoverId + " " + "Elementine hover yapıldı");

    }
    @Step("<hoverCss> css elementinin üstüne gelindi")
    public static void hoverElementCss(String hoverCss) {
        WebElement webElement = find(By.cssSelector(hoverCss));
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).build().perform();
        logger.info(hoverCss + " " + "Elementine hover yapıldı");

    }
    // Ürünün fiyatını gettext ile alma
    @Step("<xpathTutar> elementinin değeri alındı")
    public void tutarAssert(String xpathTutar) {
        WebElement selectedCartElement = find(By.xpath(xpathTutar));
        selectedPrice = selectedCartElement.getText();
        logger.info(xpathTutar + " " + "elementinin değeri alındı");
    }

    /*WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(cartPageButtonLocator));
        jsExecutor.executeScript("arguments[0].scrollIntoView();", element);
        Thread.sleep(1000);*/
// ödenecek tutarı tut

    //Ödenecek tutarı kontrol et
   /* @Step("")
    public void checkPrice(String xpathTutari) throws InterruptedException {
        Thread.sleep(2000);
        WebElement odenecekTutarElement = find(By.xpath(xpathTutari));
        String odenecekTutarPrice = odenecekTutarElement.getText();
        logger.info("Ödenecek tutar fiyatı alındı.");


        logger.info("Fiyatlar karşılaştırıldı.");

        if (selectedPrice.equals(odenecekTutarPrice)) {
            System.out.println("Fiyatlar birbirlerine eşit.");
        } else {
            logger.info("Fiyatlar birbirlerini tutmuyor.");
        }
    }*/

    // assert
    @Step("<xpath> li element  selectedprice ile eşleşiyor mu")
    public void assertElementByXpath(String xpath) {
        WebElement element1 = driver.findElement(By.xpath(xpath));
        String odenecekTutarPrice = element1.getText();
        if (selectedPrice.equals(odenecekTutarPrice)) {
            System.out.println("Fiyatlar birbirlerine eşit.");
        } else {
            logger.info("Fiyatlar birbirlerini tutmuyor.");
        }


    }






}