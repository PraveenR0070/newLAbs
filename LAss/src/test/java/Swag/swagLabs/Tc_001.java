package Swag.swagLabs;

import java.io.FileNotFoundException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;


import PagesForSwag.CheckoutPagee;
import PagesForSwag.Home_Page;
import PagesForSwag.LoginPageee;
import Praveen.PageObjects.LoginPage;
import configurations.BaseClassForSwag;

public class Tc_001 extends BaseClassForSwag{
	
	
	
	@Test
	public void RunTest() throws InterruptedException, FileNotFoundException {
		LoginPageee lp= broswer_initil();
		logger.info("Enter uname and Password");
		Home_Page hm = lp.loginPage(Username,Passw);
	
		CheckoutPagee cp=hm.Shipping();
		
		
		
	}

}
