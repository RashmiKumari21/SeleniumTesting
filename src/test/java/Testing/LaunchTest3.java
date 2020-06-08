package Testing;

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

import Utils.excelUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class LaunchTest3 {

	static WebDriver driver;
	static WebElement form;




	public static void main(String[] args) throws InterruptedException {

		ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter("Report.html");
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(htmlReporter);

		ExtentTest test1= extent.createTest("Login and Checkout Product");

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


		WebDriverWait wait = new WebDriverWait(driver, 100);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='legacyModal']")));
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

		test1.log(Status.INFO," Login Page is Loaded");

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

		test1.pass("Login Successfull");

		//wait = new WebDriverWait(driver, 100);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='sfly3-my-shutterfly']")));
		//driver.findElement(By.xpath("//a[@id='sfly3-my-shutterfly']")).click();


		wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Mugs')]")));
		driver.findElement(By.xpath("//h5[contains(text(),'Mugs')]")).click();

		Thread.sleep(4000);
		test1.pass("Item selected from the Widget");


		driver.switchTo().defaultContent();

		System.out.println("Switched");




		if(driver.findElement(By.xpath("//*[@id=\"sfly_wgt_full_openwin_container\"]")).isDisplayed())
		{

			System.out.println("Displayed");

			driver.findElement(By.xpath("//ul[@id='sfly_wgt_sideopen_products_inner_container']//li[1]")).click();

			Thread.sleep(3000);
			test1.pass("Design Selected");

			wait = new WebDriverWait(driver, 100);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='addToCartLink']")));
			driver.findElement(By.xpath("//a[@id='addToCartLink']")).click();

			test1.log(Status.INFO,"Adding to CART");


			driver.switchTo().defaultContent();
			System.out.println("Switched1");

			Thread.sleep(4000);

			if(driver.findElement(By.xpath("//*[@id=\"ErrorWarningsModal\"]")).isDisplayed())
			{

				System.out.println("Display2");


				driver.findElement(By.xpath("//*[@id=\"ErrorWarningsModalButton0\"]")).click();

				Thread.sleep(2000);
				test1.log(Status.INFO,"Warnings Ignored");


				String projName=excel.getCellData(1,2);
				driver.findElement(By.xpath("//*[@id=\"saveControlProjectName\"]")).sendKeys(projName);
				Thread.sleep(2000);

				driver.findElement(By.xpath("//*[@id=\"saveExistingModalButton1\"]")).click();
				Thread.sleep(2000);

				test1.log(Status.INFO,"Project Saved");

				wait = new WebDriverWait(driver, 100);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"AddonDialogueModalButton0\"]")));
				driver.findElement(By.xpath("//*[@id=\"AddonDialogueModalButton0\"]")).click();
				test1.log(Status.INFO,"Add on Skipped");


			}

			else if(driver.findElement(By.xpath("//*[@id=\"saveExistingModal\"]")).isDisplayed()){

				System.out.println("Display3");



				driver.findElement(By.xpath("//*[@id=\"saveControlProjectName\"]")).sendKeys("Test1");
				Thread.sleep(2000);

				driver.findElement(By.xpath("//*[@id=\"saveExistingModalButton1\"]")).click();
				Thread.sleep(2000);
				test1.log(Status.INFO,"Project Saved");

				wait = new WebDriverWait(driver, 100);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"AddonDialogueModalButton0\"]")));
				driver.findElement(By.xpath("//*[@id=\"AddonDialogueModalButton0\"]")).click();

				test1.log(Status.INFO,"Add on Skipped");

			}

			else {
				System.out.println("Invalid Window Found");

				test1.fail("Cannot Proceed to Checkout");
			}
			{


			}

			wait = new WebDriverWait(driver, 100);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"proceedButton\"]")));
			driver.findElement(By.xpath("//*[@id=\"proceedButton\"]")).click();




			String item= driver.findElement(By.xpath("//h6[@class='cartitem-title']")).getText();
			test1.pass("Item Added to the Cart: "+item);

			String project= driver.findElement(By.xpath("//i[@title='\"Test1\"']")).getText();

			test1.pass("Project Displaying on cart: "+project);

			System.out.println("The item added to the Cart is "+ item);
			System.out.println("The Project it is related to is "+project);


			driver.findElement(By.xpath("//div[@class='cartitem-actions']//a[@class='tertiary-link'][contains(text(),'Remove')]")).click();


			driver.switchTo().defaultContent();
			Thread.sleep(1000);

			wait = new WebDriverWait(driver, 100);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-action='confirmRemove']")));
			driver.findElement(By.xpath("//a[@data-action='confirmRemove']")).click();


			test1.pass("Item Removed from CART ");

			driver.switchTo().defaultContent();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//i[contains(@class,'sf3-icon sf3-icon-triangle')]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//a[contains(@name,'&lid=GlobalHeader_Sign out')]")).click();
			Thread.sleep(1000);
			System.out.println("Logged out successfully");
			test1.pass("Log out Successfull");

			driver.close();



			ExtentTest test2= extent.createTest("Login and Checkout Product with random Design");

			System.out.println("Iteration 2");

			System.setProperty("webdriver.chrome.driver",projectpath+"\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();


			driver.get("https://www.shutterfly.com/");
			Thread.sleep(1000);
			test2.log(Status.INFO," Shutterfly.com is now opened in a browser");


			wait = new WebDriverWait(driver, 100);
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

			test2.log(Status.INFO," Login Page is Loaded");

			wait = new WebDriverWait(driver, 100);
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='userName']")));
			element.isDisplayed();
			excelUtils excel1=new excelUtils(projectpath+"//DataSheets//data.xlsx", "Sheet1");
			String userName1=excel1.getCellData(1,0);
			String password1= excel1.getCellData(1,1);

			element.sendKeys(userName1);

			Thread.sleep(1000);


			driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password1);

			driver.findElement(By.xpath("//a[@id='signInButton']")).click();
			Thread.sleep(5000);

			//wait = new WebDriverWait(driver, 100);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='sfly3-my-shutterfly']")));
			//driver.findElement(By.xpath("//a[@id='sfly3-my-shutterfly']")).click();

			test2.pass("Login Successfull");
			wait = new WebDriverWait(driver, 100);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Mugs')]")));
			driver.findElement(By.xpath("//h5[contains(text(),'Mugs')]")).click();

			Thread.sleep(4000);
			test2.pass("Item selected from the Widget");

			driver.switchTo().defaultContent();

			System.out.println("Switched");



			String projName1=excel.getCellData(1,3);
			if(driver.findElement(By.xpath("//*[@id=\"sfly_wgt_full_openwin_container\"]")).isDisplayed())
			{

				System.out.println("Displayed");

				List<WebElement> optionCount = driver.findElements(By.xpath("//*[@id=\"sfly_wgt_full_openwin_container\"]"));
				int options= optionCount.size();

				System.out.println("no of all options present are "+options);

				Random rn = new Random();
				int answer = rn.nextInt(10) + 1;

				driver.findElement(By.xpath("//ul[@id='sfly_wgt_sideopen_products_inner_container']//li["+answer+"]")).click();

				Thread.sleep(3000);
				test2.pass("Random Design Selected from the options");

				wait = new WebDriverWait(driver, 100);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='addToCartLink']")));
				driver.findElement(By.xpath("//a[@id='addToCartLink']")).click();

				test2.log(Status.INFO,"Adding to CART");

				driver.switchTo().defaultContent();
				System.out.println("Switched1");

				Thread.sleep(4000);



				if(driver.findElement(By.xpath("//*[@id=\"ErrorWarningsModal\"]")).isDisplayed())
				{

					System.out.println("Display2");


					driver.findElement(By.xpath("//*[@id=\"ErrorWarningsModalButton0\"]")).click();

					Thread.sleep(2000);
					test1.log(Status.INFO,"Warnings Ignored");



					driver.findElement(By.xpath("//*[@id=\"saveControlProjectName\"]")).sendKeys(projName1);
					Thread.sleep(2000);

					driver.findElement(By.xpath("//*[@id=\"saveExistingModalButton1\"]")).click();
					Thread.sleep(2000);

					test1.log(Status.INFO,"Project Saved");

					wait = new WebDriverWait(driver, 100);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"AddonDialogueModalButton0\"]")));
					driver.findElement(By.xpath("//*[@id=\"AddonDialogueModalButton0\"]")).click();
					test1.log(Status.INFO,"Add on Skipped");
				}

				else if(driver.findElement(By.xpath("//*[@id=\"saveExistingModal\"]")).isDisplayed()){

					System.out.println("Display3");



					driver.findElement(By.xpath("//*[@id=\"saveControlProjectName\"]")).sendKeys(projName1);
					Thread.sleep(2000);

					driver.findElement(By.xpath("//*[@id=\"saveExistingModalButton1\"]")).click();
					Thread.sleep(2000);
					test2.log(Status.INFO,"Project Saved");

					wait = new WebDriverWait(driver, 100);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"AddonDialogueModalButton0\"]")));
					driver.findElement(By.xpath("//*[@id=\"AddonDialogueModalButton0\"]")).click();
					test2.log(Status.INFO,"Add on Skipped");


				}

				else {
					System.out.println("Invalid Window Found");
					test2.fail("Cannot Proceed to Checkout");
				}
				{


				}

				wait = new WebDriverWait(driver, 100);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"proceedButton\"]")));
				driver.findElement(By.xpath("//*[@id=\"proceedButton\"]")).click();




				String item1= driver.findElement(By.xpath("//h6[@class='cartitem-title']")).getText();
				test2.pass("Item Added to the Cart: "+item);
				String project1= driver.findElement(By.xpath("//i[@title='\"Test2\"']")).getText();

				test2.pass("Project Displaying on cart: "+project);

				System.out.println("The item added to the Cart is "+ item1);
				System.out.println("The Project it is related to is "+project1);


				driver.findElement(By.xpath("//div[@class='cartitem-actions']//a[@class='tertiary-link'][contains(text(),'Remove')]")).click();


				driver.switchTo().defaultContent();
				Thread.sleep(1000);

				wait = new WebDriverWait(driver, 100);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-action='confirmRemove']")));
				driver.findElement(By.xpath("//a[@data-action='confirmRemove']")).click();

				test2.pass("Item Removed from CART ");



				driver.switchTo().defaultContent();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//i[contains(@class,'sf3-icon sf3-icon-triangle')]")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//a[contains(@name,'&lid=GlobalHeader_Sign out')]")).click();
				Thread.sleep(1000);
				System.out.println("Logged out successfully");

				test2.pass("Log out Successfull");


				driver.close();





			}


		}
	}
}
