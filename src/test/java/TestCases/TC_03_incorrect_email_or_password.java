package TestCases;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.BasePage;
import PageObjects.HomePage;
import PageObjects.LoginPage;

public class TC_03_incorrect_email_or_password extends BasePage {

	@Test (dataProvider = "getData")
	public void incorrect_email_or_password(HashMap<String,String> input) throws InterruptedException
	{
		HomePage homepage = new HomePage(driver);
		homepage.clickOnSign_in_Account_And_List(driver);
		homepage.clickOnSignIn();
		homepage.enterEmailOrMblNo(input.get("emailOrMblNo"));
		//Thread.sleep(2000);
		LoginPage loginpage = new LoginPage(driver);
		String actual = loginpage.getInvalidEmailAddressErrorMessage();
		String expected ="Invalid email address";
		Assert.assertEquals(actual, expected);
		//homepage.enter_password(input.get("PassWord"));
		//homepage.click_On_Sign_in();
		
		
		
	}
	
@DataProvider
	
	public Object[][] getData() throws IOException
	{
		List<HashMap<String,String>> data = getJsonDataToMAp(System.getProperty("user.dir")+"//src//test//java//testData//testData.json");
		return new Object[][] {{data.get(1)}};
		
	}
}
