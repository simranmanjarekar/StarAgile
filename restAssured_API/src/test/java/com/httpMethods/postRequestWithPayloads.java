package com.httpMethods;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class postRequestWithPayloads {
  @Test
  public void basicPayload() {
	  
	  Response res=given().body("{\n"
	  		+ "    \"name\": \"morpheus\",\n"
	  		+ "    \"job\": \"leader\"\n"
	  		+ "}").when().post("https://reqres.in/api/users");
	  
	  Assert.assertEquals(res.getStatusCode(),201);
	  System.out.println("Status code is "+res.getStatusCode());
	  res.then().log().body(); 
  }
  
  @Test
  public void requestPayloadWithHashmap() {
	  HashMap<String,Object> data=new HashMap<String,Object>();
	  data.put("name","Simran");
	  data.put("job","Student");
	  
	  given().contentType("application/json")
	  .body(data)
	  .when().post("https://reqres.in/api/users")
	  .then().statusCode(201)
	  .body("name",equalToIgnoringCase("Simran"))
	  .log().body();
  }
  

  @Test
  public void requestPayloadWithPojoClass() {
	  pojoData data=new pojoData();
	  data.setName("Ketan");
	  data.setJob("Student");
	  given().contentType("application/json")
	  .body(data)
	  .when().post("https://reqres.in/api/users")
	  .then().statusCode(201)
	  .body("name",equalToIgnoringCase("Ketan"))
	  .log().body();
  }
  
}
