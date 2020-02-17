package com.mfno.ns;

import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class iframes {
	WebDriver dr = null;

	@Test
	public void iframes() throws InterruptedException {
		System.out.println("launching chrome ");
		System.setProperty("webdriver.chrome.driver", "FilesSelenium//chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));
		dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.get("https://www.softwaretestinghelp.com");
		List<WebElement> elements = dr.findElements(By.tagName("iframe"));
		int numberoftags = elements.size();
		System.out.println("Number of tags " + numberoftags);
		for (int i = 0; i < elements.size(); i++) {
			System.out.println(elements.get(i).getTagName());
			// System.out.println(" List of names "+listofframes);

		}
	}
}
