package com.mfno.ns;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Testing1 {
	
    public static void main(String[] args) {
    	 WebDriver dr;

		System.out.println("launching chrome ");
		System.setProperty("webdriver.chrome.driver","FilesSelenium//chromedriver.exe");
		dr= new ChromeDriver();
		 ChromeOptions options = new ChromeOptions();
         options.addArguments("headless");
         options.addArguments("disable-infobars");
		dr.get("https://artoftesting.com/");
		System.out.println("hitted the URL");
	}

}
