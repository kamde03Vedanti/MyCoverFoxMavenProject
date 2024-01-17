package CoverFox_POMclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CoverFox_MemeberDetailsPage {

	
	@FindBy(id = "Age-You")private WebElement ageDropDown;
	@FindBy(className ="next-btn")private WebElement nextButtonofAge;
	
	public CoverFox_MemeberDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void selectAgeDropDown(String Age)
	{
		Select s = new Select(ageDropDown);
		s.selectByValue(Age +"y");
	}
	public void ClickOnNextbuttonAfterAge()
	{
		nextButtonofAge.click();
	}
	
}
