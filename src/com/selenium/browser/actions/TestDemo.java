package com.selenium.browser.actions;

import org.testng.annotations.Test;

import com.autoiq.common.utility.HandleException;
import com.selenium.browser.actions.implementions.BrowserActions;

public class TestDemo {
	Browser browserActions = new BrowserActions();
	
  @Test
  public void f() throws HandleException {
	  browserActions.openBrowser();
	
	 
  }
}
