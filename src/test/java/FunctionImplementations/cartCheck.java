package FunctionImplementations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class cartCheck {
	
	static WebElement element;
	static WebDriver driver;
	static WebElement form;
	static WebDriverWait wait = new WebDriverWait(driver, 100);
	static String projectpath=System.getProperty("user.dir");

	
	public static void cartCheck1()
	{
		String item1= driver.findElement(By.xpath("//h6[@class='cartitem-title']")).getText();
		
		String project1= driver.findElement(By.xpath("//i[@title='\"Test2\"']")).getText();

		
		System.out.println("The item added to the Cart is "+ item1);
		System.out.println("The Project it is related to is "+project1);
	}

}
