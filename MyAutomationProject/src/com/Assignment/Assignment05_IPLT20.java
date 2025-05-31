package com.Assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment05_IPLT20 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.iplt20.com/points-table/men/2024");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        List<WebElement> teams=driver.findElements(By.xpath("//div[@class=\"head-to-head\"]//table/tbody[2]/tr/td[3]/div/h2"));
//	    for(WebElement team:teams) {
//	    	System.out.print(team.getText()+" ");
//	    }
	    int n=0;
	    int w=0;
	    int l=0;

	    for(int i=0;i<teams.size();i++) {
	    	System.out.print(teams.get(i).getText()+" ");
	    List<WebElement> nwls=driver.findElements(By.xpath("//div[@class=\"head-to-head\"]//table/tbody[2]/tr["+(i+1)+"]/td[12]/div/span"));
	    for(WebElement nwl:nwls) {
	    
	     switch(nwl.getText())
	     {
	     case "N":
	    	 n=n+1;
	    	 break;
	     case "W":
	    	 w=w+1;
	    	 break;
	     case "L":
	    	 l=l+1;
	    	 break;
	    default:
	    	System.out.println("NWL is not available");
	     }	
	     System.out.print(nwl.getText());
	}
	    System.out.print("N="+n+", "+"W="+w+", "+"L=");
	    System.out.println();
	}

	
	}
}
