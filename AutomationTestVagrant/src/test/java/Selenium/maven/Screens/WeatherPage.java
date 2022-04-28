package Selenium.maven.Screens;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import Selenium.maven.utills.Page;

public class WeatherPage extends Page {

	public WeatherPage(WebDriver driver) {
		super(driver);
	}

	long wait = 100;

	@FindBy(xpath = "//input[@id='searchBox']")
	private WebElement searchBox;

	@FindBy(xpath = "//div[@title='Kanpur']//div//span[@class='tempRedText']")
	private WebElement citytemperature;

	String city = null;
	String condition = null;
	String Wind = null;
	String Humidity = null;
	String Temp = null;
	String currentTemperature = null;

	public void getWeatherDetails() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		try {
			// search city in search box
			String desiredCity = getPropertyValue("cityName");
			enterTextField(searchBox, desiredCity);

			// select city check box
			WebElement searchCheckBox = driver
					.findElement(By.xpath("//input[@id='" + getPropertyValue("cityName") + "']"));
			selectCheckBox(searchCheckBox);

			// get value from city text box
			selectCity(getPropertyValue("cityName"));
			List<WebElement> l1 = getWeatherValue();
			condition = l1.get(0).getText();
			Wind = l1.get(1).getText();
			Humidity = l1.get(2).getText();
			Temp = l1.get(3).getText();
			System.out.println("Condition========" + condition);
			System.out.println("Wind========" + Wind);
			System.out.println("Humidity========" + Humidity);
			System.out.println("Temp========" + Temp);

			currentTemperature = citytemperature.getText();
			System.out.println("City Temperature===" + currentTemperature);
			Reporter.log("weather Details has been succesfully verified with temperature=" + currentTemperature);
		} catch (Exception e) {
			System.out.println("method found exception=" + e);

		}
	}

	public String selectCity(String inputCity) {
		try {
			WebElement cityWebElement = driver.findElement(By.xpath("//div[text()='" + inputCity + "']"));
			clickIntoWeElement(cityWebElement, "JS");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			city = cityWebElement.getText();
			System.out.println("searching city is Available===" + city);
		} catch (Exception e) {
			System.out.println("method found exception=" + e);
		}

		return city;
	}

	public List<WebElement> getWeatherValue() {
		List<WebElement> weatherdetails = driver.findElements(By.xpath("//span[@class='heading']/b"));
		condition = weatherdetails.get(0).getText();
		Wind = weatherdetails.get(1).getText();
		Humidity = weatherdetails.get(2).getText();
		Temp = weatherdetails.get(3).getText();
		System.out.println("Condition on UI========" + condition);
		System.out.println("Wind on UI========" + Wind);
		System.out.println("Humidity on UI========" + Humidity);
		System.out.println("Temp on UI========" + Temp);
		return weatherdetails;
	}

	public void verifyUIAndApiDatsa(String inputUI, String inputAPI) {

		Assert.assertEquals(inputUI, inputAPI);
		Reporter.log("both value from UI value is " + inputUI + " and API value is " + inputAPI
				+ " has been matched succesfully");
		System.out.println("UI contains value is =" + inputUI + " and API contains value is =" + inputAPI + "");
	}

}
