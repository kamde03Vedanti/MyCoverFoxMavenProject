package CoverFox_Testclass;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import CoverFox_BaseClass.BaseClass;
import CoverFox_POMclasses.CoverFox_AddressDetailsPage;
import CoverFox_POMclasses.CoverFox_HealthPlanPage;
import CoverFox_POMclasses.CoverFox_HomePage;
import CoverFox_POMclasses.CoverFox_MemeberDetailsPage;
import CoverFox_POMclasses.CoverFox_ResultPage;
import CoverFox_Utility.Utility;

@Listeners(listenersStudy.CoverFox_listners.class)
public class CF_TC04_Validate_search_results_for_healthcare_policies extends BaseClass
{
    CoverFox_HomePage homepage;
    CoverFox_HealthPlanPage healthpage;
    CoverFox_ResultPage resultpage;
    CoverFox_AddressDetailsPage addresspage;
    CoverFox_MemeberDetailsPage memebersdetails;
   
  @BeforeClass
  public void launchingBrowser() 
  {
	  driver= new ChromeDriver();
	  homepage = new CoverFox_HomePage(driver);
	  healthpage =  new CoverFox_HealthPlanPage(driver);
	  addresspage = new CoverFox_AddressDetailsPage(driver);
	  memebersdetails = new CoverFox_MemeberDetailsPage(driver);
	  resultpage= new CoverFox_ResultPage(driver);
	  
	  Reporter.log("Opening browser", true);
	  driver.get("https://www.coverfox.com/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
	}
  
  @BeforeMethod
  public void enterMemeberDetails() throws InterruptedException, EncryptedDocumentException, IOException
  {
	  Reporter.log("clicking on Female Button", true);
	  homepage.ClickOnFemaleButton();
	  Thread.sleep(1000);
	  
	  Reporter.log("clicking on Next Button", true);
	  healthpage.ClickOnNextButton();
	  Thread.sleep(3000);
	  
	  Reporter.log("Handeling Age Drop down", true);
	  memebersdetails.selectAgeDropDown(Utility.readDataFromPropertyFile("age"));
	  Thread.sleep(3000);
	  
	  Reporter.log("clicking on Next Button after age", true);
	  memebersdetails.ClickOnNextbuttonAfterAge();
	  Thread.sleep(3000);
	  
	  Reporter.log("entering Pincode", true);
	  addresspage.enterPincode(Utility.readDataFromPropertyFile("pincode"));
	  Thread.sleep(3000);
	  
	  Reporter.log("entering Mobile No.", true);
	  addresspage.enterMobileNum(Utility.readDataFromPropertyFile("mobNum"));
	  Thread.sleep(1000);
	  
	  Reporter.log("clicking on Continue Button", true);
	  addresspage.ClickOnContinueButton();
	  Thread.sleep(1000);
	  
  }
 
  @Test
  public void validateTestPlansFromTextandBanner() throws InterruptedException
  {
	  Thread.sleep(5000);
	  Reporter.log("Fetching no. of result from text", true);
	  int textResult = resultpage.availablePlanNumberFromText();
	  Thread.sleep(7000);
	  Reporter.log("Fetching no. of result from banner", true);
	  int bannerResult = resultpage.availablePlanNumberFromBanner();
	  Thread.sleep(7000);
	 //Reporter.log("Taking Screnshot On failed TC", true);
	 // Assert.assertNotEquals(bannerResult, textResult, "Tc is Failed, Text result is not matches to banner result");
	  Assert.assertEquals(textResult, bannerResult,"Text result is not equal to banner result, TC is Failed");
	  Reporter.log("TC is Passed", true);
	}
  
  @AfterMethod
  public void closingBrowser() throws InterruptedException
  {
	  Thread.sleep(7000);
	  Reporter.log("Closing Browser", true); 
	 
	  driver.close();
  }
  
  
}
