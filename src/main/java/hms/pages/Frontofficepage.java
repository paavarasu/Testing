package hms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hms.testbase.Testbase;

public class Frontofficepage extends Testbase {
	
	@FindBy(css="ul.sidebar-menu>li")WebElement ffmenu;
	@FindBy(css="h3.box-title")WebElement tablename;
	@FindBy(css="div.box-tools>a:nth-child(2)")WebElement vistorbook;
	
	public Frontofficepage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickonfrontoffice()
	{
		ffmenu.click();
	}
	
	public String gettabletitle()
	{
		return tablename.getText();
	}
	
	public Vistorpage clickonvistorbook()
	{
		vistorbook.click();
		return new Vistorpage();
		
	}

}
