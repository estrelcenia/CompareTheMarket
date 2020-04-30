package com.comparethemarket.ExtentReports;

import java.util.Date;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ExtentListners implements ITestListener {

	ExtentManager extentManager;
	static Date d = new Date();
	static String fileName = "ExtentReport_" + d.toString().replace(":", "_").toString();
	private static ExtentReports extent = ExtentManager.createInstance(fileName);
	public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();
	public ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {

		ExtentTest test = extent
				.createTest(result.getTestClass().getName() + "   @TestCase : " + result.getMethod().getMethodName());
		testReport.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		String logText = "<b>" + "TEST CASE: - " + methodName.toUpperCase() + "  PASSED" + "<b>";
		Markup markUp = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		// test.pass(markUp);
		testReport.get().pass(markUp);

	}

	@Override
	public void onTestFailure(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		String logText = "<b>" + "TEST CASE: - " + methodName.toUpperCase() + "  FAIL" + "<b>";
		Markup markUp = MarkupHelper.createLabel(logText, ExtentColor.RED);

		testReport.get().fail(markUp);

	}

	@Override
	public void onTestSkipped(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		String logText = "<b>" + "TEST CASE: - " + methodName.toUpperCase() + "  SKIPPED" + "<b>";
		Markup markUp = MarkupHelper.createLabel(logText, ExtentColor.ORANGE);
		testReport.get().skip(markUp);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {

		if (extent != null) {
			extent.flush();
		}
	}

}
