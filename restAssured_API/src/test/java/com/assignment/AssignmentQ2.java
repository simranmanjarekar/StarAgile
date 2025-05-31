package com.assignment;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class AssignmentQ2 {
  @Test
  public void CreateUsingPojoClass() {
	  AssignmentQ2PojoClass.Data objectdata=new AssignmentQ2PojoClass.Data();
	  objectdata.setYear(2019);
	  objectdata.setPrice(1849.99);
	  objectdata.setCPUmodel("Intel Core i9");
	  objectdata.setHarddisksize("1 TB");
	  AssignmentQ2PojoClass d=new AssignmentQ2PojoClass();
	  d.setName("Apple MacBook Pro 16");
	  d.setData(objectdata);
	  
	  given().accept("application/json").contentType("application/json").body(d).when().post("https://api.restful-api.dev/objects").then().statusCode(200).log().all();
  }
}
	