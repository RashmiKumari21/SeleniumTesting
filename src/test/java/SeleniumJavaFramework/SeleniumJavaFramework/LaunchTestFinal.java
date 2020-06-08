package SeleniumJavaFramework.SeleniumJavaFramework;

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

import FunctionImplementations.addingItems;
import FunctionImplementations.basePageMethods;
import FunctionImplementations.cartCheck;
import FunctionImplementations.emptyCart;
import FunctionImplementations.loginPageMethods;
import FunctionImplementations.logoutShutterfly;

public class LaunchTestFinal

{

	static WebDriver driver;
	static WebElement form;




	public static void main(String[] args) throws InterruptedException {



		ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter("Report.html");
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(htmlReporter);

		ExtentTest test1= extent.createTest("Login and Checkout Product");

		System.out.println("Login and Checkout Product");

		String projectpath=System.getProperty("user.dir");
		System.out.print(projectpath);

		//System.setProperty("webdriver.gecko.driver",projectpath+"\\Drivers\\geckodriver.exe");
		//WebDriver driver=new FirefoxDriver();


		System.setProperty("webdriver.chrome.driver",projectpath+"\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();


		driver.get("https://www.shutterfly.com/");
		Thread.sleep(1000);
		test1.log(Status.INFO," Shutterfly.com is now opened in a browser");
		
		
		basePageMethods.formAvailable();
		loginPageMethods.login();
		addingItems.cartItemsadd();
		cartCheck.cartCheck1();
		emptyCart.cleanCart();
		logoutShutterfly.logout();
		
		System.out.println("Iteration2- Random Design");
		
		basePageMethods.formAvailable();
		loginPageMethods.login();
		addingItems.cartItemsaddRandom();
		cartCheck.cartCheck1();
		emptyCart.cleanCart();
		logoutShutterfly.logout();
		
		
		
		
		
	}
}

