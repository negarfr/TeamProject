package post_request;

import base_urls.AutomationBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post02 extends AutomationBaseUrl {

    /*            ///API 5: POST To Search Product
 Given
      https://automationexercise.com/api/searchProduct?search_product=tshirt
    And
        Request Parameter: search_product
  When
      User sends Post request
  Then
      Status Code is 200
   And
      Print on the console  searched products list
 */

    @Test
    public void post02() {
        //Set the url
        spec.pathParam("first", "searchProduct").queryParam("search_product", "jeans");

        //Send the request and get the response
        Response response = given().spec(spec).
                urlEncodingEnabled(true).
                header("Accept", ContentType.JSON.getAcceptHeader()).
                param("search_product", "jeans").
                post("/{first}");
        response.jsonPath().prettyPrint();


        //Do Assertion

        assertEquals(200, response.statusCode());
    }
}