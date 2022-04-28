package Selenium.maven.utills;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class Page {

	protected static WebDriver driver;
	long wait = 100;

	public Page() {
		// TODO Auto-generated constructor stub
	}

	public Page(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}

	protected void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public Properties propertyFile = new Properties();
	public FileInputStream stream;

	public boolean loadWebElement(WebElement w) {
		boolean result = false;

		WebDriverWait webDriverWait = null;

		webDriverWait = new WebDriverWait(driver, wait);

		try {
			webDriverWait.until(ExpectedConditions.visibilityOf(w)).isDisplayed();

			if (w.isDisplayed()) {
				result = true;
			}
		} catch (NoSuchElementException e) {
			result = false;
		} catch (NullPointerException e) {
			result = false;
		} catch (TimeoutException e) {
			result = false;
		}
		return result;
	}

	public void scrollToElement(WebElement element) throws InterruptedException {

		loadWebElement(element);
		JavascriptExecutor js=((JavascriptExecutor) driver);

		js.executeScript("arguments[0].scrollIntoView(true);", element);
//	    js.executeScript("windows.scrollBy(x-pixel ,y-pixel)", (200,1000));
//		js.executeScript("windows.scrollTo(0,document.body.scrollHeight");
	
	}

	public void selectCheckBox(WebElement element) throws InterruptedException {
		try {
			scrollToElement(element);
			if (element.isSelected()) {
				Actions actions = new Actions(driver);
				actions.doubleClick(element).perform();
			} else {
				element.click();
			}

		} catch (Exception e) {
			System.out.println("Checkbox is not found==" + e);
		}

	}

	//
	public String getPropertyValue(String key) {
		try {
			stream = new FileInputStream(System.getProperty("user.dir") + "/config/ui.properties");
			propertyFile.load(stream);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return propertyFile.getProperty(key);

	}

	public void clickIntoWeElement(WebElement element, String type) {
		try {
			loadWebElement(element);
			if (type.equalsIgnoreCase("JS"))
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			else
				element.click();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void enterTextField(WebElement wText, String data) throws Exception

	{
		try {
			scrollToElement(wText);
			if (loadWebElement(wText)) {
				wText.sendKeys(Keys.chord(Keys.CONTROL, "a"));
				wText.sendKeys(Keys.DELETE);
				wText.sendKeys(data);
				wText.sendKeys(Keys.TAB);
			}
		} catch (Exception e) {
			Reporter.log("WebElement has not been clicked successfully==" + e);

		}
	}

	public void waitForPageLoaded(WebDriver driver) {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {
			wait.until(expectation);
		} catch (Exception e) {
			Reporter.log("Page load has been failed due to ==" + e);

		}
	}

	public int convertTemperature(float inputTemp, String type) {
		float temp = 0;

		if (type.equalsIgnoreCase("Cel"))
			temp = (float) (inputTemp - 273.15);

		if (type.equalsIgnoreCase("kelvin"))
			temp = (float) (273.15 + inputTemp);
		

		return (int) Math.ceil(temp);
	}
}
