package com.WebDriverDemos;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingTables {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://money.rediff.com/index.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement ele=driver.findElement(By.xpath("//a[text()=\"More gainers \"][@href=\"//money.rediff.com/gainers/bse/daily/groupa\"]"));
		js.executeScript("arguments[0].click()", ele);
		List<WebElement> ele1=driver.findElements(By.xpath("//div[@id=\"leftcontainer\"]//table/thead/tr/th"));
		for(WebElement e:ele1) {
			System.out.println(e.getText());
			}
		List<WebElement> ele2=driver.findElements(By.xpath("//div[@id=\"leftcontainer\"]/table/tbody/tr"));
//		for(WebElement e:ele1) {
			System.out.println(ele2.size());
//			}
			
//				System.out.println(ele2.get(2).getText());	
			Random r=new Random();
			int i=r.nextInt(ele2.size());
			System.out.println(ele2.get(i).getText());
			
			System.out.println(driver.findElement(By.xpath("//div[@id=\"leftcontainer\"]/table/tbody/tr["+(i+1)+"]")).getText());
			List<WebElement> companies=driver.findElements(By.xpath("//div[@id=\"leftcontainer\"]/table/tbody/tr/td[1]"));
			for(WebElement e1:companies) {
				System.out.print(e1.getText()+" ");
			}
			List<WebElement> price=driver.findElements(By.xpath("//div[@id=\"leftcontainer\"]/table/tbody/tr/td[4]"));
//			ArrayList<Double> prices=new ArrayList<Double>();
//			System.out.println();
//			for(WebElement e2:price) {			
//				System.out.print(e2.getText().replaceAll(",", "")+" ");	
//				String a=e2.getText().replaceAll(",", "");
//				prices.add(Double.parseDouble(a));	
//
//			}
//			Collections.sort(prices, Collections.reverseOrder());	
//			System.out.println();
//			System.out.println(prices+" ");
//			System.out.print("Highest Price: "+prices.get(0));
			Double[] prices=new Double[price.size()];
			for(int j=0; j<prices.length;j++)
			{
				prices[j]=Double.parseDouble(price.get(j).getText().replace(",",""));
			}
			Arrays.sort(prices);
			System.out.print("Highest Price: "+prices[prices.length-1]);
			
	}

}
