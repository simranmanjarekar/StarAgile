package com.httpMethods;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class getHeaders {
  @Test
  public void getHeaderData() {
	  given().when().get("https://www.google.co.in/").then().log().headers();
  }
  
  @Test
  public void getSpecificHeaderFromResponse() {
	  Response res=given().when().get("https://www.google.co.in/");
	  System.out.println("Header"+res.getHeader("Content-Type"));
	  System.out.println("domain"+res.getHeader("Set-Cookie"));
  }
}
