package configurations;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Reporting extends BaseClassForSwag implements ITestListener{

	ExtentTest test ;
	ExtentReports extent = ExtentReportsNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest> ();//there is concerncy isue here that multipleTimes multiple test s 
	// trying to access singlevariable keeping overriden relts are going to task
	@Override
	public void onTestStart(ITestResult result) {
	 test = extent.createTest(result.getMethod().getMethodName());
	extentTest.set(test);//uniqe thread id 
	 
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS,"Test Pass");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.get().fail(result.getThrowable());
		
		try {
			driver=(WebDriver) result.getTestClass().getRealClass().getField("driver")
					.get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String filePath =null;
		
		try {
			filePath=getScreenshot(result.getMethod().getMethodName(), driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception is "+e.getMessage());
		}
		extentTest.get().addScreenCaptureFromPath(filePath,result.getMethod().getMethodName());
		
	}

	

	

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

	
	
}
