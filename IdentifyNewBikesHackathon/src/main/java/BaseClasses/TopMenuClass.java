package BaseClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import Pages.UpcomingBikesPage;
import Pages.UsedCarsPage;

public class TopMenuClass extends PageBaseClass{
	
	
	public TopMenuClass(WebDriver driver, ExtentTest logger) 
	{
		super(driver, logger);
	}
		
	public UpcomingBikesPage clickNewBikes() 
	{
		try {
			reportInfo("Clicking New bikes button");
			mouseHover("newBikes_Xpath");
			mouseHover("upcomingBikes_Xpath");
			elementClick("upcomingBikes_Xpath");
			reportPass("Clicked new bikes button");
		}
		catch(Exception e) {
			reportFail(e.getMessage());
		}
		
		UpcomingBikesPage upcomingBikesPage = new UpcomingBikesPage(driver, logger);
		PageFactory.initElements(driver, upcomingBikesPage);
		return upcomingBikesPage;
	}
	
//	@FindBy(xpath = "//a[@href='/used-car/Chennai']")
//	public WebElement chennai;
	
	public UsedCarsPage clickUsedCars() {
		try 
		{
			reportInfo("Clicking used cars button");
			mouseHover("usedCars_Xpath");
			mouseHover("chennai_Xpath");
			elementClick("chennai_Xpath");
			reportPass("Clicked used cars button");
		}
		catch(Exception e)
		{
			reportFail(e.getMessage());
		}
		
		UsedCarsPage usedCarsPage = new UsedCarsPage(driver, logger);
		PageFactory.initElements(driver, usedCarsPage);
		return usedCarsPage;
		
	}
	
	
	//verify visibility
	public void verifyVisibilityUsedCars()
	{
		try
		{
			reportInfo("Verifying used cars button is present");
			boolean elementPresent=verifyElementIsDisplayed("usedCars_Xpath");		
			if(elementPresent==true)
				reportPass("Used cars button is present");
			else
				reportFail("Used cars button is not present");
		}
		catch(Exception e)
		{
			reportFail(e.getMessage());
		}
	}

	public void verifyVisibilityNewBikes()
	{
		try
		{
			reportInfo("Verifying new bike button is present");
			boolean elementPresent=verifyElementIsDisplayed("newBikes_Xpath");
			if(elementPresent==true)
				reportPass("New bikes button is present");
			else
				reportFail("New bikes button is not present");
		}
		catch(Exception e)
		{
			reportFail(e.getMessage());
		}
	}
	
	//hover over element
	public void hoverUsedCars()
	{
		try
		{
			reportInfo("Moving cursor to used cars button");
			mouseHover("usedCars_Xpath");
			reportInfo("Moved cursor to used cars button");
			
			reportInfo("verifying chennai city button is present");
			if(verifyElementIsDisplayed("chennai_Xpath")==true)
				reportPass("Chennai city  is present");
			else
				reportFail("Chennai city is not present");
		}

		catch(Exception e)
		{
			reportFail(e.getMessage());
		}
	}
	
	public void hoverNewBikes()
	{
		try
		{
			reportInfo("Moving cursor to new bikes button");
			mouseHover("newBikes_Xpath");
			reportPass("Moved cursor to ew bike button");
			
			reportInfo("Verifying upcoming bikes button is present");
			if(verifyElementIsDisplayed("upcomingBikes_Xpath")==true)
				reportPass("Upcoming bikes button is present");
			else
				reportFail("Upcoming bike button is not present");
		}
		catch(Exception e)
		{
			reportFail(e.getMessage());
		}
	}
	
	
}
