import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectMoviePage extends BasePage {

    By chooseYears = By.xpath("//a[@href='/event/ev0000003/1929/1/?ref_=acd_eh']");

    public SelectMoviePage(WebDriver driver){
    super(driver);
    }

    public void selectedMovie() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(chooseYears));
        click(chooseYears);
        By choosenFilm = By.xpath("//*[@id=\"center-3-react\"]/div/div/div[2]/h3/div/div/div/div[1]/div[2]/div[2]/div[1]/span/span/a");
        kaydırTıkla(choosenFilm,10);
    }
}
