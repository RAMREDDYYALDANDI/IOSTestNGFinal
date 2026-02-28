package Reports;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Base.BaseTest;

public class ITestListeners extends BaseTest implements ITestListener{
	
	ExtentReports extent = ExtentreportsNG.configextentreports();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	@Override
	public void onTestStart(ITestResult result)
	{
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}
	@Override
	public void onTestSuccess(ITestResult result)
	{
		extentTest.get().log(Status.PASS, "The Test Has Passed");
	}
	@Override
	public void onTestFailure(ITestResult result)
	{
		extentTest.get().fail(result.getThrowable());
	}
	@Override
	public void onFinish(ITestContext context)
	{
		extent.flush();
	}
	@Override
	public void onTestSkipped(ITestResult result)
	{
		extentTest.get().log(Status.SKIP, "The Test Got Skipped");
	}
	
	
	

}
