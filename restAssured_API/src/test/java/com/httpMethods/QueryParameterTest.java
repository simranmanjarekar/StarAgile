package com.httpMethods;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class QueryParameterTest {
  @Test
  public void queryPathParameter() {
	  given().pathParam("path", "users").queryParam("page", 1).when().get("https://reqres.in/api/{path}").then().statusCode(200).log().all();
	  
  }
}
