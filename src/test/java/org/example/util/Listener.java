package org.example.util;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

import java.sql.SQLOutput;

public class Listener implements ITestListener {

    public void onTestSuccess(ITestResult iTestResult){
        System.out.println("Победа!");
    }

    public void onTestFailure(ITestResult iTestResult){
        System.out.println("Не победа(");
    }

}
