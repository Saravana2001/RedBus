package test.RedBus;

import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RedBus {

	public static void main(String args[]) throws InterruptedException, IOException {

		WebDriver driver = new ChromeDriver();
//		String expectedFromCity = "Koyambedu,Chennai";
//		String expectedToCity = "Tambaram,chennai";
//		String expectedMonth = "Jun 2023";
		//String date = "20";
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		
		String fileLocation = "./Test-data/Value.xlsx";
		
		
		XSSFWorkbook wbook = new XSSFWorkbook(fileLocation);
		XSSFSheet sheet = wbook.getSheetAt(0);
		XSSFRow row = sheet.getRow(1);
		XSSFCell cell = row.getCell(0);
		
		
		String expectedFromCity = cell.getStringCellValue();
		String expectedToCity =sheet.getRow(2).getCell(1).getStringCellValue();
		sheet.getActiveCell();
		String expectedMonth =sheet.getRow(3).getCell(1).getStringCellValue();
		String date =sheet.getRow(4).getCell(1).getStringCellValue();
		
		driver.findElement(By.xpath("//label[normalize-space()='FROM']")).click();
		driver.findElement(By.xpath("//input[@id='src']")).sendKeys("Tam");
		List<WebElement> fromCities = driver.findElements(By.xpath("//li"));
		for (WebElement ele1 : fromCities) {
			String fromCity = ele1.getText();
			if (fromCity.equalsIgnoreCase(expectedFromCity)) {
				ele1.click();
			}
		}
		driver.findElement(By.xpath("//label[normalize-space()='TO']")).click();
		driver.findElement(By.xpath("//input[@id='dest']")).sendKeys("Koy");
		List<WebElement> toCities = driver.findElements(By.xpath("//li"));
		for (WebElement ele1 : toCities) {
			String fromCity = ele1.getText();
			if (fromCity.equalsIgnoreCase(expectedToCity)) {
				ele1.click();
			}
		}
		driver.findElement(By.xpath("//span[@id='togglebtn']")).click();
		driver.findElement(By.xpath("//input[@id='onward_cal']")).click();
		for (int i = 0; i <= 32; i++) {
			List<WebElement> months = driver.findElements(By.xpath("//td[@class='monthTitle']"));
			for (WebElement ele : months) {
				System.out.println(ele.getText());
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
		driver.findElement(By.xpath("//button[@id='search_btn']")).click();
		Thread.sleep(7000);
		driver.close();
	}

}
