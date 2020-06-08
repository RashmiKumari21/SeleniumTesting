package FunctionImplementations;

import java.util.List;
import java.util.Random;

import org.apache.poi.xwpf.usermodel.IBodyElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

import Utils.excelUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;



import com.aventstack.extentreports.Status;

import Pages.ShutterflyBasePage;

public class basePageMethods extends ShutterflyBasePage{
	
	static WebElement element;
	static WebDriver driver;
	static WebElement form;

	
	public static void formAvailable() throws InterruptedException{
		
		
		
		WebDriverWait wait = new WebDriverWait(driver, 100);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='legacyModal']")));
		element.click();

		Thread.sleep(1000);

		if(driver.findElement(By.xpath("//span[@class='signupForm-note']//a[@name='&lid=GlobalHeader_Sign in'][contains(text(),'Sign in')]")).isDisplayed())
		{

			driver.findElement(By.xpath("//span[@class='signupForm-note']//a[@name='&lid=GlobalHeader_Sign in'][contains(text(),'Sign in')]")).click();
		}
		else
		{
			driver.findElement(By.xpath("//a[@name='&lid=GlobalHeader_Sign in']")).click();

		}

		
		
		
	
	}

}
