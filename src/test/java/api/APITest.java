package api;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.hamcrest.Matchers;
import org.json.JSONObject;

import java.io.File;

import static io.restassured.RestAssured.given;

public class APITest {


    public static void getUserById(Integer ID, boolean shouldPass) {
        RestAssured.baseURI = "https://reqres.in/";

        File JsonSchema = new File("src/test/resources/JsonSchema/Get_Scema.json");

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
                    .assertThat().body("data.email", Matchers.endsWith("@reqres.in"))
                    .assertThat().body(JsonSchemaValidator.matchesJsonSchema(JsonSchema));
        } else {
            given()
                    .pathParam("id", ID)
                    .log().all()
                    .when()
                    .get("api/users/{id}")
                    .then()
                    .log().all()
                    .assertThat().statusCode(404);
        }
    }




    public void postUser(String name, String job, boolean shouldPass) {
        RestAssured.baseURI = "https://reqres.in/";

        File JsonSchema = new File("src/test/resources/JsonSchema/Post_Schema.json");


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
                    .assertThat().body("$", Matchers.hasKey("createdAt"))
                    .assertThat().body(JsonSchemaValidator.matchesJsonSchema(JsonSchema));
        } else {
            given().log().all()
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .body(jsonObject.toString())
                    .post("/api/users")
                    .then()
                    .assertThat().statusCode(400);
        }
    }



    public static void putUser(Integer ID, String name, String job, boolean shouldPass){
        RestAssured.baseURI = "https://reqres.in/";


        File JsonSchema = new File("src/test/resources/JsonSchema/Put_Schema.json");


        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userID", ID);
        jsonObject.put("name", name);
        jsonObject.put("job", job);

        String fname = given().when().get("api/users/2"+ID).getBody().jsonPath().get("data.name");
        System.out.println("name before ="+fname);



        if (shouldPass) {
            given().log().all()
                    .header("Content-Type", "application/json")
                    .body(jsonObject.toString())
                    .put("api/users/2" + ID)
                    .then().log().all()
                    .assertThat().statusCode(200)
                    .assertThat().body("name", Matchers.equalTo(name))
                    .assertThat().body("job", Matchers.equalTo(job))
                    .assertThat().body(JsonSchemaValidator.matchesJsonSchema(JsonSchema));
        }

        else {
            given().log().all()
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .body(jsonObject.toString())
                    .post("/api/users")
                    .then()
                    .assertThat().statusCode(400);
        }
    }



    public void deleteUser(int expectedStatusCode) {
        RestAssured.baseURI = "https://reqres.in/";

        given().log().all()
                .when().delete("/api/users/2")
                .then()
                .log().all()
                .assertThat().statusCode(expectedStatusCode);
    }

    public void getTagsList(boolean shouldPass) {
        RestAssured.baseURI = "https://reqres.in/";


        File JsonSchema = new File("src/test/resources/JsonSchema/GetTags_Scheme.json");


        if (shouldPass) {
            given().log().all()
                    .when().get("/api/tags")
                    .then()
                    .log().all()
                    .assertThat().statusCode(200)
                    .assertThat().body("data", Matchers.notNullValue())
                    .assertThat().body("data", Matchers.hasSize(Matchers.greaterThan(0)))
                    .assertThat().body("data.id", Matchers.hasItem(Matchers.anything()))
                    .assertThat().body(JsonSchemaValidator.matchesJsonSchema(JsonSchema));
        } else {
            given().log().all()
                    .when().get("/api/tags")
                    .then()
                    .log().all()
                    .assertThat().statusCode(404);
        }
    }



}

