package com.mfino.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;

public class Readdatafromdb {

	@BeforeMethod
	public void setUp() throws Exception {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeportal", "root", "root");
			Statement stmt = con.createStatement();
			System.out.println("DB");
			ResultSet rs = stmt.executeQuery("select name, dept from employeeinfo where id='281'");
			System.out.println("DB ");
			 ArrayList<String> sqlData = new ArrayList<String>(); 

			while (rs.next()) {
				System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
			//	   sqlData.add(name= rs.getString("firstName"));
				//   sqlData.add(dept = rs.getString("lastName")); 
				   break;
				 
			}
			con.close();
			System.out.println("Connection closed ");
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
    public static void main(String[] args) {
   	 WebDriver dr;

		System.out.println("launching chrome ");
		System.setProperty("webdriver.chrome.driver","FilesSelenium//chromedriver.exe");
		dr= new ChromeDriver();
		 ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("disable-infobars");
		dr.get("http://172.16.2.94:8090/web/brac/login.do");
		System.out.println("hitted the URL");
		dr.findElement(By.id("mfs-login-id"));
		
		
		
		
		
	}
}
