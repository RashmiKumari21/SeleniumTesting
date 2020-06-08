package Pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

public class ShutterflyBasePage {
	
	static WebElement element;
	
	public static By lblForm=By.xpath("//span[@class='signupForm-note']//a[@name='&lid=GlobalHeader_Sign in'][contains(text(),'Sign in')]");
	public static By btnLogin=By.xpath("//input[@id='userName']");
	
	
}