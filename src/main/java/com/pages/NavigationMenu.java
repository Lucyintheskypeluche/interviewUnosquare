package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.commons.CommonActions;

public class NavigationMenu extends CommonActions{
	
	WebDriverWait wait = setWait(10);
	
	@FindBy(id = "twotabsearchtextbox")
	private WebElement searchBar;
	@FindBy(id="nav-search-submit-button")
	private WebElement searchBtn;
	@FindBy(id="nav-cart-count-container")
	private WebElement cartBtn;
	
	public NavigationMenu(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void searchProduct(String product) {
		wait.until(ExpectedConditions.elementToBeClickable(searchBar));
		searchBar.click();
		searchBar.sendKeys(product);
		searchBtn.click();
	}
	
	public void goToCart() {
		wait.until(ExpectedConditions.elementToBeClickable(cartBtn));
		cartBtn.click();
	}

}
