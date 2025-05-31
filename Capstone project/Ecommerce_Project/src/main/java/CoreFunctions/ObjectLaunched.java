package CoreFunctions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.utilities.Extentreporter;

public class ObjectLaunched {
	public  WebDriver driver=null;
	public static File file;
	public static FileInputStream fis;
	public static Properties prop;
	public static ExtentTest test;
	public static ExtentReports report;
	
	public void setFramework() throws IOException {
		LaunchBrowser();
		init();
		//initWorkbook();
	}
	
	public void init() throws IOException {
		try {
			file =new File(System.getProperty("user.dir") +"/Configuration/Ecommerce.properties");
		    fis=new FileInputStream(file);
		    prop=new Properties();
		    prop.load(fis);
	    report=Extentreporter.getReport();
	    test= report.createTest("Login test");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void LaunchBrowser(){
		ChromeOptions option=new ChromeOptions();
//		option.addArguments("--disable-notifications");
//		option.addArguments("--disable-infobars");
		option.addArguments("guest");
		driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void StopSelenium() throws IOException {
		driver.close();
		driver.quit();
		if (report != null) {
	        report.flush();
	    }
	}
	

}
