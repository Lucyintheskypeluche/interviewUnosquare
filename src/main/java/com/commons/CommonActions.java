package com.commons;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonActions {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public CommonActions(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriverWait setWait(int time) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(time));
	
		return wait;
	}
	
	public void goBack() {
		driver.navigate().back();
	}
	
	public void maxWin() {
		driver.manage().window().maximize();
	}
	
	public void closeWin() {
		driver.close();
		driver.quit();
	}
	

}
