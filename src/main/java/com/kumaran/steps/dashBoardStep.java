package com.kumaran.steps;

import com.kumaran.pages.dashBoardPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import om.kuman.Helper.WebBrowser;

public class dashBoardStep extends WebBrowser {

	dashBoardPage dbp = new dashBoardPage(driver);
	WebBrowser wb = new WebBrowser();

	@Given("I want to be in Home Page URL {string}")
	public void i_want_to_be_in_home_page_url(String string) {
		wb.driver.get(string);
		driver.manage().window().maximize();
	}

	@When("I want to Enter From City")
	public void i_want_to_enter_from_city() {
		dbp.ChooseFromCity();
	}

	@Then("I want to Select From City")
	public void i_want_to_select_from_city() {
		dbp.SelectFromCity();

	}

	@When("I want to Enter To City")
	public void i_want_to_enter_to_city() {
		dbp.ChosseToCity();

	}

	@Then("I want to Select To City")
	public void i_want_to_select_to_city() {
		dbp.SelectToCity();

	}

	@When("I want to Click on Swap Circle")
	public void i_want_to_clicl_on_swap_circle() {
		dbp.Swap();

	}

	@Then("I want to select Date")
	public void i_want_to_select_date() {
	   dbp.ChooseDate();
	}

	@Then("I want to search Buses")
	public void i_want_to_search_buses() {
		dbp.Search();
	}

}
