package TestNykaa;

import java.awt.datatransfer.StringSelection;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TestNyka {

	public static void main(String[] args) throws Exception{
	
			String url = "https://www.nykaa.com/";
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\User\\Desktop\\TestVagrant\\AutomationTestVagrant\\src\\Driver\\chromedriver.exe");

			WebDriver driver = new ChromeDriver();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			String parentWindow =driver.getWindowHandle();
			WebElement hairLink = driver
					.findElement(By.xpath("//li[@class ='MegaDropdownHeadingbox']//a[text()='hair']"));
			hairLink.click();
			
			//wait for new page has to be loaded
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Set window=driver.getWindowHandles();
			
			Iterator<String> itr =window.iterator();
			
			while(itr.hasNext())
			{
				String childWindow=itr.next();
				if (parentWindow!=childWindow) {
					driver.switchTo().window(childWindow);
				}
				
				
			}
			
			
		
			driver.quit();

	}
	
	
	
	
}
