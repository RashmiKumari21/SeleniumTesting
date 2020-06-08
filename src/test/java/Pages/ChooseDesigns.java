package Pages;

import java.util.Random;

import org.openqa.selenium.By;

public class ChooseDesigns {

	
	
	
	public static By designContainer=By.xpath("//*[@id=\"sfly_wgt_full_openwin_container\"]"); 
	
	public static By element1=By.xpath("//ul[@id='sfly_wgt_sideopen_products_inner_container']//li[1]");
	
	
	static Random rn = new Random();
	static int answer = rn.nextInt(10) + 1;

	public static By randomelement=By.xpath("//ul[@id='sfly_wgt_sideopen_products_inner_container']//li["+answer+"]");

	
	
}
