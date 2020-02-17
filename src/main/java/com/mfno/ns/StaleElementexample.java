package com.mfno.ns;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class StaleElementexample {
	WebDriver dr;

	@BeforeTest
	public void setup() throws Exception {

		System.out.println("launching chrome ");
		System.setProperty("webdriver.chrome.driver", "FilesSelenium//chromedriver.exe");
		dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		dr.get("http://www.github.com");
	}

	@Test
	public void getExe() throws InterruptedException {
		WebElement Search_box = dr.findElement(By.xpath("//input[@name='q']"));
		Search_box.sendKeys("Narayana");
		Search_box.sendKeys(Keys.ENTER);
		Search_box.clear();

	}
}
