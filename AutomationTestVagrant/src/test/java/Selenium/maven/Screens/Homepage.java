package Selenium.maven.Screens;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import Selenium.maven.utills.Page;

public class Homepage extends Page {

/*	public Homepage(WebDriver driver) {
		super(driver);
	
	}*/
	long wait = 100;

	@FindBy(xpath = "//a[@class='notnow']")
	private WebElement notNowLink;

	@FindBy(xpath = "//a[@id ='h_sub_menu']")
	private WebElement expandLink;

	@FindBy(xpath = "//div[@class='topnav_cont']//a[text()='WEATHER']")
	private WebElement weatherlink;

	@FindBy(xpath = "//input[id='searchBox']")
	private WebElement searchBox;

	public void openWeatherSection() {

		try {
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			

			if (notNowLink.isDisplayed()) {
				scrollToElement(notNowLink);
				clickIntoWeElement(notNowLink, "");
			}

			// clicking on expand link
			loadWebElement(expandLink);
			scrollToElement(expandLink);
			clickIntoWeElement(expandLink, "JS");

			// opening weather section
			scrollToElement(weatherlink);
			clickIntoWeElement(weatherlink, "JS");
			waitForPageLoaded(driver);

			// take scrennshot for webElement
//			File src = weatherlink.getScreenshotAs(OutputType.FILE);
//			File dest = new File(getPropertyValue("screenshotPath"));
//			FileHandler.copy(src, dest);

		} catch (Exception e) {
			System.out.println("method found exception=" + e);
		}
	}

}
