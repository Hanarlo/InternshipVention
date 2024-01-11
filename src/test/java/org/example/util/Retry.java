package org.example.util;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.internal.TestResult;

public class Retry implements IRetryAnalyzer {

    private int attempt = 1;
    private static final int MAX_ATTEMPT = 5;
    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()){
            if (attempt < MAX_ATTEMPT){
                attempt++;
                System.out.println("attempt num " + attempt + "failed, restart...");
                return true;
            } else{
                System.out.println("limit!");
            }
        }
        return false;
    }
}
