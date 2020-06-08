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


public class LaunchTest2 {

	static WebDriver driver;
	static WebElement form;




	public static void main(String[] args) throws InterruptedException {

		String projectpath=System.getProperty("user.dir");
		System.out.print(projectpath);

		//System.setProperty("webdriver.gecko.driver",projectpath+"\\Drivers\\geckodriver.exe");
		//WebDriver driver=new FirefoxDriver();


		System.setProperty("webdriver.chrome.driver",projectpath+"\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();


		driver.get("https://www.shutterfly.com/");
		Thread.sleep(1000);


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
		Thread.sleep(5000);

		//wait = new WebDriverWait(driver, 100);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='sfly3-my-shutterfly']")));
		//driver.findElement(By.xpath("//a[@id='sfly3-my-shutterfly']")).click();


		wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Mugs')]")));
		driver.findElement(By.xpath("//h5[contains(text(),'Mugs')]")).click();

		Thread.sleep(4000);

		driver.switchTo().defaultContent();

		System.out.println("Switched");




		if(driver.findElement(By.xpath("//*[@id=\"sfly_wgt_full_openwin_container\"]")).isDisplayed())
		{

			System.out.println("Displayed");

			driver.findElement(By.xpath("//ul[@id='sfly_wgt_sideopen_products_inner_container']//li[1]")).click();

			Thread.sleep(3000);

			wait = new WebDriverWait(driver, 100);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='addToCartLink']")));
			driver.findElement(By.xpath("//a[@id='addToCartLink']")).click();

			driver.switchTo().defaultContent();
			System.out.println("Switched1");

			if(driver.findElement(By.xpath("//*[@id=\"ErrorWarningsModal\"]")).isDisplayed())
			{
				
				System.out.println("Display2");


				driver.findElement(By.xpath("//*[@id=\"ErrorWarningsModalButton0\"]")).click();
				
				Thread.sleep(2000);
				
				
				String projName=excel.getCellData(1,2);
				driver.findElement(By.xpath("//*[@id=\"saveControlProjectName\"]")).sendKeys("projName");
				Thread.sleep(2000);

				driver.findElement(By.xpath("//*[@id=\"saveExistingModalButton1\"]")).click();
				Thread.sleep(2000);

				wait = new WebDriverWait(driver, 100);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"AddonDialogueModalButton0\"]")));
				driver.findElement(By.xpath("//*[@id=\"AddonDialogueModalButton0\"]")).click();
				


			}

			else if(driver.findElement(By.xpath("//*[@id=\"saveExistingModal\"]")).isDisplayed()){

				System.out.println("Display3");



				driver.findElement(By.xpath("//*[@id=\"saveControlProjectName\"]")).sendKeys("Test1");
				Thread.sleep(2000);

				driver.findElement(By.xpath("//*[@id=\"saveExistingModalButton1\"]")).click();
				Thread.sleep(2000);

				wait = new WebDriverWait(driver, 100);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"AddonDialogueModalButton0\"]")));
				driver.findElement(By.xpath("//*[@id=\"AddonDialogueModalButton0\"]")).click();
				


			}
			
			else {
				System.out.println("Invalid Window Found");
			}
			{


			}

			wait = new WebDriverWait(driver, 100);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"proceedButton\"]")));
			driver.findElement(By.xpath("//*[@id=\"proceedButton\"]")).click();




			String item= driver.findElement(By.xpath("//h6[@class='cartitem-title']")).getText();
			String project= driver.findElement(By.xpath("//i[@title='\"Test1\"']")).getText();



			System.out.println("The item added to the Cart is "+ item);
			System.out.println("The Project it is related to is "+project);


			driver.findElement(By.xpath("//div[@class='cartitem-actions']//a[@class='tertiary-link'][contains(text(),'Remove')]")).click();


			driver.switchTo().defaultContent();
			Thread.sleep(1000);

			wait = new WebDriverWait(driver, 100);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-action='confirmRemove']")));
			driver.findElement(By.xpath("//a[@data-action='confirmRemove']")).click();




			driver.switchTo().defaultContent();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//i[contains(@class,'sf3-icon sf3-icon-triangle')]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//a[contains(@name,'&lid=GlobalHeader_Sign out')]")).click();
			Thread.sleep(1000);
			System.out.println("Logged out successfully");
			

			driver.close();
			
			
			System.out.println("Iteration 2");
			
			System.setProperty("webdriver.chrome.driver",projectpath+"\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();


			driver.get("https://www.shutterfly.com/");
			Thread.sleep(1000);


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


			wait = new WebDriverWait(driver, 100);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Mugs')]")));
			driver.findElement(By.xpath("//h5[contains(text(),'Mugs')]")).click();

			Thread.sleep(4000);

			driver.switchTo().defaultContent();

			System.out.println("Switched");




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

				wait = new WebDriverWait(driver, 100);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='addToCartLink']")));
				driver.findElement(By.xpath("//a[@id='addToCartLink']")).click();

				driver.switchTo().defaultContent();
				System.out.println("Switched1");

				if(driver.findElement(By.xpath("//*[@id=\"ErrorWarningsModal\"]")).isDisplayed())
				{
					
					System.out.println("Display2");


					driver.findElement(By.xpath("//*[@id=\"ErrorWarningsModalButton0\"]")).click();
					
					Thread.sleep(2000);
					
					String projName1=excelUtils.getCellData(1,3);
					driver.findElement(By.xpath("//*[@id=\"saveControlProjectName\"]")).sendKeys(projName1);
					Thread.sleep(2000);

					driver.findElement(By.xpath("//*[@id=\"saveExistingModalButton1\"]")).click();
					Thread.sleep(2000);

					wait = new WebDriverWait(driver, 100);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"AddonDialogueModalButton0\"]")));
					driver.findElement(By.xpath("//*[@id=\"AddonDialogueModalButton0\"]")).click();
					


				}

				else if(driver.findElement(By.xpath("//*[@id=\"saveExistingModal\"]")).isDisplayed()){

					System.out.println("Display3");



					driver.findElement(By.xpath("//*[@id=\"saveControlProjectName\"]")).sendKeys("Test1");
					Thread.sleep(2000);

					driver.findElement(By.xpath("//*[@id=\"saveExistingModalButton1\"]")).click();
					Thread.sleep(2000);

					wait = new WebDriverWait(driver, 100);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"AddonDialogueModalButton0\"]")));
					driver.findElement(By.xpath("//*[@id=\"AddonDialogueModalButton0\"]")).click();
					


				}
				
				else {
					System.out.println("Invalid Window Found");
				}
				{


				}

				wait = new WebDriverWait(driver, 100);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"proceedButton\"]")));
				driver.findElement(By.xpath("//*[@id=\"proceedButton\"]")).click();




				String item1= driver.findElement(By.xpath("//h6[@class='cartitem-title']")).getText();
				String project1= driver.findElement(By.xpath("//i[@title='\"Test1\"']")).getText();



				System.out.println("The item added to the Cart is "+ item1);
				System.out.println("The Project it is related to is "+project1);


				driver.findElement(By.xpath("//div[@class='cartitem-actions']//a[@class='tertiary-link'][contains(text(),'Remove')]")).click();


				driver.switchTo().defaultContent();
				Thread.sleep(1000);

				wait = new WebDriverWait(driver, 100);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-action='confirmRemove']")));
				driver.findElement(By.xpath("//a[@data-action='confirmRemove']")).click();




				driver.switchTo().defaultContent();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//i[contains(@class,'sf3-icon sf3-icon-triangle')]")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//a[contains(@name,'&lid=GlobalHeader_Sign out')]")).click();
				Thread.sleep(1000);
				System.out.println("Logged out successfully");
				

				driver.close();


			
		}

		
	}
	}
}
