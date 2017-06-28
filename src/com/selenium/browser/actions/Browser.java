package com.selenium.browser.actions;

import com.autoiq.common.utility.HandleException;

public interface Browser {
	public void openBrowser() throws HandleException;
	public void closeBrowser() throws HandleException;
	public void quiteBrowser() throws HandleException; 
}