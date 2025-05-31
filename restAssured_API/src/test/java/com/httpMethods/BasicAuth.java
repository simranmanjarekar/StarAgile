package com.httpMethods;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.response.Response;

public class BasicAuth {
  @Test
  public void basicAuthentication() {
	  
//	 Response res= given().auth().basic("postman","password")
//	  .when().get("");
	 
	 Response res=given().auth().digest("postman","password")
			 .when().get("https://postman-echo.com/basic-auth");
	 res.then().log().body();
	 
	 boolean status=res.jsonPath().getBoolean("authenticated");
	 Assert.assertEquals(status, true);
  }
}
