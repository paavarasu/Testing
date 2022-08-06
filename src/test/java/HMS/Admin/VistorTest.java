package HMS.Admin;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import hms.commonutility.ReadExcel;
import hms.pages.Frontofficepage;
import hms.pages.Loginpage;
import hms.pages.Vistorpage;
import hms.testbase.Testbase;

public class VistorTest extends Testbase{
	Loginpage objlog;
	Frontofficepage objff;
	Vistorpage objvis;
	
	public VistorTest()
	{
		super();
		
	}
	
	@BeforeMethod
	public void setup()
	{
		initilization();
		objlog=new Loginpage();
		objff=objlog.adminlogin(prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
		objff.clickonfrontoffice();
		objvis=objff.clickonvistorbook();
	}
	@DataProvider
	public Object[][] visdata()
	{
		Object data[][]=ReadExcel.getTestData("Testbase");
		return data;
	}
	
	@Test(dataProvider="visdata")
	public void addvistordetails(String args[])
	{
		String actualtitle=objvis.gettabletitle();
		String expectedtitle="Visitor List";
		Assert.assertEquals(actualtitle, expectedtitle);
		
		objvis.clickonaddvistor();
		
		String actualscreentitle=objvis.getscreentitle();
		String ExpectedScrentitle="Add Visitor";
		Assert.assertEquals(actualscreentitle, ExpectedScrentitle);
		
		objvis.addvistordetails(args);
		
	}
	
}