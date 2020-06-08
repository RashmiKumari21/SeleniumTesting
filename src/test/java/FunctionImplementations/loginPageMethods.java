package FunctionImplementations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.excelUtils;
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




public class loginPageMethods {
	
	static WebElement element;
	static WebDriver driver;
	static WebElement form;
	static WebDriverWait wait = new WebDriverWait(driver, 100);
	static String projectpath=System.getProperty("user.dir");
	
	
	
	public static void login() throws InterruptedException
	{
		wait = new WebDriverWait(driver, 100);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='userName']")));
		element.isDisplayed();
		excelUtils excel=new excelUtils(projectpath+"//DataSheets//data.xlsx", "Sheet1");
		String userName=excel.getCellData(1,0);
		String password= excel.getCellData(1,1);

		element.sendKeys(userName);

		Thread.sleep(1000);


		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);

		driver.findElement(By.xpath("//a[@id='signInButton']")).click();
		Thread.sleep(3000);

		

	}

}
