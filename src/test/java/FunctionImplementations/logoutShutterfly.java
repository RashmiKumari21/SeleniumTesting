package FunctionImplementations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class logoutShutterfly {
	
	static WebElement element;
	static WebDriver driver;
	static WebElement form;
	static WebDriverWait wait = new WebDriverWait(driver, 100);
	static String projectpath=System.getProperty("user.dir");
	
	public static void logout() throws InterruptedException {
	
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
