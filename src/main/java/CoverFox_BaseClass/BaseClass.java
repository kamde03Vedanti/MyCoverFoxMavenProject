package CoverFox_BaseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

public class BaseClass 
{
	static protected WebDriver driver;
	public void launchBrowser() throws InterruptedException
	{
		driver= new ChromeDriver();
		Reporter.log("Launching browser ", true);
		driver.get("https://www.coverfox.com/");
		Thread.sleep(1000);
		
	}
	public void closeCoverFox() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.close();
		Reporter.log("Closing Browser", true);;
	}
	

}
