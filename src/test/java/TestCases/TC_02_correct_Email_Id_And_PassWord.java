package TestCases;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.BasePage;
import PageObjects.CreateAccountPage;
import PageObjects.HomePage;

public class TC_02_correct_Email_Id_And_PassWord extends BasePage{
	
	@Test (dataProvider = "getData")
	public void Login(HashMap<String,String> input) throws InterruptedException
	{
		HomePage homepage = new HomePage(driver);
		homepage.clickOnSign_in_Account_And_List(driver);
		homepage.clickOnSignIn();
		//Thread.sleep(1000);
		homepage.enterEmailOrMblNo(input.get("emailOrMblNo"));
		homepage.enter_password(input.get("PassWord"));
		homepage.click_On_Sign_in();
		
	}
	
@DataProvider
	
	public Object[][] getData() throws IOException
	{
		List<HashMap<String,String>> data = getJsonDataToMAp(System.getProperty("user.dir")+"//src//test//java//testData//testData.json");
		return new Object[][] {{data.get(0)}};
		
	}
}
