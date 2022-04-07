package Pages;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import BaseClasses.PageBaseClass;

public class LoginWithFacebookPage extends PageBaseClass{
	
	
	public LoginWithFacebookPage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}
	
	//entering  email
	public void enterEmail(String email) {
		try {
			reportInfo("Entering email id");
			elementSendKeys("FacebookEmailField_Xpath", email);
			reportPass("Entered email id");
		}
		catch(Exception e) {
			reportFail(e.getMessage());
		}
	}
	//entering password
	public void enterPassword(String password) {
		try {
			reportInfo("Entering password");
			elementSendKeys("FacebookPasswordField_Xpath", password);
			reportPass("Entered Password");
		}
		catch(Exception e) {
			reportFail(e.getMessage());
		}
	}
	//click on login button
	public void clickLoginButton() {
		try {
			reportInfo("Clicking Login button");
			elementClick("FacebookLoginButton_Xpath");
			reportPass("Clicked Login button");
		}
		catch(Exception e) {
			reportFail(e.getMessage());
		}
	}
	//capturing incorrect Email Msg
	public void incorrectEmailMsg() {
		try {
			reportInfo("Capturing invalid email error message");
			String errorMsg = elementGetText("FacebookIncorrectEmailMsg_Xpath");
			takeScreenShotOn();
			writeError(errorMsg,"facebookInvalidEmailErrorMsg");
			reportPass("Captured invalid email error message");
			System.out.println(errorMsg);
		}
		catch(Exception e) {
			reportFail(e.getMessage());
		}
	}
	//capturing incorrect Password Msg
	public void incorrectPasswordMsg() {
		try {
			reportInfo("Capturing invalid password error message");
			String errorMsg = elementGetText("FacebookIncorrectPasswordMsg_Xpath");
			takeScreenShotOn();
			writeError(errorMsg,"facebookInvalidPasswordErrorMsg");
			reportPass("Captured invalid password error message");
			System.out.println(errorMsg);
		}
		catch(Exception e) {
			reportFail(e.getMessage());
		}
	}
}
