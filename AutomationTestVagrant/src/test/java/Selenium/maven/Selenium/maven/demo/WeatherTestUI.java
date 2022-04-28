package Selenium.maven.Selenium.maven.demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

//--
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
//--
import org.testng.annotations.AfterClass;
//--
import org.testng.annotations.BeforeClass;
//--
import org.testng.annotations.Test;

import Selenium.maven.ApiTest.TestWeatherCityAPI;
import Selenium.maven.Screens.Homepage;
import Selenium.maven.Screens.WeatherPage;
import Selenium.maven.api.response.PositiveResponseWeatherDTO;
import Selenium.maven.utills.Page;

public class WeatherTestUI extends Page {

//	PositiveResponseWeatherDTO responseDTO = new PositiveResponseWeatherDTO();
	String expectedCity = null;
	String expectedTemp = null;
	private WebDriver driver;
	long wait = 100;

	@BeforeClass
	public void openBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver", getPropertyValue("driverPath"));

			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(getPropertyValue("url"));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority = 1, enabled = true)
	public void openHomePageNDTV() {

		Homepage hp = PageFactory.initElements(driver, Homepage.class);
		hp.openWeatherSection();

	}

	@Test(priority = 2, enabled = false)
	public void verifyWeatherSection() {

		WeatherPage wp = PageFactory.initElements(driver, WeatherPage.class);
		wp.getWeatherDetails();

	}
//
//	@Test(priority = 3, enabled = true)
//	public void verifyWeatherSectionAPI() {
//
//		TestWeatherCityAPI weatherDetails = PageFactory.initElements(driver, TestWeatherCityAPI.class);
//		responseDTO = weatherDetails.testWeatherApi();
//
//		expectedCity = getPropertyValue("cityName");
//
//		weatherDetails.verifyWeatherDataAPI(responseDTO, expectedCity);
//
//	}
//
//	@Test(priority = 4, enabled = true)
//	public void verifyBothUIandAPISection() {
//
//		WeatherPage wp = PageFactory.initElements(driver, WeatherPage.class);
//		List<WebElement> list = wp.getWeatherValue();
//		String tempUI = list.get(3).getText();
//
//		float temperature = responseDTO.getMain().getTemp();
//		System.out.println("Api temperature in kelvin==" + temperature);
//		String tempAPI = String.valueOf(convertTemperature(temperature, "Cel"));
//
//		String expectedCityUI = wp.selectCity(expectedCity);
//		String expectedCityAPI = responseDTO.getName();
//		wp.verifyUIAndApiDatsa(expectedCityUI, expectedCityAPI);
//		wp.verifyUIAndApiDatsa(tempUI, tempAPI);
//
//	}

	@AfterClass
	public void afterClass() {
		driver.close();
		driver.quit();
	}

}
