package testCases;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class RetryAnalyzer implements IRetryAnalyzer {
	int counter = 0;
	int retryLimit = 2;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(counter < retryLimit) {
			counter++;
			return true;
		}
		return false;
	}

}
