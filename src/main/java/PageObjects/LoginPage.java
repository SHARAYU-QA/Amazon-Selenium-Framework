package PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {


	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}


	@FindBy(xpath="//div[@id='auth-error-message-box']//div[contains(@class,'a-alert-content')]")
	WebElement invalidPasswordErrorMessage;
	
	
	@FindBy(xpath="//div[@id='invalid-email-alert']")
	WebElement invalidEmailAddressErrorMessage;
	
	
	
	public String getInvalidPasswordErrorMessage() {
		
		System.out.println(invalidPasswordErrorMessage.getText());
		return invalidPasswordErrorMessage.getText();
	}
	
	
public String getInvalidEmailAddressErrorMessage() {
		
		System.out.println(invalidEmailAddressErrorMessage.getText());
		return invalidEmailAddressErrorMessage.getText();
	}
}
