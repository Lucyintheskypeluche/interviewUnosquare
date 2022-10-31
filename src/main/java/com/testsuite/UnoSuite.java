package com.testsuite;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.commons.CommonActions;
import com.commons.DriverSetup;
import com.pages.CartPage;
import com.pages.NavigationMenu;
import com.pages.ProductPage;
import com.pages.ResultsPage;


public class UnoSuite {
	
	public WebDriver driver;
	public NavigationMenu navMenu;
	public DriverSetup drivSet;
	public CommonActions common;
	public ResultsPage resPage;
	public ProductPage prodPage;
	public CartPage cartPage;
	
  @BeforeMethod
  @Parameters({"url"})
  public void setDriver(String url) {
	  DriverSetup drivSet = new DriverSetup();
	  driver = drivSet.driverSet(url);
	  common = new CommonActions(driver);
	  common.maxWin();
  }
  
  @Test(priority = 3)
  public void Validate_DontAddProtection() {
	  
	  navMenu = new NavigationMenu(driver);
	  navMenu.searchProduct("refrigerador");
	  resPage = new ResultsPage(driver);
	  resPage.clickSamsungItem(1);
	  prodPage = new ProductPage(driver);
	  prodPage.addProductToCart();
	  prodPage.dontAddProtection();
	  cartPage = new CartPage(driver);
	  Assert.assertEquals(cartPage.ValidateProdIsAdded(), "Agregado al carrito");
	  common.goBack();
	  common.goBack();
	  resPage.clickMabeItem(2);
	  prodPage.addProductToCart();
	  prodPage.dontAddProtection();
  }
  
  @Test(priority = 2)
  public void Validate_islessThan() {
	  
	  navMenu = new NavigationMenu(driver);
	  navMenu.searchProduct("refrigerator");
	  resPage = new ResultsPage(driver);
	  resPage.clickFirstProd();
	  prodPage = new ProductPage(driver);
	  prodPage.addProductToCart();
	  prodPage.dontAddProtection();
	  cartPage = new CartPage(driver);
	  Assert.assertEquals(cartPage.ValidateProdIsAdded(), "Agregado al carrito");
	  navMenu.goToCart();
	  Assert.assertEquals(cartPage.quitityBiggerThan(10000.00, cartPage.getTotalAmmount()), false);  
  }
  
  @Test(priority = 1)
  public void Validate_isbiggerThan() {
	  
	  navMenu = new NavigationMenu(driver);
	  navMenu.searchProduct("refrigerador");
	  resPage = new ResultsPage(driver);
	  resPage.clickSamsungItem(1);
	  prodPage = new ProductPage(driver);
	  prodPage.addProductToCart();
	  prodPage.dontAddProtection();
	  cartPage = new CartPage(driver);
	  Assert.assertEquals(cartPage.ValidateProdIsAdded(), "Agregado al carrito");
	  navMenu.goToCart();
	  Assert.assertEquals(cartPage.quitityBiggerThan(10000.00, cartPage.getTotalAmmount()), true);
  }
  
  @AfterMethod
  public void closeDriver() {
	  common.closeWin();
  }
}
