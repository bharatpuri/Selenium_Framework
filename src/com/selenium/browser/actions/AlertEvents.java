package com.selenium.browser.actions;

public interface AlertEvents {
	
	public abstract String getAlertText();
	public abstract void handleAlert(String action); 

}