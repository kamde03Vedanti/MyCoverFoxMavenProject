package CoverFox_Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;


public class Utility 
{
	
	
  public static String readDataFromExcel(int row, int cell) throws EncryptedDocumentException, IOException
   {
		Reporter.log("Reading data from Excel Sheet", true);
		FileInputStream myfile= new FileInputStream("D:\\Automation\\MyecxelSheet\\CoverFoxData.xlsx");
		Sheet mySheet = WorkbookFactory.create(myfile).getSheet("CFData");
		String myData = mySheet.getRow(row).getCell(cell).getStringCellValue();
		return myData;
   }
	public static void takeScreenShot(WebDriver driver, String TCID) throws IOException
	{
		Reporter.log("Taking ScreenShot", true);
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest= new File("D:\\MyScreenshot\\CoverFoxSS"+TCID+"_"+timeStamp+".png");
		Reporter.log("Saved ScreenShot at"+dest, true);
		FileHandler.copy(src, dest);
	}
	public static String readDataFromPropertyFile(String key) throws IOException
	{
	//Create object of Properties class
	Properties prop= new Properties();
	//File Location
	FileInputStream myFile= new

	FileInputStream("C:\\Users\\vedan\\.eclipse\\vedantiSelenium\\creatingPropertyFile.properties");

	//load file
	prop.load(myFile);
	//pass the Key for the data we want
	String value = prop.getProperty(key);
	return value;
	}
}