package om.kuman.Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebBrowser {
	public static WebDriver driver;

	public WebDriver browser() {
		return driver = new ChromeDriver();

	}

}
