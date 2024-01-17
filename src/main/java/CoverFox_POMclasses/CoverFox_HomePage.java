package CoverFox_POMclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoverFox_HomePage 
{

	@FindBy(xpath = "//div[text()='Female']") private WebElement femaleSelection;
	
	
	public CoverFox_HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void ClickOnFemaleButton()
	{
		femaleSelection.click();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
