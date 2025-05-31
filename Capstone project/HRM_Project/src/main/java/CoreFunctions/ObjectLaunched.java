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
import com.Utilities.ExcelRead;
import com.Utilities.Extentreporter;

public class ObjectLaunched extends ExcelRead {
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
		file =new File(System.getProperty("user.dir") +"/Configuration/OHRMProperties.properties");
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
//		  wb.close();
//		  fis.close();
		  //fos.close();
		driver.close();
		driver.quit();
		if (report != null) {
	        report.flush();
	    }

	    // Close workbook (if it's part of the test execution)
	    if (wb != null) {
	        wb.close();
	    }

	    // Close the file input stream if it's open
	    if (fis != null) {
	        fis.close();
	    }
	}
	

}
