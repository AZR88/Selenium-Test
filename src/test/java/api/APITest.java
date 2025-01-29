package api;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class APITest {


    public static void GetUserById(Integer ID, boolean shouldPass) {
        RestAssured.baseURI = "https://reqres.in/";

        if (shouldPass) {
            given()
                    .pathParam("id", ID)
                    .log().all()
                    .when()
                    .get("api/users/{id}")
                    .then()
                    .log().all()
                    .assertThat().statusCode(200)
                    .assertThat().body("data.id", Matchers.equalTo(ID))
                    .assertThat().body("data.first_name", Matchers.notNullValue())
                    .assertThat().body("data.email", Matchers.endsWith("@reqres.in"));
        } else {
            given()
                    .pathParam("id", ID)
                    .log().all()
                    .when()
                    .get("api/users/{id}") // Path parameter tetap digunakan
                    .then()
                    .log().all()
                    .assertThat().statusCode(404);
        }
    }




    public void PostUser(String name, String job, boolean shouldPass) {
        RestAssured.baseURI = "https://reqres.in/";

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);
        jsonObject.put("job", job);

        if (shouldPass) {
            given().log().all()
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .body(jsonObject.toString())
                    .post("/api/users")
                    .then()
                    .assertThat().statusCode(201)
                    .assertThat().body("name", Matchers.equalTo(name))
                    .assertThat().body("job", Matchers.equalTo(job))
                    .assertThat().body("$", Matchers.hasKey("id"))
                    .assertThat().body("$", Matchers.hasKey("createdAt"));
        } else {
            given().log().all()
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .body(jsonObject.toString())
                    .post("/api/users")
                    .then()
                    .assertThat().statusCode(400); // Status code untuk negative test
        }
    }



    public static void  PutUser(Integer ID, String name, String job, boolean shouldPass){
        RestAssured.baseURI = "https://reqres.in/";

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userID", ID);
        jsonObject.put("name", name);
        jsonObject.put("job", job);

        String fname = given().when().get("api/users/2"+ID).getBody().jsonPath().get("data.name");
        String ljob = given().when().get("api/users/2"+ID).getBody().jsonPath().get("data.job");
        System.out.println("name before ="+fname);



        if (shouldPass){
            given().log().all()
                    .header("Content-Type","application/json")
                    .body(jsonObject.toString())
                    .put("api/users/2"+ID)
                    .then().log().all()
                    .assertThat().statusCode(200)
                    .assertThat().body("name", Matchers.equalTo(name))
                    .assertThat().body("job", Matchers.equalTo(job));}

        else {
            given().log().all()
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .body(jsonObject.toString())
                    .post("/api/users")
                    .then()
                    .assertThat().statusCode(400); // Status code untuk negative test}
        }
    }


    public static void  PatchUser(Integer ID, String name, String job, boolean shouldPass){
        RestAssured.baseURI = "https://reqres.in/";

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userID", ID);
        jsonObject.put("name", name);
        jsonObject.put("job", job);


        String fname = given().when().get("api/users/2"+ID).getBody().jsonPath().get("data.name");
        String ljob = given().when().get("api/users/2"+ID).getBody().jsonPath().get("data.job");
        System.out.println("name before ="+fname);



        if (shouldPass){
            given().log().all()
                    .header("Content-Type","application/json")
                    .body(jsonObject.toString())
                    .put("api/users/2"+ID)
                    .then().log().all()
                    .assertThat().statusCode(200)
                    .assertThat().body("name", Matchers.equalTo(name))
                    .assertThat().body("job", Matchers.equalTo(job));}

        else {
            given().log().all()
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .body(jsonObject.toString())
                    .post("/api/users")
                    .then()
                    .assertThat().statusCode(400); // Status code untuk negative test}
        }
    }

    public void DeleteUser(int expectedStatusCode) {
        RestAssured.baseURI = "https://reqres.in/";

        given().log().all()
                .when().delete("/api/users/2")
                .then()
                .log().all()
                .assertThat().statusCode(expectedStatusCode);
    }


}

