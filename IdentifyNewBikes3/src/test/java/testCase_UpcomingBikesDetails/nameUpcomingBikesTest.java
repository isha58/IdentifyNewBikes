package testCase_UpcomingBikesDetails;

import org.testng.annotations.Test;

import BaseClasses.BaseTestClass;
import BaseClasses.TopMenuClass;
import Pages.LandingPage;
import Pages.LoginWithFacebookPage;
import Pages.LoginWithGooglePage;
import Pages.UpcomingBikesPage;
import Pages.UsedCarsPage;

public class nameUpcomingBikesTest extends BaseTestClass {
	
	LandingPage landingPage;
	LoginWithFacebookPage facebookLoginPage;
	LoginWithGooglePage googleLoginPage;
	UpcomingBikesPage upcomingBikesPage;
	UsedCarsPage usedCarsPage;
	TopMenuClass topMenu;
	
	@Test
	public void nameHondaBikesVisbleTest() {
		logger = report.createTest("Upcoming Bikes Name is Present");

		landingPage = openApplication();
		landingPage.clickLoginClose();
		topMenu = landingPage.getTopMenu();
		upcomingBikesPage = topMenu.clickNewBikes();
		upcomingBikesPage.selectHonda();
		upcomingBikesPage.clickViewMore();
		upcomingBikesPage.verifyVisibleName();

	}
}
