import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class HomePage extends BasePage {


    By MenuButton = By.id("imdbHeader-navDrawerOpen--desktop");
    By Oscars = By.xpath("//*[@id=\"imdbHeader\"]/div[2]/aside/div/div[2]/div/div[3]/span/div/div/ul/a[1]/span");
    By SearchBoxButton = By.id("suggestion-search");


    public HomePage(WebDriver driver) {

        super(driver);
    }

    public void clickAndPick() {
        click(MenuButton);
        click(Oscars);
    }

    public void searchBox(){
        find(SearchBoxButton).sendKeys("The Jazz Singer"+ Keys.ENTER);
    }

    public boolean isOnHomePage() {
        return isDisplayed(MenuButton);
    }
}
