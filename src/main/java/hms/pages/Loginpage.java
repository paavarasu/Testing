package hms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hms.testbase.Testbase;

public class Loginpage extends Testbase {
	
	@FindBy(tagName="img")WebElement logo;
	@FindBy(css="h3.font-white")WebElement logintxt;
	@FindBy(css="input#email")WebElement usertxt;
	@FindBy(css="input#password")WebElement passtxt;
	@FindBy(css="button.btn")WebElement signin;
	@FindBy(css="img.topuser-image")WebElement profile;
	@FindBy(xpath="//h5[text()='Super Admin']")WebElement profiletxt;
	@FindBy(css="div.sspass>a:nth-child(3)")WebElement logout;
	
	
	public Loginpage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getpagetitle()
	{
		return driver.getTitle();
		
	}
	
	public boolean islogodisplayed()
	{
		return logo.isDisplayed();
		
	}
	
	public String getlogintitle()
	{
		return logintxt.getText();
		
	}
	
	public Frontofficepage adminlogin(String user,String pass)
	{
		usertxt.sendKeys(user);
		passtxt.sendKeys(pass);
		signin.click();
		return new Frontofficepage();
	}
	
	public String getprofiletxt()
	{
		profile.click();
		return profiletxt.getText();
		
	}
	
	public void clickonlogout()
	{
		logout.click();
	}
	
}
