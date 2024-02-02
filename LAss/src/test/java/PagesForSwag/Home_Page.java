package PagesForSwag;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {
	WebDriver driver;
	public Home_Page(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	@FindBy(css=".inventory_item_name ")
	List<WebElement> AllNames;
	
	@FindBy(xpath="//a[@class='shopping_cart_link']")
	WebElement ship;
	@FindBy(xpath="//button[@class='btn btn_primary btn_small btn_inventory']")
	WebElement addbtn;
	@FindBy(xpath="//button[@id='back-to-products']")
	WebElement back;
	
	
	
	
	public List<WebElement> Selecting_Producats() {
		
			return AllNames;
		
	}
	public void getproductlist() throws InterruptedException {
		List<WebElement> e=Selecting_Producats();
		
		genric(e,"Sauce Labs Bike Light");
		Thread.sleep(4000);
		addbtn.click();
		
		back.click();
		Thread.sleep(3000);
		genric(e,"Sauce Labs Bolt T-Shirt");
		Thread.sleep(3000);
		addbtn.click();
		Thread.sleep(3000);
		
		
//		genric(e,"Sauce Labs Onesie");
//		Thread.sleep(2000);
			
		
	}
	public static void genric(List<WebElement> e,String prod) {
		for(WebElement w:e) {
			if(w.getText().equals(prod)) {
				w.click();
				break;
				
			}
		}
	}
	
	public CheckoutPagee Shipping() throws InterruptedException {
		
		ship.click();
		Thread.sleep(3000);
		
		CheckoutPagee cp=new CheckoutPagee(driver);
		cp.Checkout();
		cp.First_name("Parven");
		cp.Last_name("reddy");
		cp.Zip_Code("1029");
		cp.Continiue_btn();
		cp.Finish_btn();
		return cp;
	}
	
	

}
