package TestCases;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.BasePage;
import PageObjects.CreateAccountPage;
import PageObjects.HomePage;

public class TC_01_create_NewUser_Registration extends BasePage {

	@Test (dataProvider = "getData")
	public void newUserLogin(HashMap<String,String> input) throws InterruptedException
	{
		
	HomePage homepage = new HomePage(driver);
	homepage.clickOnSign_in_Account_And_List(driver);
	homepage.clickOnSignIn();
	homepage.enterEmailOrMblNo(input.get("emailOrMblNo"));
	CreateAccountPage createaccountpage= new CreateAccountPage(driver);
	createaccountpage.clickOnContinueButton();
	createaccountpage.create_Account();
	
	
	}
	
	@DataProvider
	
	public Object[][] getData() throws IOException
	{
		List<HashMap<String,String>> data = getJsonDataToMAp(System.getProperty("user.dir")+"//src//test//java//testData//testData.json");
		return new Object[][] {{data.get(0)}};
		
	}
	
}
