package Selenium.maven.ApiTest;

import org.testng.Assert;
import org.testng.Reporter;

import com.google.gson.Gson;

import Selenium.maven.api.response.PositiveResponseWeatherDTO;
import Selenium.maven.utills.Page;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestWeatherCityAPI extends Page {
	PositiveResponseWeatherDTO responseDTO =new PositiveResponseWeatherDTO();
	Gson gson = new Gson();

	String uriValue = getPropertyValue("uri");
	String paramKey1 = getPropertyValue("queryParamKey1");
	String paramValue1 = getPropertyValue("queryParamValue1");
	String paramKey2 = getPropertyValue("queryParamKey2");
	String paramValue2 = getPropertyValue("queryParamValue2");
	String searchKeyID = getPropertyValue("searchId");

	public PositiveResponseWeatherDTO testWeatherApi() {
		try {
			RestAssured.baseURI = uriValue;

			RequestSpecification request = RestAssured.given();

			Response response = request.queryParam(paramKey1, paramValue1).queryParam(paramKey2, paramValue2)
					.get(searchKeyID);

			String resultBody = response.asString();
			System.out.println("Response of weather API is ==" + resultBody);

			responseDTO = gson.fromJson(resultBody, PositiveResponseWeatherDTO.class);
			Reporter.log("weather api has been successfully responded with=" + response.statusCode());

		} catch (Exception e) {
			System.out.println("Exception found in api method===" + e);
		}
		return responseDTO;
	}

	public void verifyWeatherDataAPI(PositiveResponseWeatherDTO responseDTO, String expectedCity) {
		String cityName = responseDTO.getName();
		float temperature = responseDTO.getMain().getTemp();
		System.out.println("Api temperature in kelvin=="+temperature);
		int currentTemperature=convertTemperature(temperature, "Cel");
		float humadity = responseDTO.getMain().getHumidity();

		System.out.println("City name====" + cityName);
		System.out.println("Current Temperature of city====" + currentTemperature);
		System.out.println("Humadity of city====" + humadity);
		Assert.assertEquals(cityName, expectedCity);
		Reporter.log("weather api has been successfully responded with=" +expectedCity);

	}


}
