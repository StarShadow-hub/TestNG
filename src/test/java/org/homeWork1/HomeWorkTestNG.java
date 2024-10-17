package org.homeWork1;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomeWorkTestNG {
	
	WebDriver driver;
	
	
	@BeforeClass(groups= { "smoke","sanity"})
	@Parameters({"chromebrowser","web"})
	private void browserLaunch(String browser,String url) {
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
	
	@Test(groups ="smoke")
	private void brokenLinks() throws IOException {
		List<WebElement> elements = driver.findElements(By.tagName("a"));
		int count = 0;
		for (WebElement lists : elements) {
			String links = lists.getAttribute("href");
			URL url = new URL(links);
			URLConnection openConnection = url.openConnection();
			HttpURLConnection one = (HttpURLConnection)openConnection;
			int responseCode = one.getResponseCode();
			if(responseCode<=400) {
				System.out.println("Perfect links:"+links);
				count++;	
			}
			}
		System.out.println(count);
		}

	
	
	@Test(dataProvider = "givingdatas",groups = {"sanity","smoke"})
	private void login(String username, String password) {
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(password);
		driver.findElement(By.name("login")).click();		
	}	
	
	@DataProvider(name = "givingdatas")
	private Object loginDatas() {
		Object data[][]= new Object[1][2];
		data[0][0]= "vijayakumar";
		data[0][1]= "password";
		return data;
	}
	@Test(groups = "smoke")
	private void screens() throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\Vijai\\eclipse-workspace\\TestNgProject\\Screenshots\\method1");
		FileUtils.copyFile(src, dest);
		System.out.println("smoke done");
	}
	
	
	
	@Test(groups= "sanity")
	private void sanityTest() {
		System.out.println("sanity done");
	}
	
	@Test(dependsOnMethods = "sanityTest")
	private void sanityZero() {
		System.out.println("depends on done");

	}
}
