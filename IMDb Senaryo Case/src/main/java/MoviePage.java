import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MoviePage extends BasePage {

    By Movie = By.xpath("//a[text()='Caz Mugannisi']");


    public MoviePage(WebDriver driver) {
        super(driver);
    }

    public void selectMovie() {
        click(Movie);
    }

    public boolean isOnMoviePAge() {
        return true;
    }
}
