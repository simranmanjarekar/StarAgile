package com.MyTest;

import org.testng.annotations.DataProvider;

public class MyData {

  @DataProvider
  public Object[][] data() {
    return new Object[][] {
       { 1, "a" },
       { 2, "b" },
    };
  }
}
