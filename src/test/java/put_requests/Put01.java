package put_requests;

import base_urls.AutomationBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import pojo.Put_Pojo;
import pojo.ResponsePojo;

import java.io.IOException;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class Put01 extends AutomationBaseUrl {
    /*
    Given
     https://automationexercise.com/api/brandsList
     And
       {
                "id": 29,
                "brand": "Bellissima"
                }
     When
     send PUT request
     THEN
     Response code 405
     AND
     Response Message: This request method is not supported
     */

    @Test
    public void put01() throws IOException {

        spec.pathParam("first","brandList");

        //set expectedata
        Put_Pojo expectedData = new Put_Pojo(29,"Bellissima");
        System.out.println("expectedData = " + expectedData);
        // send request
        Response response =given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().put("/{first}");
        response.prettyPrint();

        //assertion ==> to do Asssertion we need actualData and to get actualData we need ResponsePojo
        ResponsePojo actualData = new ObjectMapper().readValue(response.asString(),ResponsePojo.class);
        assertEquals(200,response.statusCode());
        assertEquals("405", actualData.getMessage().toString());
        assertEquals("This request method is not supported",actualData);
        
    }

}
