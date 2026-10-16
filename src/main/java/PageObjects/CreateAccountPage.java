package PageObjects;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccountPage {

	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(17));
	Scanner sc = new Scanner(System.in);

	public CreateAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(id="ap_email_login")
	WebElement enter_mbl_no_email;
	
	@FindBy(id="ap_phone_number")
	WebElement enter_emailId_Or_mblNo;
	
	@FindBy(xpath="//input[@class='a-button-input']")
	WebElement click_On_Continue;
	
	@FindBy(xpath="//input[@class='a-button-input']")
	WebElement proceed_to_create_an_account;
	
	@FindBy (id="ap_customer_name")
	WebElement enter_your_name;
	
	@FindBy(id="continue")
	WebElement verify_mbl_no;
	
	@FindBy(xpath="//i[@class='a-icon a-icon-checkbox']")
	WebElement checkBox;
	
	@FindBy(xpath="(//input[@type='submit'])[1]")
	WebElement continue_with_this_no;
	
	@FindBy(xpath="(//input[@class='a-button-input'])[4]")
	WebElement send_Otp_By_SMS;
	
	@FindBy(css="input[aria-label='Verify OTP Button']")
	WebElement create_your_amazon_account;
	
	public void enter_email_id()
	{
		enter_mbl_no_email.sendKeys("ingolesharayu3@gmail.com");
	}
	
	public void clickOnContinueButton() throws InterruptedException
	{
		click_On_Continue.click();
		wait.until(ExpectedConditions.visibilityOf(proceed_to_create_an_account));
		proceed_to_create_an_account.click();
		
	}
	
	public void create_Account() throws InterruptedException
	{
		//wait.until(ExpectedConditions.visibilityOf(enter_emailId_Or_mblNo));
		Thread.sleep(1000);
		enter_emailId_Or_mblNo.click();
		Thread.sleep(1000);
		enter_emailId_Or_mblNo.sendKeys("8766795197");
		Thread.sleep(1000);
		enter_your_name.sendKeys("Sharayu");
		verify_mbl_no.click();
		Thread.sleep(5000);
		//confirm.click();
		wait.until(ExpectedConditions.visibilityOf(checkBox));
		checkBox.click();
		//wait.until(ExpectedConditions.visibilityOf(continue_with_this_no));
		continue_with_this_no.click();
		wait.until(ExpectedConditions.visibilityOf(send_Otp_By_SMS));
		send_Otp_By_SMS.click();
		System.out.println("Enter OTP:");
		String otpValue = sc.nextLine();

		send_Otp_By_SMS.sendKeys(otpValue);
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(create_your_amazon_account));
		create_your_amazon_account.click();
		
	}
}
