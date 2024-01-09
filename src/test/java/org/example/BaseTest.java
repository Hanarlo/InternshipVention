package org.example;

import org.example.util.Listener;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

@Listeners(Listener.class)
public class BaseTest{

    Calculator calculator;
    @BeforeSuite
    @BeforeGroups(groups = {"regression", "smoke"})
    public void prepare(){
        calculator = new Calculator();
        System.out.println("prepare");
    }
}
