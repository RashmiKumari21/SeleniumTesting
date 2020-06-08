package FunctionImplementations;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import Utils.excelUtils;

public class addingItems {

	static WebElement element;
	static WebDriver driver;
	static WebElement form;
	static WebDriverWait wait = new WebDriverWait(driver, 100);
	static String projectpath=System.getProperty("user.dir");





	public static void cartItemsadd() throws InterruptedException {
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

			Thread.sleep(4000);

			if(driver.findElement(By.xpath("//*[@id=\"ErrorWarningsModal\"]")).isDisplayed())
			{
				System.out.println("Display2");
				driver.findElement(By.xpath("//*[@id=\"ErrorWarningsModalButton0\"]")).click();

				Thread.sleep(4000);

				excelUtils excel=new excelUtils(projectpath+"//DataSheets//data.xlsx", "Sheet1");
				String projName=excel.getCellData(1,2);

				driver.findElement(By.xpath("//*[@id=\"saveControlProjectName\"]")).sendKeys(projName);
				Thread.sleep(2000);

				driver.findElement(By.xpath("//*[@id=\"saveExistingModalButton1\"]")).click();
				Thread.sleep(2000);



				wait = new WebDriverWait(driver, 100);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"AddonDialogueModalButton0\"]")));
				driver.findElement(By.xpath("//*[@id=\"AddonDialogueModalButton0\"]")).click();



			}

			else 

			{

				//driver.findElement(By.xpath("//*[@id=\"saveExistingModal\"]")).isDisplayed();

				System.out.println("Display3");



				driver.findElement(By.xpath("//*[@id=\"saveControlProjectName\"]")).sendKeys("Test1");
				Thread.sleep(2000);

				driver.findElement(By.xpath("//*[@id=\"saveExistingModalButton1\"]")).click();
				Thread.sleep(2000);

				wait = new WebDriverWait(driver, 100);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"AddonDialogueModalButton0\"]")));
				driver.findElement(By.xpath("//*[@id=\"AddonDialogueModalButton0\"]")).click();


			}




			wait = new WebDriverWait(driver, 100);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"proceedButton\"]")));
			driver.findElement(By.xpath("//*[@id=\"proceedButton\"]")).click();



		}
	}





	public static void cartItemsaddRandom() throws InterruptedException{
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
			int answer = rn.nextInt(6) + 1;

			driver.findElement(By.xpath("//ul[@id='sfly_wgt_sideopen_products_inner_container']//li["+answer+"]")).click();

			Thread.sleep(3000);




			wait = new WebDriverWait(driver, 100);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='addToCartLink']")));
			driver.findElement(By.xpath("//a[@id='addToCartLink']")).click();



			driver.switchTo().defaultContent();
			System.out.println("Switched1");

			Thread.sleep(4000);

			if(driver.findElement(By.xpath("//*[@id=\"ErrorWarningsModal\"]")).isDisplayed())
			{
				System.out.println("Display2");
				driver.findElement(By.xpath("//*[@id=\"ErrorWarningsModalButton0\"]")).click();

				Thread.sleep(4000);

				excelUtils excel=new excelUtils(projectpath+"//DataSheets//data.xlsx", "Sheet1");
				String projName=excel.getCellData(1,2);

				driver.findElement(By.xpath("//*[@id=\"saveControlProjectName\"]")).sendKeys(projName);
				Thread.sleep(2000);

				driver.findElement(By.xpath("//*[@id=\"saveExistingModalButton1\"]")).click();
				Thread.sleep(2000);



				wait = new WebDriverWait(driver, 100);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"AddonDialogueModalButton0\"]")));
				driver.findElement(By.xpath("//*[@id=\"AddonDialogueModalButton0\"]")).click();



			}

			else 

			{

				//driver.findElement(By.xpath("//*[@id=\"saveExistingModal\"]")).isDisplayed();

				System.out.println("Display3");



				driver.findElement(By.xpath("//*[@id=\"saveControlProjectName\"]")).sendKeys("Test1");
				Thread.sleep(2000);

				driver.findElement(By.xpath("//*[@id=\"saveExistingModalButton1\"]")).click();
				Thread.sleep(2000);

				wait = new WebDriverWait(driver, 100);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"AddonDialogueModalButton0\"]")));
				driver.findElement(By.xpath("//*[@id=\"AddonDialogueModalButton0\"]")).click();


			}




			wait = new WebDriverWait(driver, 100);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"proceedButton\"]")));
			driver.findElement(By.xpath("//*[@id=\"proceedButton\"]")).click();



		}
	}
}



