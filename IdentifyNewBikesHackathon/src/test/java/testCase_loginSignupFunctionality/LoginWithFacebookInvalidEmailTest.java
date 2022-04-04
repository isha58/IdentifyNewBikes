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

public class LoginWithFacebookInvalidEmailTest extends BaseTestClass {
	
	LandingPage landingPage;
	LoginWithFacebookPage facebookLoginPage;
	LoginWithGooglePage googleLoginPage;
	UpcomingBikesPage upcomingBikesPage;
	UsedCarsPage usedCarsPage;
	TopMenuClass topMenu;
	
	@Test(dataProvider="getFacebookInvalidEmailLoginTestData")
	public void FacebookInvalidEmailLoginTest(Hashtable<String, String> testData) {
		
		logger = report.createTest("Facebook Login Test with Invalid Email Id");

		landingPage = openApplication();
		landingPage.clickLoginSignupButton();
		facebookLoginPage = landingPage.clickContinueWithFacebook();
		facebookLoginPage.enterEmail(testData.get("Email"));
		facebookLoginPage.enterPassword(testData.get("Password"));
		facebookLoginPage.clickLoginButton();
		facebookLoginPage.incorrectEmailMsg();
		
	}
	
	
	@DataProvider
	public Object[][] getFacebookInvalidEmailLoginTestData(){
		return TestDataProvider.getTestData("LoginTestData.xlsx", "LoginTest", "FacebookInvalidEmailLogin");
	}
}
