package testCase_UsedCarsFunctionality;

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

public class usedCarsPopularModelsTest extends BaseTestClass{
	
	LandingPage landingPage;
	LoginWithFacebookPage facebookLoginPage;
	LoginWithGooglePage googleLoginPage;
	UpcomingBikesPage upcomingBikesPage;
	UsedCarsPage usedCarsPage;
	TopMenuClass topMenu;
	
	@Test
	public void usedCarsPopularModelTest() 
	{
		logger = report.createTest("Fetch Used Cars Popular Models");

		landingPage = openApplication();
		landingPage.clickLoginClose();
		topMenu = landingPage.getTopMenu();
		usedCarsPage = topMenu.clickUsedCars();
		ArrayList<String> models = usedCarsPage.getPopularModels();
		WriteExcelFile.writePopularModels(models);
	
	}
}
