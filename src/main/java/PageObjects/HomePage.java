package PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@id='nav-link-accountList']")
	WebElement accountAndListIn;

	@FindBy(xpath = "//span[@class='nav-action-inner']")
	WebElement sign_in;

	@FindBy(id = "ap_email_login")
	WebElement entermblNoOrEmail;	
	
	@FindBy(id="ap_password")
	WebElement password;
	
	@FindBy(xpath="//input[@class='a-button-input']")
	WebElement click_On_Continue;
	
	@FindBy(id="signInSubmit")
	WebElement click_On_Sign_In;
	
	public void clickOnSign_in_Account_And_List(WebDriver driver) throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOf(accountAndListIn));
		Actions action = new Actions(driver);
		action.moveToElement(accountAndListIn).perform();
	}

	public void clickOnSignIn() {
		wait.until(ExpectedConditions.elementToBeClickable(sign_in));
		sign_in.click();
	}

	public void enterEmailOrMblNo(String emailOrMblNo) {
		wait.until(ExpectedConditions.visibilityOf(entermblNoOrEmail));
		//String emailID = "ingolesharayu3@gmail.com";

		entermblNoOrEmail.sendKeys(emailOrMblNo);

		System.out.println("Email Id entered: " + emailOrMblNo);
		click_On_Continue.click();
	}

	public void enter_password(String PassWord)
	{
		wait.until(ExpectedConditions.visibilityOf(password));
		password.sendKeys(PassWord);
	}

	public void click_On_Sign_in()
	{
		click_On_Sign_In.click();
	}
	
}

