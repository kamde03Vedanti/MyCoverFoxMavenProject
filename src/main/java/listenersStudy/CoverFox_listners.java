package listenersStudy;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import CoverFox_BaseClass.BaseClass;
import CoverFox_Utility.Utility;

public class CoverFox_listners extends BaseClass implements ITestListener
{
	
	@Override
	public void onTestFailure(ITestResult result) 
	{
	try {
		Utility.takeScreenShot(driver, result.getName());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		
	}
	@Override
	public void onTestSuccess(ITestResult result) {
	
	}

}
