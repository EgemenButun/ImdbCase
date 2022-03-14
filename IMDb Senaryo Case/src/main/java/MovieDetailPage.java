import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MovieDetailPage extends BasePage {

    By movieDetail = By.xpath("//*[@id=\"__next\"]/main/div/section[1]/section/div[3]/section/section/div[1]/div[1]/div[2]/ul/li[1]/a");
    By director = By.xpath("//*[@id=\"__next\"]/main/div/section[1]/section/div[3]/section/section/div[3]/div[2]/div[1]/div[3]/ul/li[1]/div");
    By writers = By.xpath("//*[@id=\"__next\"]/main/div/section[1]/section/div[3]/section/section/div[3]/div[2]/div[1]/div[3]/ul/li[2]/div");
    By stars = By.xpath("//*[@id=\"__next\"]/main/div/section[1]/section/div[3]/section/section/div[3]/div[2]/div[1]/div[3]/ul/li[3]/div");
    By IMDbButton = By.id("home_img_holder");
    By Photos = By.xpath("//*[@data-testid='photos-title']");
    By photosNumber = By.id("left");
    By link = By.xpath("//*[@id='media_index_thumbnail_grid']/a");

    public MovieDetailPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnMovieDetailPage() {
        return isDisplayed(movieDetail);
    }

    public String getFirstMovieDetails() {
        String directorlist = metinAl(director);
        String writerslist = metinAl(writers);
        String starslist = metinAl(stars);
        return directorlist + writerslist + starslist;

    }
    
    public void goHomePage() {
        click(IMDbButton);
    }


    public void clickPhotos() {
        kaydırTıkla(Photos,10);
    }

    public boolean isBrokenPhotos() throws IOException {
        String deneme[] = metinAl(photosNumber).split(" ");
        int photoCount = Integer.parseInt(deneme[0]);
        ArrayList<Boolean> result = new ArrayList<Boolean>();


        List<WebElement> photos = findAll(link);

        for(int i=0;i<photoCount;i++){

            String photoLink = photos.get(i).getAttribute("href");

            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(photoLink);
            HttpResponse response = client.execute(request);
            int statusCode = response.getStatusLine().getStatusCode();

            if (statusCode == 200)
                result.add(true);
            else
                result.add(false);
        }
        System.out.println(result);

        if(result.contains(false))
            return false;
        else
            return true;
    }

}
