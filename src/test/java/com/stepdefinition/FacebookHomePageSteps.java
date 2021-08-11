package com.stepdefinition;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.base.Base;
import com.pojo.HomePagePojo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class FacebookHomePageSteps extends Base {

	@Given("User launch the facebook url")
	public void user_launch_the_facebook_url() {
		getDriver();
		getUrl("https://www.facebook.com/");
	}

	@When("User enters the username and password in FaceBook page")
	public void user_enters_the_username_and_password_in_FaceBook_page(DataTable dataTable) {
		Map<String, String> asMap = dataTable.asMap(String.class, String.class);
		HomePagePojo h = new HomePagePojo();
		insertType(h.getTxtUserName(), asMap.get("Name"));
		insertType(h.getTxtPass(), asMap.get("Email"));
	}

	@When("User clicks the login button")
	public void user_clicks_the_login_button() {
		HomePagePojo h = new HomePagePojo();
		click(h.getBtnLogIn());
	}

	@Then("User validates the login failure page")
	public void user_validates_the_login_failure_page() throws InterruptedException {
		pause(3000);
		Assert.assertTrue("Not navigated to failure page", getCurrentUrl().contains("login"));
		closeBrowser();
	}

	@When("^User enters the \"([^\"]*)\" and \"([^\"]*)\" in FaceBook page$")
	public void user_enters_the_something_and_something_in_facebook_page(String username, String password)
			throws Throwable {
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(password);
	}

}
