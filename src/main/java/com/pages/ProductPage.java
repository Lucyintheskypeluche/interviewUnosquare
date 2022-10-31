package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.commons.CommonActions;

public class ProductPage extends CommonActions{
	
	private WebDriverWait wait = setWait(10);
	
	@FindBy(id = "add-to-cart-button")
	private WebElement addToCartBtn;
	@FindBy(xpath = "//*[@id=\"attachSiNoCoverage\"]/span/input")
	private WebElement noProtectionBtn;
	
	public ProductPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void addProductToCart() {
		wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
		addToCartBtn.click();
	}
	
	public void dontAddProtection() {
		wait.until(ExpectedConditions.elementToBeClickable(noProtectionBtn));
		noProtectionBtn.click();
	}

}
