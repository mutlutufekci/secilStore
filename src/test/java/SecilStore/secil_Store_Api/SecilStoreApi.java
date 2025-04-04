package SecilStore.secil_Store_Api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static com.google.common.base.Predicates.equalTo;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class SecilStoreApi {

    @Test
    public void get01() {
//        i) Set the url --> endpoint'i kur.
        String url = "https://restful-booker.herokuapp.com/booking/55";

//        ii) Set the expected data --> Bu adımı post ve put gibi data gönderilecek method' larda yapacağız.

//        iii) Send the request and get the response --> request'i gönder ve response'ı al.
        Response response = given().get(url);
        response.prettyPrint();

//        iv) Do assertion --> Doğrulama yap.
        response.then()
                .statusCode(200)//HTTP Status Code should be 200
                .contentType("application/json")//Content Type should be "application/json"
                .statusLine("HTTP/1.1 200 OK");//Status Line should be "HTTP/1.1 200 OK"
    }
}
