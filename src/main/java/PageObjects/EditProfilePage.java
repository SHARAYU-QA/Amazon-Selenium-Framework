package PageObjects;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditProfilePage {
	
	/*
	 * WebDriver driver; WebDriverWait wait = new WebDriverWait(driver,
	 * Duration.ofSeconds(17)); Scanner sc = new Scanner(System.in);
	 * 
	 * public EditProfilePage(WebDriver driver) { this.driver = driver;
	 * PageFactory.initElements(driver, this);
	 * 
	 * }
	 */
	
	WebDriver driver;
	WebDriverWait wait;
	Scanner sc = new Scanner(System.in);

	public EditProfilePage(WebDriver driver) {
	    this.driver = driver;
	    this.wait = new WebDriverWait(driver, Duration.ofSeconds(17));

	    PageFactory.initElements(driver, this);
	}
	
	@FindBy (css =".sc-epALIP.etJkRc") 
	WebElement manageProfiles;
	
	@FindBy(xpath = "//a[normalize-space()='View']")
	WebElement viewButton;
	

	public void clickonManageProfile()
	{
		wait.until(ExpectedConditions.visibilityOf(manageProfiles));
		manageProfiles.click();
	}
	
	
	public void clickOnViewButton()
	{
		wait.until(ExpectedConditions.elementToBeClickable(viewButton));
		viewButton.click();
	}

}
