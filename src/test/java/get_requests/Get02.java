package get_requests;

import base_urls.AutomationBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojo.ResponsePojo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get02 extends AutomationBaseUrl {

    /*
    Given
     https://automationexercise.com/api/brandsList
    When
    send the Get Request
    then
    Response code should be 200
    And
    response body in Json all Brand List
     */

    @Test
    public void get02(){

      // set the URL
      spec.pathParam("first","brandList");

      // Set the expected Data

        List<String> expecteddata = Arrays.asList("Polo", "H&M", "Madame", "Madame", "Mast & Harbour", "H&M", "Madame", "Polo", "Babyhug", "Babyhug", "Allen Solly Junior",
                "Kookie Kids", "Babyhug", "Babyhug", "Kookie Kids", "Allen Solly Junior",
                "Kookie Kids", "Biba", "Biba", "Biba", "Allen Solly Junior", "H&M", "Polo", "Polo",
                "H&M", "Polo", "H&M", "Polo", "Madame", "Biba", "Biba", "Madame",
               "Mast & Harbour", "Mast & Harbour");
        System.out.println("expecteddata = " + expecteddata);
       //send the request
        Response response = given().spec(spec).when().get("/{first}");
        response.jsonPath().prettyPrint();
//      //do Assertion

        assertEquals(200,response.statusCode());
        List<String> actualData = response.jsonPath().getList("product list");
        System.out.println("actualData = " + actualData);
        assertEquals(expecteddata,actualData);




    }



}
