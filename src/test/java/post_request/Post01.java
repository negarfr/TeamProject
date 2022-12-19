package post_request;

import base_urls.AutomationBaseUrl;
import io.restassured.http.ContentType;


import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import pojo.CategoryPojo;
import pojo.ProductListPojo;

import pojo.ResponsePojo;
import pojo.UserType;

import java.io.IOException;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Post01 extends AutomationBaseUrl {
/*
    Test case:

    Given
    https://automationexercise.com/api/productsList
    When
    User sends POST request
    And {   "id": 44,
            "name": "Red Top",
            "price": "Rs. 600",
            "brand": "Polo",
            "category": {
        "usertype": {
            "usertype": "Women"
        },
        "category": "Tops"
    }
    }
    Then
    Status code is 405
    And
    Response Message should be "This request method is not supported."
*/

    @Test
    public void post01() throws IOException {

// set the url
    spec.pathParam("first","productList");

// set the expected Data

        UserType userType = new UserType("Women");
        CategoryPojo category = new CategoryPojo("usertype","Tops");
        ProductListPojo expectedData = new ProductListPojo(44, "Red Top","Rs. 600","Polo",category);

// send request get the response

        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
        response.jsonPath().prettyPrint();

// Do-Assertion ===> De-Serialization ==> for this we need to create ResponsePojo class
// need to create Util for Objectmapper
        ResponsePojo actualData = new ObjectMapper().readValue(response.asString(),ResponsePojo.class);
        System.out.println("actualData = " + actualData);

//  Do-Assertion
        assertEquals(200,response.statusCode());
        assertEquals("405",actualData.getResponseCode().toString());
        assertEquals("This request method is not supported.",actualData.getMessage());







    }
}