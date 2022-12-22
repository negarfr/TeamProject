package delete_request;

import base_urls.AutomationBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojo.ResponsePojo;
import utils.JsonUtils;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Delete_01 extends AutomationBaseUrl {

    //API 10: POST To Verify Login with invalid details

        /*
     Given
          https://automationexercise.com/api/verifyLogin
      When
          User sends Post request
      Then
          Status Code is 404
       And
          Response message : User not found!
     */

    @Test
    public void delete01() {
        //Set the url
        spec.pathParam("first", "verifyLogin");

        //Send the request and get the response
        Response response = given().spec(spec).
                urlEncodingEnabled(true).
                header("Accept", ContentType.JSON.getAcceptHeader()).
                delete("/{first}");
        response.jsonPath().prettyPrint();


        //Do Assertion


//         ResponsePojo actualData = new ObjectMapper().readValue(response.asString(),ResponsePojo.class);
//         System.out.println("actualData = " + actualData);

        ResponsePojo actualData = JsonUtils.covertJsonToJavaObject(response.asString(), ResponsePojo.class);
        System.out.println("actualData = " + actualData);

//
        assertEquals(200, response.statusCode());
        assertEquals("405", actualData.getResponseCode().toString());
        assertEquals("This request method is not supported.", actualData.getMessage());

    }


}
