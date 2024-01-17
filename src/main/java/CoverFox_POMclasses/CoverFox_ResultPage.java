package CoverFox_POMclasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoverFox_ResultPage {
	
	@FindBy(xpath = "//div[contains(text(),'matching Health')]") private WebElement textOfResultPage;
	
	@FindBy(id = "plans-list") private List<WebElement> planlist;
	
	public CoverFox_ResultPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public int availablePlanNumberFromText()
	{
		String stringText = textOfResultPage.getText();
		
		String ar[]=stringText.split(" "); // using split we are splitting ar=["49","matching","Health"...]
		
		String numberOfResultInString = ar[0];
		//convert String to Integer
		int numberOfResultInInt = Integer.parseInt(numberOfResultInString);
		return numberOfResultInInt;
		
	}
		
		public int availablePlanNumberFromBanner()
		{
			int totalNumOfPlansList=planlist.size();
			System.out.println(totalNumOfPlansList);
			return totalNumOfPlansList;
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	


