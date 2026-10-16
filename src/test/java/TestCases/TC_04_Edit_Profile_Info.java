package TestCases;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.BasePage;
import PageObjects.EditProfilePage;
import PageObjects.HomePage;

public class TC_04_Edit_Profile_Info extends BasePage{

	@Test (dataProvider = "getData")
	public void Edit_Profile_Info(HashMap<String,String>input) throws InterruptedException {
		// TODO Auto-generated method stub
		HomePage homepage = new HomePage(driver);
		homepage.clickOnSign_in_Account_And_List(driver);
		homepage.clickOnSignIn();
		homepage.enterEmailOrMblNo(input.get("emailOrMblNo"));
		homepage.enter_password(input.get("PassWord"));
		homepage.click_On_Sign_in();
		homepage.clickOnSign_in_Account_And_List(driver);
		EditProfilePage ep = new EditProfilePage(driver);
		//Thread.sleep(1000);
		ep.clickonManageProfile();
		//ep.clickOnViewButton();
		
		
		
	}
	
@DataProvider
	
	public Object[][] getData() throws IOException
	{
		List<HashMap<String,String>> data = getJsonDataToMAp(System.getProperty("user.dir")+"//src//test//java//testData//testData.json");
		return new Object[][] {{data.get(2)}};
		
	}

}
