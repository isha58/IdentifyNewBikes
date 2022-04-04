package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import BaseClasses.PageBaseClass;
import BaseClasses.TopMenuClass;

public class LandingPage extends PageBaseClass {

	public TopMenuClass topMenu;
	
	public LandingPage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
		topMenu = new TopMenuClass(driver, logger);
		PageFactory.initElements(driver, topMenu);
	}
	
	public void verifyVisibilityLoginSignUp()
	{
		try
		{
			reportInfo("Verifying Login/signup button is present");
			boolean elementPresent = verifyElementIsDisplayed("loginSignup_Id");
			if(elementPresent==true)
				reportPass("Login/SignUp button is present");
			else
				reportFail("Login/SignUp button is not present");
		}
		catch(Exception e)
		{
			reportFail(e.getMessage());
		}
	}
	public void verifyContinueGoogleIsClickable()
	{
		
		try{
			reportInfo("Verifying continue with Google button is clickable");
			explicitlyWait("verifyLoginGoogle_Xpath");
			if(verifyElementIsDisplayed("verifyLoginGoogle_Xpath"))
				reportPass("Continue with Google button is clicked");
			else
				reportFail("Continue with Google is not clicked");
		}
		catch(Exception e)
		{
			reportFail(e.getMessage());
		}
	}
	
	public void verifyLoginSignupIsClickable()
	{
		try
		{
			reportInfo("Verifying Login/Signup button is clickable");
			explicitlyWait("loginSignupPopup_Xpath");
			if(verifyElementIsDisplayed("loginSignupPopup_Xpath"))
				reportPass("Login/Signup button is clicked");
			else
				reportFail("Login/Signup button is not clicked");
		}
		catch(Exception e)
		{
			reportFail(e.getMessage());
		}
	}
	


//	public LoginWithGooglePage clickLoginSignupButton() {
//		logger.log(Status.INFO,"Clicking the Login Button, Present is header");
//		elementClick("loginSignup_Id");
//		logger.log(Status.INFO,"Clicked the Login Button");
//		
//		LoginWithGooglePage loginWithGooglePage = new LoginWithGooglePage(driver, logger);
//		PageFactory.initElements(driver, loginWithGooglePage);
//		return loginWithGooglePage;
//	}
	public void clickLoginSignupButton() {
		try {
			reportInfo("Clicking the Login/Signup button");
			elementClick("loginSignup_Id");
			reportPass("Clicked the Login/Signup button");
		}
		catch(Exception e) {
			reportFail(e.getMessage());
		}
		
	}
	

	public TopMenuClass getTopMenu() {
		
		return topMenu;
	}
	
	public void clickLoginClose() {
		try {
			reportInfo("Closing Login popup");
			explicitlyWait("loginClose_Id");
			elementClick("loginClose_Id");
			reportPass("Closed Login popup");
		}
		catch(Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	public LoginWithFacebookPage clickContinueWithFacebook() {
		try {
			waitLoad(2);
	//		explicitlyWait("continueFacebook_Xpath");
			reportInfo("Clicking continue with facebook button");
			elementClick("continueFacebook_Xpath");
			reportPass("Clicked continue with facebook button");
			
			reportInfo("Switching window to facebook login page");
			switchWindow();
			reportPass("switched window to facebook login page");
		}
		catch(Exception e) {
			reportFail(e.getMessage());
		}
		
		LoginWithFacebookPage loginWithFacebookPage = new LoginWithFacebookPage(driver, logger);
		PageFactory.initElements(driver, loginWithFacebookPage);
		return loginWithFacebookPage;
	}
	
	public LoginWithGooglePage clickContinueWithGoogle() {
		try {
			waitLoad(2);
	//		explicitlyWait("continueGoogle_Id");
			reportInfo("Clicking contiue with google button");
			elementClick("continueGoogle_Id");
			reportPass("clicked continue with google button");
			reportInfo("Switching window to google login page");
			switchWindow();
			reportPass("switched window to google login page");
		}
		catch(Exception e) {
			reportFail(e.getMessage());
		}
		
		LoginWithGooglePage loginWithGooglePage = new LoginWithGooglePage(driver, logger);
		PageFactory.initElements(driver, loginWithGooglePage);
		return loginWithGooglePage;
	}
	
		
}
