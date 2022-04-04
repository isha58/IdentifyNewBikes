package testCase_loginSignupFunctionality;

import org.testng.annotations.Test;

import BaseClasses.BaseTestClass;
import BaseClasses.TopMenuClass;
import Pages.LandingPage;
import Pages.LoginWithFacebookPage;
import Pages.LoginWithGooglePage;
import Pages.UpcomingBikesPage;
import Pages.UsedCarsPage;

public class loginSignupGoogleClickTest extends BaseTestClass{
	
	LandingPage landingPage;
	LoginWithFacebookPage facebookLoginPage;
	LoginWithGooglePage googleLoginPage;
	UpcomingBikesPage upcomingBikesPage;
	UsedCarsPage usedCarsPage;
	TopMenuClass topMenu;
	
	@Test
	public void loginGoogleClickTest() 
	{	
		logger = report.createTest("Continue with Google Button is Clickable");

		landingPage = openApplication();
		landingPage.clickLoginClose();
		landingPage.clickLoginSignupButton();
		landingPage.clickContinueWithGoogle();
		landingPage.verifyContinueGoogleIsClickable();

	}
}
