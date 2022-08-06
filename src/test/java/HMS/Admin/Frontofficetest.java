package HMS.Admin;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import hms.pages.Frontofficepage;
import hms.pages.Loginpage;
import hms.testbase.Testbase;

public class Frontofficetest extends Testbase {
	
	Loginpage objlog;
	Frontofficepage objff;
	
	public Frontofficetest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initilization();
		objlog=new Loginpage();
		objff=objlog.adminlogin(prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
	}

	@Test
	public void frontofficetest()
	{
		objff.clickonfrontoffice();
		String Expectedtabletitle="Appointment Details";
		String Actualtabletitle=objff.gettabletitle();
		Assert.assertEquals(Actualtabletitle, Expectedtabletitle);
		objff.clickonvistorbook();
		
	}
	 
	
	
}
