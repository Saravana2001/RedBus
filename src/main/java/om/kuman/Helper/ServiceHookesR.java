package om.kuman.Helper;

import org.testng.annotations.BeforeClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class ServiceHookesR {
WebBrowser wb = new WebBrowser();
	
	@Before
	public void initializeTest() {
		wb.browser();
		
		
	}
	
	
	
	@After
	public void quit() throws InterruptedException {
		Thread.sleep(5000);
		wb.driver.close();
	}
}
