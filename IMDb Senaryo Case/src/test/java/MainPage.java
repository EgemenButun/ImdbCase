import org.junit.jupiter.api.*;

import java.io.IOException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MainPage extends BaseTest{

    HomePage homePage;
    MenuPage menuPage;
    SelectMoviePage selectmoviePage;
    MovieDetailPage movieDetailPage;
    SearchMoviePage searchMoviePage;
    MoviePage moviePage;
    String temp = "";

    @Test
    @Order(1)
    public void tanimlar(){
        homePage = new HomePage(driver);
        menuPage = new MenuPage(driver);
        selectmoviePage = new SelectMoviePage(driver);
        movieDetailPage = new MovieDetailPage(driver);
        searchMoviePage = new SearchMoviePage(driver);
        moviePage = new MoviePage(driver);
    }

    @Test
    @Order(2)
    public void clickMenuAndPickOscar(){
        homePage.clickAndPick();
        Assertions.assertTrue(menuPage.isOnMenuPage(), "Not on Menu page");
    }

    @Test
    @Order(3)
    public void selectYearAndMovie() {
        selectmoviePage.selectedMovie();
        Assertions.assertTrue(movieDetailPage.isOnMovieDetailPage(), "Not on Movie Detail Page");
    }

    @Test
    @Order(4)
    public void recordMovieDetails(){
        temp = movieDetailPage.getFirstMovieDetails();
    }

    @Test
    @Order(5)
    public void goHomePage(){
        movieDetailPage.goHomePage();
        Assertions.assertTrue(homePage.isOnHomePage(),"not home page");
    }

    @Test
    @Order(6)
    public void searchMovie(){
        homePage.searchBox();
        Assertions.assertTrue(searchMoviePage.isOnSearchMoviePage(),"not true page");
    }

    @Test
    @Order(7)
    public void selectMovie(){
        moviePage.selectMovie();
        Assertions.assertTrue(moviePage.isOnMoviePAge(),"not true page");
    }

    @Test
    @Order(8)
    public void controlMovieDetails(){
        Assertions.assertEquals(movieDetailPage.getFirstMovieDetails(),temp);
    }

    @Test
    @Order(9)
    public void goPhotos(){
        movieDetailPage.clickPhotos();
    }

    @Test
    @Order(10)
    public void isBroken() throws IOException {
        Assertions.assertTrue(movieDetailPage.isBrokenPhotos(),"Linkler Sağlam");
    }

}
