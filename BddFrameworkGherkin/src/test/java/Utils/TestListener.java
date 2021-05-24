package Utils;




import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;

import stepDefininitions.LoginSteps;

public class TestListener extends ExtentReportListener implements ITestListener{
	private static Logger logger = LogManager.getLogger(LoginSteps.class);
	private static ExtentReports extent;

	public void onTestStart(ITestResult result)
	{
		
	}
	public void onTestSuccess(ITestResult result)
	{
		logger.info("Test Passed");
		System.out.println("PASS");
	}
	public void onTestFailure(ITestResult result)
	{	logger.info("Test Failed");
		System.out.println("FAIL");
		logger.error("Something went wrong");
	}
	public void onTestSkipped(ITestResult result)
	{
		logger.info("Test Skipped");
		
		System.out.println("SKIP");
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		
	}
	
	public void onStart(ITestContext context)
	{
		logger.info("Test Started");
		System.out.println("Execution started");
		extent=setUp();
		
	}
	public void onFinish(ITestContext context)
	{
		logger.info("Test Finished");
		System.out.println("Execution Finished");
		extent.flush();
		System.out.println("Report is generated");
		
	}
}
	
