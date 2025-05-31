package com.httpMethods;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class GetTestAPI {
  @Test
  public void GetRequest_BDD() {
	  given().when().get("https://reqres.in/api/users/2").then().statusCode(200).log().all();
	  System.out.println("single user validation done!	");
  }
  
  @Test
  public void getPageResponse() {
	  //given().when().get("https://reqres.in/api/users?page=2").then().log().all();
	  given().when().get("https://reqres.in/api/users?page=2").then().statusCode(200)
	  .body("page",equalTo(2)) //1 scenario-validation
	  //.body("data.id", hasItems(7,8,9,10,11,12)) //2 scenario-validation
	  //.body("data.id", hasItems(12,11,10,9,8,7)) //3 scenario-validation
	  .body("data.id", hasItems(12,11))
	  //.body("data.id", contains(7,8,9,10,11,12)) //4 order sequence
	  //.body("data.id", contains(7,8,12,11,10,9)) //5 order sequence
	  .log().body();
  }
}
