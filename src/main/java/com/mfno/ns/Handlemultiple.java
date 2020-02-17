package com.mfno.ns;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Handlemultiple {
	WebDriver dr = null;

	@Test
	public void testmWindows() throws InterruptedException {
		System.out.println("launching chrome ");
		System.setProperty("webdriver.chrome.driver", "FilesSelenium//chromedriver.exe");
		dr = new ChromeDriver();
		dr.get("http://www.naukri.com/");
		String mainwindow = dr.getWindowHandle();
		Set<String> set = dr.getWindowHandles();
		Iterator<String> itr = set.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next();
			// check whether main window and chaild windows are same
			if (!mainwindow.equals(childwindow)) {
				dr.switchTo().window(childwindow);
				System.out.println(dr.switchTo().window(childwindow).getTitle());
				dr.close();
				System.out.println("Child window has closed ");

			}
		}
		dr.switchTo().window(mainwindow);
		System.out.println("navigated to main window");
	}

}
