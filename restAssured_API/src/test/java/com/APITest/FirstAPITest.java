package com.APITest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FirstAPITest {
  @Test
  public void f() {
	  Response res=RestAssured.get("https://restful-booker.herokuapp.com/booking/288");
//	  System.out.println(res.asString());
	  System.out.println(res.asPrettyString());
//	  System.out.println(res.statusCode());
//	  System.out.println(res.getHeader("Content-Type"));
//	  int actualStatusCode=res.statusCode();
//	  Assert.assertEquals(actualStatusCode, 200,"Actual status code is not matched");
	  String firstname=res.jsonPath().getString("firstname");
	  Assert.assertEquals(firstname, "Simran","firstname is not matched");
	  
	  String bookingdates=res.jsonPath().getString("bookingdates.checkin");
	  System.out.println(bookingdates);
	  int price=res.jsonPath().getInt("totalprice");
	  System.out.println(price);
	  
  }
}
