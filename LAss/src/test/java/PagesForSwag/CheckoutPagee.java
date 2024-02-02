package PagesForSwag;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPagee {
	
	WebDriver driver;
	public CheckoutPagee(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	@FindBy(id="checkout")
	WebElement chekot;
	@FindBy(name="firstName")
	WebElement Fname;
	@FindBy(name="lastName")
	WebElement Lname;
	@FindBy(xpath="//input[@id='postal-code']")
	WebElement Zipc;
	@FindBy(css="input[type='submit']")
	WebElement conti;
	@FindBy(css="button[id='finish']")
	WebElement fin;
	
	public void Checkout() {
		chekot.click();
	}
	public void First_name(String Name) {
		Fname.sendKeys(Name);
	}
	public void Last_name(String lName) {
		Lname.sendKeys(lName);
	}
	public void Zip_Code(String ZName) throws InterruptedException {
		Zipc.sendKeys(ZName);
		Thread.sleep(2000);
	}
	public void Continiue_btn() throws InterruptedException {
		conti.click();
		Thread.sleep(3000);
	}
	public void Finish_btn() {
		fin.click();
	}
	

}
