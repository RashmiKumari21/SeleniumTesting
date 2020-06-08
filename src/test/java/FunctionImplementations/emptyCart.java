package FunctionImplementations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class emptyCart {
	
	static WebElement element;
	static WebDriver driver;
	static WebElement form;
	static WebDriverWait wait = new WebDriverWait(driver, 100);
	static String projectpath=System.getProperty("user.dir");

	
	public static void cleanCart() throws InterruptedException
	{
		
		driver.findElement(By.xpath("//div[@class='cartitem-actions']//a[@class='tertiary-link'][contains(text(),'Remove')]")).click();


		driver.switchTo().defaultContent();
		Thread.sleep(1000);

		wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-action='confirmRemove']")));
		driver.findElement(By.xpath("//a[@data-action='confirmRemove']")).click();
	}
	

}
