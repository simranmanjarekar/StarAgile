package com.httpMethods;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class getCookies {
  @Test
  public void getAllCookies() {
	  given().when().get("https://www.google.co.in/").then().log().cookies();
  }
  
  @Test
  public void getCookiesFromResponse() {
	  Response res=given().when().get("https://www.google.co.in/");
	  System.out.println("Cookies value"+res.getCookie("AEC"));
  }
}
