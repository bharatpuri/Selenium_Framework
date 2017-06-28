package com.selenium.browser.actions;

import org.openqa.selenium.WebElement;

public interface ElementEvents {
	
	public abstract WebElement getElement(String element);
	public abstract void clickElement(String element);
	public abstract void sendKeyToElement(String text, String element);
	public abstract String getElementText(String element);
	public abstract void clearText(String element);
	public abstract boolean isElementDispayed(String element);
	public abstract boolean isElementSelected(String element);
	public abstract boolean isElementEnabled(String element);
}
