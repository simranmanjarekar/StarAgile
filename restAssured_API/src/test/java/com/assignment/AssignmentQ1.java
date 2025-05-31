package com.assignment;

//endpoint: https://petstore.swagger.io/v2/pet/findByStatus?status=available

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class AssignmentQ1 {
	int id;
  @Test(priority=0)
  public void findPet() {
	  given().accept("application/json").when().get("https://petstore.swagger.io/v2/pet/findByStatus?status=available")
	  .then().statusCode(200).body("name",hasItem("doggie")).log().body();
	  
  }
  
  @Test(priority=1)
  public void AddPet() {
	  Response res=given().accept("application/json").contentType("application/json").body("{\n"
	  		+ "\"id\": 111,\n"
	  		+ "\"category\": {\n"
	  		+ "\"id\": 0,\n"
	  		+ "\"name\": \"string\"\n"
	  		+ "},\n"
	  		+ "\"name\": \"Mani\",\n"
	  		+ "\"photoUrls\": [\n"
	  		+ "\"string\"\n"
	  		+ "],\n"
	  		+ "\"tags\": [\n"
	  		+ "{\n"
	  		+ "\"id\": 0,\n"
	  		+ "\"name\": \"string\"\n"
	  		+ "}\n"
	  		+ "],\n"
	  		+ "\"status\": \"available\"\n"
	  		+ "}").when().post("https://petstore.swagger.io/v2/pet");
	  res.then().statusCode(200).body("id", equalTo(111)).body("name", equalTo("Mani")).log().body();
	  id=res.jsonPath().getInt("id");
  }
  
  @Test(priority=2)
  public void findPetForSameGeneratedId() {
	  given().accept("application/json").when().get("https://petstore.swagger.io/v2/pet/111").then().statusCode(200)
	  .body("id", equalTo(111)).body("name", equalTo("Mani")).log().body();
  }
  
  @Test(priority=3)
  public void UpdateExistingPet() {
	  given().accept("application/json").contentType("application/json").body("{\n"
	  		+ "\"id\": 111,\n"
	  		+ "\"category\": {\n"
	  		+ "\"id\": 0,\n"
	  		+ "\"name\": \"string\"\n"
	  		+ "},\n"
	  		+ "\"name\": \"doggie\",\n"
	  		+ "\"photoUrls\": [\n"
	  		+ "\"string\"\n"
	  		+ "],\n"
	  		+ "\"tags\": [\n"
	  		+ "\"id\": 0,\n"
	  		+ "\"name\": \"string\"\n"
	  		+ "}\n"
	  		+ "],\n"
	  		+ "\"status\": \"available\"\n"
	  		+ "}").when().put("https://petstore.swagger.io/v2/pet").then().statusCode(200)
	  .body("name", equalTo("doggie")).log().body();
  }
  
  @Test(priority=4)
  public void deletePet() {
	  given().accept("application/json").when().delete("https://petstore.swagger.io/v2/pet/111").then().statusCode(200).log().body();
  }
  
}
