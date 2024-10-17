package org.homeWork1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomeWork2{
	
	WebDriver driver;
	@Test
	@Parameters({"firebrowser","site"})
	private void Launch(String browser,String url) {
		if(browser.equals("chrome"))
		{
			driver = new ChromeDriver();
			
		}
		else if(browser.equals("firefox")) {
			driver = new FirefoxDriver();
			
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		}
		
		driver.get(url);
		driver.manage().window().maximize();
			
	}
	
	
	
	
	
	

}
