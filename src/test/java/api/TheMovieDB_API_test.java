package api;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import utils.BaseTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class TheMovieDB_API_test extends BaseTest {

    String accountId;
    String movieId;
    String movieTitle;
    String listId = "8572161-tteet";

    @Test(priority = 1, description = "Get Account Details")
    public void TC_03() {
        Response response =
                given()
                        .spec(request)

                        .when()
                        .get("/account")

                        .then()
                        .statusCode(200)
                        .extract().response();

        accountId = response.path("id").toString();
        System.out.println("accountId: " + accountId);
    }

    @Test(priority = 2, description = "Add Movie to Favorites")
    public void TC_04() {
        String favoritesBody = """
                {
                    "media_type": "movie",
                    "media_id": 100,
                    "favorite": true
                }
                """;
        given()
                .spec(request)
                .body(favoritesBody)

                .when()
                .post("/account/{id}/favorite", accountId)

                .then()
                .statusCode(201)
                .body("success", equalTo(true))
                .body("status_code", notNullValue())
                .extract().response();
    }

    @Test(priority = 3, description = "Add Movie to Watchlist")
    public void TC_05() {
        String watchlistBody = """
                {
                    "media_type": "movie",
                    "media_id": 100,
                    "watchlist": true
                }
                """;
        given()
                .spec(request)
                .body(watchlistBody)

                .when()
                .post("/account/{id}/watchlist", accountId)

                .then()
                .statusCode(201)
                .body("success", equalTo(true))
                .body("status_code", notNullValue())
                .extract().response();
    }

    @Test(priority = 4, description = "Get Favorite Movies")
    public void TC_06() {
        given()
                .spec(request)

                .when()
                .get("/account/{id}/favorite/movies", accountId)

                .then()
                .statusCode(200)
                .body("results", notNullValue())
                .body("results[1].id", equalTo(550))
                .extract().response();
    }

    @Test(priority = 5, description = "Get Rated Movies")
    public void TC_07() {
        given()
                .spec(request)
                .pathParam("id", accountId)

                .when()
                .get("/account/{id}/rated/movies")

                .then()
                .statusCode(200)
                .extract().response();
    }

    @Test(priority = 6, description = "Get Watchlist Movies")
    public void TC_08() {
        Response response =
                given()
                        .spec(request)
                        .pathParam("id", accountId)
                        .queryParam("movieID", "100")

                        .when()
                        .get("/account/{id}/watchlist/movies")

                        .then()
                        .statusCode(200)
                        .extract().response();
    }

    @Test(priority = 7, description = "Get Movie Genres")
    public void TC_09() {
        given()
                .spec(request)

                .when()
                .get("/genre/movie/list")

                .then()
                .statusCode(200)
                .extract().response();
    }

    @Test(priority = 8, description = "Get Now Playing Movies")
    public void TC_10() {
        given()
                .spec(request)

                .when()
                .get("/movie/now_playing")

                .then()
                .statusCode(200)
                .extract().response();
    }

    @Test(priority = 9, description = "Get Popular Movies")
    public void TC_11() {
        Response response =
                given()
                        .spec(request)

                        .when()
                        .get("/movie/popular")

                        .then()
                        .statusCode(200)
                        .body("results", notNullValue())
                        .body("results[0].popularity", notNullValue())
                        .extract().response();

        movieId = response.path("results[0].id").toString();
        movieTitle = response.path("results[0].title");

        System.out.println("movieId: " + movieId);
        System.out.println("movieTitle: " + movieTitle);
    }

    @Test(priority = 10, description = "Get Top Rated Movies")
    public void TC_12() {
        given()
                .spec(request)

                .when()
                .get("/movie/top_rated")

                .then()
                .statusCode(200)
                .extract().response();
    }

    @Test(priority = 11, description = "Get Upcoming Movies")
    public void TC_13() {
        given()
                .spec(request)

                .when()
                .get("/movie/top_rated")

                .then()
                .statusCode(200)
                .extract().response();
    }

    @Test(priority = 12, description = "Search for Movies")
    public void TC_14() {
        given()
                .spec(request)

                .when()
                .get("/search/movie")

                .then()
                .statusCode(200)
                .extract().response();
    }

    @Test(priority = 13, description = "Get Movie Details")
    public void TC_15() {
        given()
                .spec(request)
                .pathParam("id", movieId)

                .when()
                .get("/movie/{id}")

                .then()
                .statusCode(200)
                .extract().response();
    }

    @Test(priority = 14, description = "Search for Keywords")
    public void TC_16() {
        given()
                .spec(request)

                .when()
                .get("/search/keyword")

                .then()
                .statusCode(200)
                .extract().response();
    }

    @Test(priority = 15, description = "Add Movie Rating")
    public void TC_17() {

        String ratingBody = """
                {
                    "value": 5.5
                }
                """;

        Response response =
                given()
                        .spec(request)
                        .pathParam("id", movieId)
                        .body(ratingBody)

                        .when()
                        .post("/movie/{id}/rating")

                        .then()
                        .statusCode(201)
                        .body("success", equalTo(true))
                        .extract().response();
    }

    @Test(priority = 16, description = "Delete Movie Rating")
    public void TC_18() {
        given()
                .spec(request)
                .pathParam("id", movieId)

                .when()
                .delete("/movie/{id}/rating")

                .then()
                .statusCode(200)
                .body("success", equalTo(true))
                .body("status_message", equalTo("The item/record was deleted successfully."))
                .body("status_code", equalTo(13))
                .extract().response();
    }

    @Test(priority = 17, description = "Search for Keywords")
    public void TC_19() {

        String addBody = """
                {
                    "media_id": 18
                }
                """;

        given()
                .spec(request)
                .body(addBody)
                .pathParam("id", listId)
                .queryParam("session_id", "INVALID_ID_123")

                .when()
                .post("/list/{id}/add_item")

                .then()
                .statusCode(401)
                .extract().response();
    }
}
