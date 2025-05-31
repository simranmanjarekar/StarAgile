package com.httpMethods;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class putRequest {
  @Test
  public void testPutRequest() {
	  HashMap<String,Object> data= new HashMap<String,Object>();
	  data.put("name", "Simran");
	  data.put("job", "Teacher");
	  
	  given().contentType("application/json").body(data).when().put("https://reqres.in/api/users/2").then().statusCode(200).body("name",equalToIgnoringCase("Simran")).log().body();
	  
  }
}
