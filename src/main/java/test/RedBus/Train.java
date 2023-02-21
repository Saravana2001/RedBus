package test.RedBus;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Train {

	public static void main(String[] args) {
		WebDriver driver;

		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-blink-features\\=AutomationControlled");
		options.addArguments("disable-extensions");
		options.setExperimentalOption("useAutomationExtension", false);
		options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
		options.addArguments("start-maximized");
		options.addArguments("profile-directory\\=Default");
		driver = new ChromeDriver(options);

		driver.get("https://www.makemytrip.com/railways/");

		driver.manage().window().maximize();

	}

}
