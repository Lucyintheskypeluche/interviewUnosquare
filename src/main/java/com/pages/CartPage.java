package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.commons.CommonActions;

public class CartPage extends CommonActions{
	
	private WebDriverWait wait = setWait(10);
	
	@FindBy(xpath = "//*[@id=\"NATC_SMART_WAGON_CONF_MSG_SUCCESS\"]/span")
	private WebElement confirmationIsAdded;
	@FindBy(id = "sc-subtotal-amount-buybox")
	private WebElement totalAmount;
	
	public CartPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public String ValidateProdIsAdded() {
		wait.until(ExpectedConditions.visibilityOf(confirmationIsAdded));
		
		return confirmationIsAdded.getText();
	}
	
	public String getTotalAmmount() {
		wait.until(ExpectedConditions.visibilityOfAllElements(totalAmount));
		System.out.println(totalAmount.getText().toString().substring(2));
		return totalAmount.getText().toString().substring(2);
	}
	
	public boolean quitityBiggerThan(double expected, String stramount) {
		stramount = stramount.replace(",", "");
		System.out.println(stramount);
		double amount;
		amount = Double.parseDouble(stramount);
		if(amount > expected) {
			return true;
		}
		return false;
	}

}
