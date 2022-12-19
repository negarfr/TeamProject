package get_requests;

import base_urls.AutomationBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get01 extends AutomationBaseUrl {
/*
    Given
        https://automationexercise.com/api/productsList
     when
        Send Get request
     then
        Status code is 200
     And
        Content code is 200
     And
        Response body should be like all product list
 */
    @Test
    public void get01(){

        // set the url
    spec.pathParam("first","productsList");
        // Set the expected data
        // send the request and get the response
       Response response = given().spec(spec).when().get("/{first}");
       response.jsonPath().prettyPrint();

//        // do Assertion
//        JsonPath jsonPath = response.jsonPath();
//       List<Object> list = response.jsonPath().getList("products");
//        System.out.println("list = " + list);
//        System.out.println(list.size());

        response.then().assertThat().statusCode(200);
//        assertEquals(34,list.size());
//  ==========================================================================



    }
}
