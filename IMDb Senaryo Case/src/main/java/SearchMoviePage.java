import org.openqa.selenium.WebDriver;

public class SearchMoviePage extends BasePage {
    public SearchMoviePage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnSearchMoviePage() {
        return true;
    }
}
