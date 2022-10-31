package com.commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSetup {
	
	private WebDriver driver;
	
	public WebDriver driverSet(String url) {
		driver = new ChromeDriver();
		driver.get(url);
		
		return driver;
	}
	
	
	
	

}
