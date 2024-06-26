package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import base.TestBase;

public class Screenshot extends TestBase{
	//date
	public static String getDate()
	{
		return new SimpleDateFormat("dd-MM-YYYY ss-mm-HH").format(new Date());
	}
	
	
	//screenshot
	public static void ss(String getnameMethod) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("F:\\Software sql\\14March_Selenium_Framework\\Screenshot1"+getnameMethod+"--"+getDate()+".jpeg");
		FileHandler.copy(src, dest);
	}
	
}
