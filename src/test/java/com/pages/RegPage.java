package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class RegPage extends BaseClass {

	public RegPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "")
	private WebElement userName;

	public WebElement getUserName() {
		return userName;
	}

	public void setUserName(WebElement userName) {
		this.userName = userName;
	}

}
