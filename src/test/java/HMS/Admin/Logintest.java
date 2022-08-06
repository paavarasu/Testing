package HMS.Admin;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import hms.pages.Loginpage;
import hms.testbase.Testbase;

public class Logintest extends Testbase {
	
	Loginpage objlogo;
	
	public Logintest()
	{
		super();
	}

	@BeforeMethod
	public void setup()
	{
		initilization();
		objlogo=new Loginpage();
		
	}
	@Test
	public void adminlogintest()
	{
		String Expectedtitle="Smart Hospital : Hospital Management System";
		String actualtitle=objlogo.getpagetitle();
		Assert.assertEquals(actualtitle, Expectedtitle);
		Assert.assertTrue(objlogo.islogodisplayed());
		
		String expectedlogintitle="Admin Login";
		String actuallogintitle=objlogo.getlogintitle();
		Assert.assertEquals(actuallogintitle, expectedlogintitle);
		
		objlogo.adminlogin(prop.getProperty("USERNAME"),prop.getProperty("PASSWORD"));
		
		String expectedprofiletxt="Super Admin";
		String actualprofiletxt=objlogo.getprofiletxt();
		Assert.assertEquals(actualprofiletxt, expectedprofiletxt);
		
		objlogo.clickonlogout();
		
	}
	
	@AfterMethod
	public void teardown()
	{
		//driver.close();
	}
	
}
