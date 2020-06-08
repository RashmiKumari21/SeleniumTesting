package Pages;

import org.openqa.selenium.By;

public class Cart {
	
	public static By lblitem=By.xpath("//h6[@class='cartitem-title']");
	public static By lblProject=By.xpath("//i[@title='\"Test1\"']");
	public static By btnremove=By.xpath("//div[@class='cartitem-actions']//a[@class='tertiary-link'][contains(text(),'Remove')]");
	public static By btnConfirmRemove=By.xpath("//a[@data-action='confirmRemove']");

}
