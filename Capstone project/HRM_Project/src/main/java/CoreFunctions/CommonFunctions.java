package CoreFunctions;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.Status;
import static CoreFunctions.ObjectLaunched.test;
import static CoreFunctions.ObjectLaunched.prop;

public class CommonFunctions {
	WebDriver driver;
	String url;

	public CommonFunctions(WebDriver driver) {
		this.driver = driver;
	}
	private String sanitizeFileName(String fileName) {
        return fileName.replaceAll("[\\\\/:*?\"<>|]", "_"); // Replaces invalid characters
    }
	
	public void screenshot(String testCaseName) throws IOException {
		try {
		Date d=new Date();
		String date=d.toString().replace(":", "-").replace(" ","_");
		 String safeTestCaseName = sanitizeFileName(testCaseName);
		String screenshotFolder=System.getProperty("user.dir")+"//Output//Screenshots//"+safeTestCaseName+"_"+date+".png";
		File dest=new File(screenshotFolder);
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, dest);
		if (test != null) {
            test.log(Status.INFO, "Screenshot->" + test.addScreenCaptureFromPath(screenshotFolder));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
	}
	
	public void type(String locator, String data, String type) {
		switch(type){
		case "xpath":
			driver.findElement(By.xpath(prop.getProperty(locator))).sendKeys(String.valueOf(data));
			log("Enter " +"'"+data+"'"+prop.getProperty(locator));
			break;
		case "id":	
			driver.findElement(By.id(prop.getProperty(locator))).sendKeys(String.valueOf(data));
			log("Enter " +"'"+data+"'"+prop.getProperty(locator));
			break;
		case "link":
			driver.findElement(By.linkText(prop.getProperty(locator))).sendKeys(String.valueOf(data));
			log("Enter " +"'"+data+"'"+prop.getProperty(locator));
			break;
		default:
				System.out.println("Select appropriate locator type");
		}		
	}
	
	public void click(String locator, String type) {
		switch(type){
		case "xpath":
			driver.findElement(By.xpath(prop.getProperty(locator))).click();
			log("Click on"+ prop.getProperty(locator));
			break;
		case "id":	
			driver.findElement(By.id(prop.getProperty(locator))).click();
			log("Click on"+ prop.getProperty(locator));
			break;
		case "link":
			driver.findElement(By.linkText(prop.getProperty(locator))).click();
			log("Click on"+ prop.getProperty(locator));
			break;
		default:
				System.out.println("Select appropriate locator type");
		}
		
	}
	
	public void log(String msg) {
		try {
			System.out.println(msg);
			screenshot(msg);
			test.log(Status.INFO, msg);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			test.log(Status.FAIL, "Please verify as"+msg+"failed");
		}
	}
	
	public void navigateURL() {
		driver.get(prop.getProperty("applicationURL"));
		log("User navigates to " + prop.getProperty("applicationURL"));
	}
	
	public String getCurrentUrl() {
		url=driver.getCurrentUrl();
		return url;
	}
	
	  public boolean isAlertPresent() 
	  { 
	      try 
	      { 
	          driver.switchTo().alert(); 
	          return true; 
	      }   // try 
	      catch (NoAlertPresentException Ex) 
	      { 
	          return false; 
	      }   // catch 
	  }

}
