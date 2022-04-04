package testCase_NewBikesFunctionality;

import java.util.ArrayList;

import org.testng.annotations.Test;

import BaseClasses.BaseTestClass;
import BaseClasses.TopMenuClass;
import Pages.LandingPage;
import Pages.LoginWithFacebookPage;
import Pages.LoginWithGooglePage;
import Pages.UpcomingBikesPage;
import Pages.UsedCarsPage;
import Utilities.WriteExcelFile;

public class upcomingBikesUnder4LakhTest extends BaseTestClass {
	
	LandingPage landingPage;
	LoginWithFacebookPage facebookLoginPage;
	LoginWithGooglePage googleLoginPage;
	UpcomingBikesPage upcomingBikesPage;
	UsedCarsPage usedCarsPage;
	TopMenuClass topMenu;
	
	@Test
	public void upcomingBikesTest() {
		logger = report.createTest("Fetch Honda Bikes Details Under four Lakh");

		landingPage = openApplication();
		landingPage.clickLoginClose();
		topMenu = landingPage.getTopMenu();
		upcomingBikesPage = topMenu.clickNewBikes();
		upcomingBikesPage.selectHonda();
		upcomingBikesPage.clickViewMore();
		ArrayList<String[]> bikesDetails= upcomingBikesPage.underFourLakhBikes();
		WriteExcelFile.writeBikesDetails(bikesDetails);
	}
}
