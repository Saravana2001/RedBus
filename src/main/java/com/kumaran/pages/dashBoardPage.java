package com.kumaran.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class dashBoardPage {
	WebDriver driver;

	public dashBoardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//label[normalize-space()='FROM']")
	private WebElement chooseFrom;
	
	@FindBy(xpath = "//input[@id='src']")
	private WebElement selectFrom;

	@FindBy(xpath = "//label[normalize-space()='TO']")
	private WebElement chooseTo;

	@FindBy(xpath = "//input[@id='dest']")
	private WebElement selectTo;

	@FindBy(xpath = "//span[@id='togglebtn']")
	private WebElement swap;

	@FindBy(xpath = "//input[@id='onward_cal']")
	private WebElement chooseDate;

	@FindBy(css = "//button[@id='search_btn']")
	private WebElement Search;

public void ChooseFromCity() {
	chooseFrom.click();
}

public void SelectFromCity() {
	selectFrom.sendKeys("Koy");
	String expectedFromCity = "Koyambedu,Chennai";
	List<WebElement> fromCities = driver.findElements(By.xpath("//li"));
	for (WebElement ele1 : fromCities) {
		String fromCity = ele1.getText();
		if (fromCity.equalsIgnoreCase(expectedFromCity)) {
			ele1.click();
		}
	}
}
public void ChosseToCity() {
	chooseTo.click();
}
public void SelectToCity() {
	selectTo.sendKeys("Tam");
	String expectedToCity = "Tambaram,chennai";
	List<WebElement> toCities = driver.findElements(By.xpath("//li"));
	for (WebElement ele1 : toCities) {
		String fromCity = ele1.getText();
		if (fromCity.equalsIgnoreCase(expectedToCity)) {
			ele1.click();
		}
	}
}

public void Swap() {
	swap.click();
}
public void ChooseDate() {
	chooseDate.click();
	String expectedMonth = "Jun 2023";
	String date = "20";
	for (int i = 0; i <= 32; i++) {
		List<WebElement> months = driver.findElements(By.xpath("//td[@class='monthTitle']"));
		for (WebElement ele : months) {
			//System.out.println(ele.getText());
			if (ele.getText().equalsIgnoreCase(expectedMonth)) {
				List<WebElement> days = driver.findElements(By.cssSelector(".day"));
				for (WebElement e : days) {
					String day = e.getText();
					System.out.println(day);
					if (day.equals(date)) {
						e.click();
						i = 33;
					}
				}

			} else {
				WebElement nextMonth = driver.findElement(By.cssSelector("td[class='next'] button"));
				nextMonth.click();
			}
		}
	}
}
public void Search() {
	driver.findElement(By.xpath("//button[@id='search_btn']")).click();
}
}
