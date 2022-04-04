package testCase_UsedCarsFunctionality;

import org.testng.annotations.Test;

import BaseClasses.BaseTestClass;
import BaseClasses.TopMenuClass;
import Pages.LandingPage;
import Pages.LoginWithFacebookPage;
import Pages.LoginWithGooglePage;
import Pages.UpcomingBikesPage;
import Pages.UsedCarsPage;

public class usedCarsChennaiVisibilityTest extends BaseTestClass{
	
	LandingPage landingPage;
	LoginWithFacebookPage facebookLoginPage;
	LoginWithGooglePage googleLoginPage;
	UpcomingBikesPage upcomingBikesPage;
	UsedCarsPage usedCarsPage;
	TopMenuClass topMenu;
	
	@Test
	public void usedCarsChennaiVisibleTest() 
	{
		logger = report.createTest("Chennai Option is available");

		landingPage = openApplication();
		landingPage.clickLoginClose();
		topMenu = landingPage.getTopMenu();
		topMenu.hoverUsedCars();
	
	}
}
