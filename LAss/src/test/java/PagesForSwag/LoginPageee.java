package PagesForSwag;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageee {
	WebDriver driver;
	
	public LoginPageee(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	@FindBy (xpath="//input[@id='user-name']")
	WebElement uname;
	@FindBy (xpath="//input[@id='password']")
	WebElement pass;
	@FindBy (xpath="//input[@id='login-button']")
	WebElement submit;
	
	public Home_Page loginPage(String Uname,String Pass) throws InterruptedException {
		uname.sendKeys(Uname);
		pass.sendKeys(Pass);
		submit.click();
		
		Home_Page hm = new Home_Page(driver);
		hm.getproductlist();
		hm.Shipping();
		return hm;
		
		//driver.switchTo().alert().accept();
	}

}
