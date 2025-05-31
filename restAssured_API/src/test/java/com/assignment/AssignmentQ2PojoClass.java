package com.assignment;

import org.testng.annotations.Test;


public class AssignmentQ2PojoClass {
	    private String name;
	    private Object data;
	    
	    public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Object getData() {
			return data;
		}

		public void setData(Object data) {
			this.data = data;
		}

		public static class Data{
			private int year;
			private double price;
			private String CPUmodel;
			private String Harddisksize;
			
			public int getYear() {
				return year;
			}
			public void setYear(int year) {
				this.year = year;
			}
			public double getPrice() {
				return price;
			}
			public void setPrice(double price) {
				this.price = price;
			}
			public String getCPUmodel() {
				return CPUmodel;
			}
			public void setCPUmodel(String cPUmodel) {
				CPUmodel = cPUmodel;
			}
			public String getHarddisksize() {
				return Harddisksize;
			}
			public void setHarddisksize(String harddisksize) {
				Harddisksize = harddisksize;
			}
	    	
	    }
	}


