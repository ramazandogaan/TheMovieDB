package api;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.ConfigReader;

import static io.restassured.RestAssured.given;

public class WatchList_7_8_9 extends BaseTest {
    private String token = ConfigReader.get("token");
    private int accountID = 22482321;


    @Test(priority = 1)
    public void getRatedMovies() {
        Response response =
                given()
                        .spec(request)
                        .header("Authorization", "Bearer " + token)
                        .pathParam("account_id", accountID)

                        .when()
                        .get("/account/{account_id}/rated/movies")

                        .then()
                        .statusCode(200)
                        .extract().response();

        System.out.println(response.body().prettyPrint());
        System.out.println(response.getStatusCode());
    }

    @Test(priority = 2)
    public void getWatchlistMovies() {
        Response response =
                given()
                        .spec(request)
                        .header("Authorization", "Bearer " + token)
                        .pathParam("account_id", accountID)

                        .when()
                        .get("/account/{account_id}/watchlist/movies")

                        .then()
                        .statusCode(200)
                        .extract().response();

        System.out.println(response.body().prettyPrint());
        System.out.println("Status code: " + response.getStatusCode());
    }

    @Test(priority = 3)
    public void getMovieGenres() {
        Response response =
                given()
                        .spec(request)
                        .header("Authorization", "Bearer " + token)

                        .when()
                        .get("/genre/movie/list")

                        .then()
                        .statusCode(200)
                        .extract().response();

        System.out.println(response.body().prettyPrint());
        System.out.println("Status code: " + response.getStatusCode());
    }
}
