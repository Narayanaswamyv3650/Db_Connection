package com.mfno.ns;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class ScreenShot {
WebDriver dr=null;	

	@Test
	public void Screenshot() throws InterruptedException, IOException {
		System.out.println("launching chrome ");
		System.setProperty("webdriver.chrome.driver", "FilesSelenium//chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));
		dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.get("https://www.softwaretestinghelp.com");
		Thread.sleep(3000);
		File file=((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("./FilesSelenium/Screen.png"));

	}
}
