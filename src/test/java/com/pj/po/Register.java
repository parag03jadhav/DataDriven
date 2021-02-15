package com.pj.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;

public class Register {
	public static WebDriver driver;
	
	  @FindBy(xpath="//button[@class='modal-module_close-button_asjao']")
	  
	  WebElement Close;
	 
	@FindBy(linkText="Register")
	WebElement register;
	
	@FindBy(id="firstname")
	
	WebElement name;
	
	@FindBy(id="surname")
	WebElement lname;
	
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="email2")
	WebElement e2;

	@FindBy(id="password")
	WebElement password;

	@FindBy(id="password2")
	WebElement password2;
	
	@FindBy(id="telno1")
	WebElement mobile;
	
	@FindBy(id="day")
	WebElement day;
	
	@FindBy(id="month")
	WebElement month;
	
	@FindBy(id="year")
	WebElement year;

	@FindBy(id="newsletter_daily-deals")
	WebElement r1;
	
	@FindBy(name="registerButton")
	WebElement re;
	
     
	 public  void RegAction(String userN,String userL,String mail,String e3,String pass1,String pass2,String mob,String d,String m,String y) throws InterruptedException {
		 
		// Thread.sleep(2000);
		/*
		 * if( Close.isEnabled()) { Close.click(); }
		 */
		
		
		Thread.sleep(2000);
		register.click();
		name.sendKeys(userN);
		lname.sendKeys(userL);
		email.sendKeys(mail);
		e2.sendKeys(e3);
		password.sendKeys(pass1);
		password2.sendKeys(pass2);
		mobile.sendKeys(mob);
		Select s=new Select(day);
		
		s.selectByValue(d);
		
      Select s2=new Select(month);
		
		s2.selectByVisibleText(m);
		
      Select s3=new Select(year);
		
		s3.selectByValue(y);
		
		r1.click();
		re.click();
		
	}

			 
	
}
