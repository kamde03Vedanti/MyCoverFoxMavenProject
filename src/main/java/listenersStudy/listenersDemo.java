package listenersStudy;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class listenersDemo implements ITestListener
{

	@Override
	public void onTestSuccess(ITestResult result)
	{	
		String tcName = result.getName();
		Reporter.log("TC " +tcName+ " Completed successfully", true);
	}
	
	@Override
	public void onTestSkipped(ITestResult result)
	{
		Reporter.log("TC " +result.getName()+ " is skipped Please check Dependance method", true);
	}
	@Override
	public void onTestFailure(ITestResult result) {
		Reporter.log("TC " +result.getName()+ " is Failed please check Again", true);
	}
	@Override
	public void onTestStart(ITestResult result) 
	{
		Reporter.log("TC " +result.getName()+ " is Execution is started", true);
	}
	
	
}
