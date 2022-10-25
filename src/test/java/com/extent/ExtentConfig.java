package com.extent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentConfig {
	public static ExtentReports extent =null;
	public static ExtentTest eTest = null;
	public static ExtentHtmlReporter htmlReport =null;

	public void extentInitialize() throws IOException {
		String reportDir=System.getProperty("user.dir")+"/target";
		Files.createDirectories(Paths.get(reportDir));
		htmlReport =new ExtentHtmlReporter(reportDir+ "/extentReport.html");
		htmlReport.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReport.config().setChartVisibilityOnOpen(true);
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setDocumentTitle("Title");
		htmlReport.config().setEncoding("utf-8");
		htmlReport.config().setReportName("Title");
		
		extent =new ExtentReports();
		extent.attachReporter(htmlReport);
		extent.setSystemInfo("OS","Windows 7");
		extent.setSystemInfo("Host Name","Harun");
		extent.setSystemInfo("Environment","QA");
		extent.setSystemInfo("Report Name","Title");
	}
	
	public void TestInitialize(String testcase) {
		eTest=extent.createTest(testcase);
	}
	
	public void updateToReport() {
		extent.flush();
	}
	
	public void updateReport(Status status) {
		if(status.equals(Status.FAIL))
			eTest.fail("Test Failed");
		else if(status.equals(Status.PASS))
			eTest.pass("Test Passed");
		else if(status.equals(Status.SKIP))
			eTest.skip("Test Skipped");
	}
}
