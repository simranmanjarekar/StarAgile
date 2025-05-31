package com.MyTest;

import org.testng.annotations.Test;

public class GetData {
	
  @Test(dataProvider="data", dataProviderClass=com.MyTest.MyData.class)
  public void getData(Integer n, String s) {
	  System.out.println(n);
	  System.out.println(s);
  }
}
