package com.extent;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentDemo {
	static WebDriver driver =null;
	public static void main(String[] args) {

		ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter("extentreport.html");
		htmlReporter.loadXMLConfig(new File("src/test/resources/Extent-Config.xml"));
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
	    ExtentTest test=extent.createTest("Google search", "Validating google search");
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		test.pass("Opens Chrome");
		driver.get("http://www.google.com");
		test.pass("Google home page opened");
		driver.findElement(By.name("q")).sendKeys("Apple",Keys.ENTER);
		test.pass("searched an item");

		driver.close();
		driver.quit();
		extent.flush();

	}

}
