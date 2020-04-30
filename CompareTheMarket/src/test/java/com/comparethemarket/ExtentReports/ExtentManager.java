package com.comparethemarket.ExtentReports;
	

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	public String screenshotName;

	public static ExtentReports createInstance(String fileName)
	{
		String finalFilePath=fileName+".html";
		String filePath =System.getProperty("user.dir")+"\\ExtentReports\\"+finalFilePath+"";
		ExtentHtmlReporter htmlReporter= new ExtentHtmlReporter(filePath);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("iForce Automation Report");
		htmlReporter.config().setReportName("Automation report name");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		extent= new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("Automation tester", "tester1");
		extent.setSystemInfo("Organization", "iforce");
		return extent;
		
	}
	
	
	
}
