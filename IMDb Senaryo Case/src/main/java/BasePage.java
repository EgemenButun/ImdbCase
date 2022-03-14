import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement find(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public List<WebElement> findAll(By locator) {
        return driver.findElements(locator);
    }

    public void click(By locator){
        find(locator).click();
    }

    public void type(By locator, String text){
        find(locator).sendKeys(text);
    }

    public Boolean isDisplayed(By locator){
        return find(locator).isDisplayed();
    }

    public static void kontrol(String Nesne1, String Nesne2) {
        boolean aynıMı = false;

        if (Nesne1.toLowerCase().equals(Nesne2.toLowerCase())) {
            aynıMı = true;
            System.out.println("Geçti");
        } else {
            System.out.println("Bulunan İki Nesne Aynı Değil.");
        }
    }

    public String metinAl(By yer) {
        return find(yer).getText();
    }

    public void kaydırTıkla(By bul, int timeout) {

        for (int i = 0; i < timeout; i++) {
            if (find(bul) != null) {
                break;
            } else {
                find(bul).sendKeys(Keys.PAGE_DOWN);
            }
        }
        find(bul).click();
    }


}
