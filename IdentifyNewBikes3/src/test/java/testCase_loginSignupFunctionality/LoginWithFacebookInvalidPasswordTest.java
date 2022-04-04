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

public class LoginWithFacebookInvalidPasswordTest extends BaseTestClass{
	
	LandingPage landingPage;
	LoginWithFacebookPage facebookLoginPage;
	LoginWithGooglePage googleLoginPage;
	UpcomingBikesPage upcomingBikesPage;
	UsedCarsPage usedCarsPage;
	TopMenuClass topMenu;
	
	@Test(dataProvider="getFacebookInvalidPasswordLoginTestData")
	public void FacebookInvalidPasswordLoginTest(Hashtable<String, String> testData) {
		
		logger = report.createTest("Facebook Login Test with Invalid Password");

		landingPage = openApplication();
		landingPage.clickLoginSignupButton();
		facebookLoginPage = landingPage.clickContinueWithFacebook();
		facebookLoginPage.enterEmail(testData.get("Email"));
		facebookLoginPage.enterPassword(testData.get("Password"));
		facebookLoginPage.clickLoginButton();
		facebookLoginPage.incorrectPasswordMsg();
		
	}
	
	@DataProvider
	public Object[][] getFacebookInvalidPasswordLoginTestData(){
		return TestDataProvider.getTestData("LoginTestData.xlsx", "LoginTest", "FacebookInvalidPasswordLogin");
	}
}
