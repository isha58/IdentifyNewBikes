package testCase_loginSignupFunctionality;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseClasses.BaseTestClass;
import BaseClasses.TopMenuClass;
import Pages.LandingPage;
import Pages.LoginWithFacebookPage;
import Pages.LoginWithGooglePage;
import Pages.UpcomingBikesPage;
import Pages.UsedCarsPage;
import Utilities.TestDataProvider;

public class LoginWithGoogleInvalidPasswordTest extends BaseTestClass {
	
	LandingPage landingPage;
	LoginWithFacebookPage facebookLoginPage;
	LoginWithGooglePage googleLoginPage;
	UpcomingBikesPage upcomingBikesPage;
	UsedCarsPage usedCarsPage;
	TopMenuClass topMenu;
	
	@Test(dataProvider="getGoogleInvalidPasswordLoginTestData")
	public void GoogleInvalidPasswordTest(Hashtable<String, String> testData) {
		logger = report.createTest("Google Login Test With Invalid Password");

		landingPage = openApplication();
		landingPage.clickLoginSignupButton();
		googleLoginPage = landingPage.clickContinueWithGoogle();
		googleLoginPage.enterEmail(testData.get("Email"));
		googleLoginPage.clickEmailNextButton();
		googleLoginPage.enterPassword(testData.get("Password"));
		googleLoginPage.clickPasswordNextButton();
		googleLoginPage.incorrectPasswordMsg();

	}
	
	@DataProvider
	public Object[][] getGoogleInvalidPasswordLoginTestData(){
		return TestDataProvider.getTestData("LoginTestData.xlsx", "LoginTest", "GoogleInvalidPasswordLogin");
	}
	
}
