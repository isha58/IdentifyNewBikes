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

public class UsedCarsPage extends PageBaseClass{
	

	public TopMenuClass topMenu;
	
	
	public UsedCarsPage(WebDriver driver, ExtentTest logger) 
	{
		super(driver, logger);
		topMenu = new TopMenuClass(driver, logger);
		PageFactory.initElements(driver, topMenu);
	}
	
	//getting popular models name
	public ArrayList<String> getPopularModels() {
		ArrayList<String> models = new ArrayList<String>();
		
		try {
			reportInfo("Fetching used cars popular models");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,600)");
			waitLoad(2);
			takeScreenShotOn();
			List<WebElement> popularModels = getElements("popularModels_Xpath");
			
			for(WebElement model : popularModels) {
				models.add(model.getText());
			}
			reportPass("Fetched used cars popular models");
		}
		catch(Exception e) {
			reportFail(e.getMessage());
		}
		
		return models;
	}
	
	//click On View Seller Detail button
	public void clickOnViewSellerDetail()
	{
		try {
			reportInfo("Clicking view seller details button");
			((JavascriptExecutor) driver).executeScript("arguments[0].click()", getElement("viewSellerDetail_Xpath"));
			reportPass("Clicked view seller details button");
			
			reportInfo("Verfying view seller button is clickable");
			explicitlyWait("sellerBox_Xpath");
			if(verifyElementIsDisplayed("sellerBox_Xpath")==true)
				reportPass("View seller details button is clickable");
			else
				reportFail("View seller details is not clickable");
		}
		catch(Exception e) {
			reportFail(e.getMessage());
		}
		
	}
	
	public TopMenuClass getTopMenu() {
		return topMenu;
	}
	



}
