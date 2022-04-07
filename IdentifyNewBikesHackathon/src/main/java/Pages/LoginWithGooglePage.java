package Pages;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import BaseClasses.PageBaseClass;

public class LoginWithGooglePage extends PageBaseClass {
	
	public LoginWithGooglePage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}
	
	//entering Email
	public void enterEmail(String email) {
		try {
			reportInfo("Entering google email id ");
			elementSendKeys("GoogleEmailField_Xpath", email);
			reportPass("Entered google email id");
		}
		catch(Exception e) {
			reportFail(e.getMessage());
		}
		
	}
	//click on Email Next Button
	public void clickEmailNextButton() {
		try {
			reportInfo("Clicking next button");
			elementClick("GoogleEmailNextButton_Xpath");
			reportPass("Clicked next button");
		}
		catch(Exception e) {
			reportFail(e.getMessage());
		}
	}
	// entering Password
	public void enterPassword(String password) {
		try {
			reportInfo("Entering google password");
			explicitlyWait("GooglePasswordField_Xpath");
			elementSendKeys("GooglePasswordField_Xpath",password);
			reportPass("Entered google password");
		}
		catch(Exception e) {
			reportFail(e.getMessage());
		}
	}
	//click on Password Next Button
	public void clickPasswordNextButton() {
		try {
			reportInfo("Clicking next button");
			explicitlyWait("GooglPasswordNextButton_Xpath");
			elementClick("GooglPasswordNextButton_Xpath");
			reportPass("Clicked next button");
		}
		catch(Exception e) {
			reportFail(e.getMessage());
		}
		
	}
	//capturing incorrect Password Msg
	public void incorrectPasswordMsg() {
		try {
			reportInfo("Capturing invalid password message");
			explicitlyWait("GoogleIncorrectPasswordMsg_Xpath");
			String errorMsg = elementGetText("GoogleIncorrectPasswordMsg_Xpath");
			takeScreenShotOn();
			writeError(errorMsg,"googleInvalidPasswordErrorMsg");
			reportPass("Captured invalid password message");
			System.out.println(errorMsg);
		}
		catch(Exception e) {
			reportFail(e.getMessage());
		}
	}
	//capturing incorrect Email Msg
	public void incorrectEmailMsg() {
		try {
			reportInfo("Capturing invalid email message");
			explicitlyWait("GoogleIncorrectEmailMsg_Xpath");
			String errorMsg = elementGetText("GoogleIncorrectEmailMsg_Xpath");
			takeScreenShotOn();
			writeError(errorMsg,"googleInvalidEmailErrorMsg");
			reportPass("Captured invalid email message");
			System.out.println(errorMsg);
		}
		catch(Exception e) {
			reportFail(e.getMessage());
		}
	}
	

	
}
