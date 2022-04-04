package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import BaseClasses.PageBaseClass;
import BaseClasses.TopMenuClass;

public class UpcomingBikesPage extends PageBaseClass {

	public TopMenuClass topMenu;
	
	public UpcomingBikesPage(WebDriver driver , ExtentTest logger){
		super(driver, logger);
		topMenu = new TopMenuClass(driver, logger);
		PageFactory.initElements(driver, topMenu);

	}
	
	
	public void selectHonda() 
	{
		try {
		reportInfo("Selecting Manufacture as Honda");
		selectDropDownValue("manufacuture_Xpath","Honda");	
		reportPass("Selected Honda");
		}
		catch(Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	
	public void clickViewMore() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			reportInfo("Scrolling to viewmore button");
			js.executeScript("window.scrollBy(0,1400)");
			reportPass("Scrolled to viewmore button");
			Thread.sleep(2000);
	//		explicitlyWait("viewMore_Xpath");
			elementMoveToClick("viewMore_Xpath");
			reportPass("Clicked viewmore button");
		}
		catch(Exception e) {
			reportFail(e.getMessage());
		}

	}
	
	public ArrayList<String[]> underFourLakhBikes() {
		
		ArrayList<String []> bikesDetails = new ArrayList<String []>();
		
		try {
			reportInfo("Fetching bikes details under 4 lakh price");
			
			List<WebElement> prices = getElements("prices_Xpath");
			List<WebElement> names = getElements("names_Xpath");
			List<WebElement> launchDates = getElements("launchDates_Xpath");
	
			for(int i=0; i<prices.size(); i++ ) {
				if(Integer.parseInt(prices.get(i).getAttribute("data-price")) < 400000) 
				{				
					String details[] = new String[3];
					details[0] = names.get(i).getAttribute("title");
					details[1] = prices.get(i).getAttribute("data-price");
					details[2] = launchDates.get(i).getText().substring(14);
					bikesDetails.add(details);				
				}
			}
			reportPass("Fetched bikes details");
		
		}
		catch(Exception e) {
			reportFail(e.getMessage());
		}
		
		return bikesDetails;
	}
	
	public void clickManufacturer()
	{
		try {
			reportInfo("Clicking Manufacture dropdown");
			elementClick("manufacuture_Xpath");
			reportPass("Clicked Manufacture dropdown");
		}
		catch(Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	public void verifyVisibilityManufacturer() {
		try {
			reportInfo("Verifying manufacture is present");
			boolean elementPresent = verifyElementIsDisplayed("manufacuture_Xpath");
			if (elementPresent == true)
				reportPass("Manufacture dropdown is present");
			else
				reportFail("Manufacture dropdown is not present");
		}
		catch(Exception e) {
			reportFail(e.getMessage());
		}

	}
	

	public void verifyVisibilityHonda() {
		try {
			reportInfo("verifying Honda is peresent in manufacture");
			boolean elementPresent = verifyElementIsDisplayed("honda_Xpath");
			if (elementPresent == true)
				reportPass("Honda is present");
			else
				reportFail("Honda is not present");
		}
		catch(Exception e) {
			reportFail(e.getMessage());
		}

	}
	
	public void verifyHondaBikesDisplayed() {
		try {
			reportInfo("Verifying Honda bikes are displayed");
			boolean elementPresent = verifyElementIsDisplayed("checkHondaBikes_Xpath");
			if (elementPresent == true)
				reportPass("Honda bikes are dispayed");
			else
				reportFail("Honda bikes are not displayed");
		}
		
		catch(Exception e) {
			reportFail(e.getMessage());
		}

	}
	
	
	public void verifyVisibleName()
	{
		try {
			reportInfo("Verifying bikes name is visible");
			List<WebElement> names = getElements("names_Xpath");
			if(names.size() > 0)
				reportPass("Bikes name is visible");
			else
			reportFail("Bikes name is not visible");
		}

		catch(Exception e)
		{
			reportFail(e.getMessage());
		}
	}
	
	public void verifyVisiblePrice()
	{
		try
		{
			reportInfo("verifying bikes price is visible");
			List<WebElement> prices = getElements("prices_Xpath");
			if(prices.size() > 0)
				reportPass("Bikes price is visible");
			else
				reportFail("Bikes price is not visible");
		}
		catch(Exception e)
		{
			reportFail(e.getMessage());
		}
	}
	
	public void verifyVisibleLaunchDate()
	{
		try
		{
			reportInfo("Bikes launch date is visible");
			List<WebElement> launchDates = getElements("launchDates_Xpath");
			if(launchDates.size()>0)
				reportPass("Bikes lauch date is visible");
			else
				reportFail("Bikes launch date is not visible");
		}
		catch(Exception e)
		{
			reportFail(e.getMessage());
		}
	}
 

	public void clickAlterMeWhenLaunched()
	{
		try {
			reportInfo("Clicking AlertMe button ");
			((JavascriptExecutor) driver).executeScript("arguments[0].click()", getElement("alertMe_Xpath"));
			reportPass("Clicked AlertMe button");
			
			reportInfo("Verifying AlertMe popup");
			if(verifyElementIsDisplayed("checkAlertMe_Id"))
				reportPass("Alert Me button is clicked");
			else
				reportFail("Alert Me button is not clicked");
		}

		catch(Exception e)
		{
			reportFail(e.getMessage());
		}
	}
	
	public TopMenuClass getTopMenu() {
		return topMenu;
	}
	
	
}
