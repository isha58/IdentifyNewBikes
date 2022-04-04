package testCase_UsedCarsFunctionality;

import org.testng.annotations.Test;

import BaseClasses.BaseTestClass;
import BaseClasses.TopMenuClass;
import Pages.LandingPage;
import Pages.LoginWithFacebookPage;
import Pages.LoginWithGooglePage;
import Pages.UpcomingBikesPage;
import Pages.UsedCarsPage;

public class usedCarsTabVisibleTest extends BaseTestClass {
	
	LandingPage landingPage;
	LoginWithFacebookPage facebookLoginPage;
	LoginWithGooglePage googleLoginPage;
	UpcomingBikesPage upcomingBikesPage;
	UsedCarsPage usedCarsPage;
	TopMenuClass topMenu;
	
	@Test
	public void usedCarsVisibleTest() 
	{
		logger = report.createTest("Used Cars Link is Present");

		landingPage = openApplication();
		landingPage.clickLoginClose();
		topMenu = landingPage.getTopMenu();
		topMenu.verifyVisibilityUsedCars();
	}
		
}
