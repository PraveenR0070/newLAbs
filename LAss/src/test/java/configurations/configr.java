package configurations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class configr {
	Properties pro;
	
	public configr()  {
		File file = new  File("./Configartions/config.Properties");
		try {
		
		FileInputStream fis = new FileInputStream(file);
		 pro = new Properties();
		pro.load(fis);
		}
		catch(Exception exp) { 
			System.out.println("exception is " + exp.getMessage());
			}	
		}
	public String getURL() {
		String url=pro.getProperty("BaseURL");
		return url;
	}
	public String getName() {
		String uname=pro.getProperty("Username");
		return uname;
	}
	public String getpass() {
		String Password=pro.getProperty("Passw");
		return Password;
	}
	public String getbroswer() {
		String Broswer=pro.getProperty("broswer");
		return Broswer;
	}


}
