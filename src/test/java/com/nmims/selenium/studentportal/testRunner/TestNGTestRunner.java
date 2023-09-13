package com.nmims.selenium.studentportal.testRunner;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.collections.Lists;
import javax.swing.*;
import java.util.List;

public class TestNGTestRunner implements Runnable {
    private String suitePath;
    private JTextArea outputArea;

    public void setSuitePath(String suitePath) {
        this.suitePath = suitePath;
    }

    public void setOutputArea(JTextArea outputArea) {
        this.outputArea = outputArea;
    }

    @Override
    public void run() {
        TestNG testNG = new TestNG();
        List<String> suites = Lists.newArrayList();
        suites.add(suitePath);
        testNG.setTestSuites(suites);

        TestListenerAdapter listener = new TestListenerAdapter();
        testNG.addListener(listener);

        testNG.run();

        // Process and display test results in the output area
        // You can enhance this part to provide more advanced reporting
        // For simplicity, we're just displaying test counts here
        int totalTests = listener.getPassedTests().size() + listener.getFailedTests().size() + listener.getSkippedTests().size();
        outputArea.append("Total Tests: " + totalTests + "\n");
        outputArea.append("Passed Tests: " + listener.getPassedTests().size() + "\n");
        outputArea.append("Failed Tests: " + listener.getFailedTests().size() + "\n");
        outputArea.append("Skipped Tests: " + listener.getSkippedTests().size() + "\n");
    }
}
