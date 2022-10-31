package com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.commons.CommonActions;

public class ResultsPage extends CommonActions{
	
	private WebDriverWait wait = setWait(10);
	
	@FindBy(xpath = "//*[contains(text(),'Samsung')]")
	private List<WebElement> samsungItem;
	@FindBy(xpath = "//*[contains(text(),'Mabe')]")
	private List<WebElement> mabeItem;
	@FindBy(xpath = "//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[2]")
	private WebElement firstProd;
	
	
	public ResultsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickSamsungItem(int index) {
		wait.until(ExpectedConditions.visibilityOfAllElements(samsungItem));
		samsungItem.get(index - 1).click();
	}
	public void clickMabeItem(int index) {
		wait.until(ExpectedConditions.visibilityOfAllElements(mabeItem));
		mabeItem.get(index - 1).click();
	}
	
	public void clickFirstProd() {
		wait.until(ExpectedConditions.visibilityOfAllElements(firstProd));
		firstProd.click();
	}

}
