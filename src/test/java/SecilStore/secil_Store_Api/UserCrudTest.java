package SecilStore.secil_Store_Api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;

public class UserCrudTest {

    static RequestSpecification spec;

    @Before
    public void setup() {
        spec = new RequestSpecBuilder()
                .setBaseUri("https://jsonplaceholder.typicode.com")
                .setContentType(ContentType.JSON)
                .build();
    }
    @Test
    public void getUserTest() {
        Response response = given()
                .spec(spec)
                .when()
                .get("/users");

        response.prettyPrint();

        response.then()
                .statusCode(200)
                .contentType("application/json")
                .statusLine("HTTP/1.1 200 OK");
    }
    @Test
    public void postUserTest() {
        spec.pathParam("first", "users");

        Map<String, Object> userData = new HashMap<>();
        userData.put("name", "Mutlu Tüfekci");
        userData.put("username", "mutlutufekci");
        userData.put("email", "mutlu@example.com");

        Map<String, Object> address = new HashMap<>();
        address.put("street", "Atatürk Caddesi");
        address.put("suite", "No:48/3");
        address.put("city", "Ankara");
        address.put("zipcode", "06600");

        Map<String, String> geo = new HashMap<>();
        geo.put("lat", "39.9208");
        geo.put("lng", "32.8541");
        address.put("geo", geo);

        userData.put("address", address);
        userData.put("phone", "0530-530-3030");
        userData.put("website", "mutlutech.dev");

        Map<String, String> company = new HashMap<>();
        company.put("name", "Tufekci Tech");
        company.put("catchPhrase", "Empower seamless experiences");
        company.put("bs", "innovate scalable infrastructures");
        userData.put("company", company);

        Response response = given()
                .spec(spec)
                .body(userData)
                .when()
                .post("/{first}");

        response.prettyPrint();

        assertEquals(201, response.statusCode());
        assertEquals("Mutlu Tüfekci", response.jsonPath().getString("name"));
        assertEquals("Ankara", response.jsonPath().getString("address.city"));
        assertEquals("mutlutufekci", response.jsonPath().getString("username"));
    }
    @Test
    public void putUserTest() {
        Map<String, Object> updateBody = new HashMap<>();
        updateBody.put("name", "Mutlu Updated");
        updateBody.put("email", "updated@example.com");
        updateBody.put("username", "mutlu_updated");

        Response response = given()
                .spec(spec)
                .body(updateBody)
                .when()
                .put("/users/1");

        response.prettyPrint();

        assertEquals(200, response.statusCode());
        assertEquals("Mutlu Updated", response.jsonPath().getString("name"));
    }
    @Test
    public void deleteUserTest() {
        Response response = given()
                .spec(spec)
                .when()
                .delete("/users/1");

        response.prettyPrint();

        assertEquals(200, response.statusCode());
    }
    @Test
    public void getUserWithInvalidIdTest() {
        Response response = given()
                .spec(spec)
                .when()
                .get("/users/9999");

        response.prettyPrint();

        assertEquals(404, response.statusCode());
    }
}
