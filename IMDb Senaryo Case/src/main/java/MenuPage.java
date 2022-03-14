import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuPage extends BasePage {

    By OscarsYear = By.xpath("//*[@class='event-history-widget__title']");

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnMenuPage() {
        return isDisplayed(OscarsYear);
    }
}
