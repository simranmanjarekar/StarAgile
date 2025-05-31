package com.httpMethods;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class BearerAuthToken {
  @Test
  public void BearerAuthToken() {
	  String token="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";
  Response res=(Response)given()
		  .header("Authorization","Bearer"+token)
		  .when().get("https://api.github.com/user/repos");
  res.then().log().body();
  }
}
