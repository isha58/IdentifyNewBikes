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

public class LoginWithGoogleInvalidEmailTest extends BaseTestClass{
	
	LandingPage landingPage;
	LoginWithFacebookPage facebookLoginPage;
	LoginWithGooglePage googleLoginPage;
	UpcomingBikesPage upcomingBikesPage;
	UsedCarsPage usedCarsPage;
	TopMenuClass topMenu;
	
	@Test(dataProvider="getGoogleInvalidEmailLoginTestData")
	public void GoogleInvalidEmailLoginTest(Hashtable<String, String> testData) {
		logger = report.createTest("Google Login Test With Invalid Email Id");

		landingPage = openApplication();
		landingPage.clickLoginSignupButton();
		googleLoginPage = landingPage.clickContinueWithGoogle();
		googleLoginPage.enterEmail(testData.get("Email"));
		googleLoginPage.clickEmailNextButton();
		googleLoginPage.incorrectEmailMsg();
	}
	
	@DataProvider
	public Object[][] getGoogleInvalidEmailLoginTestData(){
		return TestDataProvider.getTestData("LoginTestData.xlsx", "LoginTest", "GoogleInvalidEmailLogin");
	}
	
}
