package com.mfino.connection;

import java.sql.ResultSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class parallel {
	@Test
	public void executSessionOne() throws InterruptedException {
		// First session of WebDriver
		for (int i = 0; i < 1; i++) {
			System.setProperty("webdriver.chrome.driver", "FilesSelenium//chromedriver.exe");
			WebDriver dr = new ChromeDriver();
			dr.manage().window().maximize();
			DBconnection db = new DBconnection();
			dr.get("http://172.16.3.51:8090/web/bok/login.do");
			// find user name text box and fill it
			
			dr.findElement(By.xpath("//input[@id='mfs-login-id']")).sendKeys("bokadmin");
			dr.findElement(By.xpath("//input[@id='mfs-login-password']")).sendKeys("123456");
			dr.findElement(By.xpath("//button[@name='submit']")).click();
			Thread.sleep(5000);
			dr.findElement(By.xpath("//span[contains(text(),'Operations')]")).click();		
			//dr.findElement(By.xpath("//*[@id=\"nav\"]/li[2]/ul/li[1]/a/span")).click();
			dr.findElement(By.xpath("//span[contains(text(),'Persona Management')]")).click();
			dr.findElement(By.xpath("//span[contains(text(),'Subscribers')]")).click();

			Thread.sleep(2000);
			dr.findElement(By.xpath("//span[@class='ng-binding ng-scope'] and //span[//span[contains(text(), 'Subscribers')]")).click();
			dr.findElement(By.xpath("//button[@aria-label='Create']")).click();
			dr.findElement(By.xpath("//md-radio-button[@aria-label='Retail Subscriber']")).click();
			dr.findElement(By.xpath("//md-radio-button[@aria-label=\"Quick Registration\"]")).click();
			// now onwords getting data form DB
			try {
				ResultSet testData = db.data("", "");
				// for (int i = 1; i <= 2; i++)
				do {
					String name = testData.getString(1);
					String dept = testData.getString(2);
					dr.findElement(By.id("//input[@name='firstName']")).clear();
					dr.findElement(By.id("//input[@name='firstName")).sendKeys(name);
					dr.findElement(By.xpath("//input[@name='lastName']")).sendKeys(dept);
					dr.findElement(By.name("submit")).click();
					System.out.println("Entred first name  -- " + name);
					System.out.println("entred last name: " + dept);
					/*
					 * Thread.sleep(3000); dr.navigate().back(); Thread.sleep(3000);
					 */// break;
				} while (testData.next());

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
}
