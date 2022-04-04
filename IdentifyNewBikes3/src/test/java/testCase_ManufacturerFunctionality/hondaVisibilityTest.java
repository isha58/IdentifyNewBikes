package testCase_ManufacturerFunctionality;

import org.testng.annotations.Test;

import BaseClasses.BaseTestClass;
import BaseClasses.TopMenuClass;
import Pages.LandingPage;
import Pages.LoginWithFacebookPage;
import Pages.LoginWithGooglePage;
import Pages.UpcomingBikesPage;
import Pages.UsedCarsPage;

public class hondaVisibilityTest extends BaseTestClass {
	
	LandingPage landingPage;
	LoginWithFacebookPage facebookLoginPage;
	LoginWithGooglePage googleLoginPage;
	UpcomingBikesPage upcomingBikesPage;
	UsedCarsPage usedCarsPage;
	TopMenuClass topMenu;

	@Test
	public void hondaVisibleTest() {
		
		logger = report.createTest("Honda Manufacture is Present");

		landingPage = openApplication();
		landingPage.clickLoginClose();
		topMenu = landingPage.getTopMenu();
		upcomingBikesPage = topMenu.clickNewBikes();
		upcomingBikesPage.verifyVisibilityHonda();

		
	}
}
