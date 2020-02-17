package com.mfino.connection;

import static org.testng.Assert.assertThrows;
import java.sql.Array;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FacebookTest {
	@SuppressWarnings({ "static-access", "unchecked" })
	public static void main(String[] args) throws Exception {
		WebDriver dr;
		System.out.println("launching chrome ");
		System.setProperty("webdriver.chrome.driver", "FilesSelenium//chromedriver.exe");
		dr = new ChromeDriver();
		dr.manage().window().maximize();
		ChromeOptions options = new ChromeOptions();
		// ENTER URL
		DBconnection db = new DBconnection();
		dr.get("http://172.16.2.94:8090/web/brac/login.do");
		dr.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+"t");
		dr.get("http://172.16.2.94:8090/web/brac/login.do");

		
		try {
			ResultSet testData = db.data("", "");
			// for (int i = 1; i <= 2; i++)
			do {
				String name = testData.getString(1);
				String dept = testData.getString(2);
				dr.findElement(By.id("mfs-login-id")).clear();
				dr.findElement(By.id("mfs-login-id")).sendKeys(name);
				dr.findElement(By.xpath("//input[@id='mfs-login-password']")).sendKeys(dept);
				dr.findElement(By.name("submit")).click();
				System.out.println("Login with  -- " + name);
				Thread.sleep(3000);
				dr.navigate().back();
				Thread.sleep(3000);
				// break;
			} while (testData.next());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// dr.quit();
		}
	}
}