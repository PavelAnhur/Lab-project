package com.epam.retry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTestCases implements IRetryAnalyzer {
    private static final Logger LOGGER = LogManager.getRootLogger();
    private int retryCount = 0;
    private final int maxRetryCount = 2;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (retryCount < maxRetryCount) {
            LOGGER.info("Retrying {} and the count is {}", iTestResult.getName(), retryCount + 1);
            retryCount++;
            return true;
        }
        return false;
    }
}
