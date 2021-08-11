package com.pojo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base;

public class HomePagePojo extends Base {

	public HomePagePojo() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "email")
	private WebElement txtUserName;

	@FindBy(id = "pass")
	private WebElement txtPass;

	@FindBy(name = "login")
	private WebElement btnLogIn;

	public WebElement getTxtUserName() {
		return txtUserName;
	}

	public WebElement getTxtPass() {
		return txtPass;
	}

	public WebElement getBtnLogIn() {
		return btnLogIn;
	}

}
