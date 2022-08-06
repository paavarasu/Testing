package hms.commonutility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import hms.testbase.Testbase;

public class utility extends Testbase {
	
	//mouse click
	public static void clickonelement(WebElement el)
	{
		Actions act=new Actions(driver);
		act.click(el).build().perform();
	}

	//file upload
	public static void uploadfile(String loc)
	{
		StringSelection sel=new StringSelection(loc);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel, null);
		
		try {
			Thread.sleep(2000);
			Robot rb=new Robot();
			
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
			
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_V);
			
			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_V);
			
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
			
			
			
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	//Takescreenshot
	
	public static void screenshot()
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File desig=new File(System.getProperty("user.dir")+"/Screenshot/"+System.currentTimeMillis()+".png");
		try {
			org.openqa.selenium.io.FileHandler.copy(src, desig);
		} catch (IOException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
	}
	
}
