package com.nmims.selenium.studentportal.testRunner;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.collections.Lists;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TestRunner {
    private JFrame frame;
    private JTextField suitePathField;
    private JButton runButton;
    private JTextArea outputTextArea;

    public TestRunner() {
        frame = new JFrame("TestNG Test Runner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        suitePathField = new JTextField();
        runButton = new JButton("Run Tests");
        outputTextArea = new JTextArea();

        inputPanel.add(new JLabel("C:\\Users\\amit.yadav.EXT\\git\\selenium-studentportal\\TestNG.xml"));
        inputPanel.add(suitePathField);
        inputPanel.add(new JLabel(""));
        inputPanel.add(runButton);

        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(inputPanel, BorderLayout.NORTH);
        frame.getContentPane().add(new JScrollPane(outputTextArea), BorderLayout.CENTER);

        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runTests();
            }
        });
    }

    private void runTests() {
        String suitePath = suitePathField.getText();

        if (suitePath.isEmpty()) {
            outputTextArea.setText("Please provide a valid TestNG XML suite file.");
            return;
        }

        TestNG testNG = new TestNG();
        List<String> suites = Lists.newArrayList();
        suites.add(suitePath);
        testNG.setTestSuites(suites);

        TestListenerAdapter listener = new TestListenerAdapter();
        testNG.addListener(listener);

        testNG.run();
        int totalTests = listener.getPassedTests().size() + listener.getFailedTests().size() + listener.getSkippedTests().size();

       // int totalTests = listener.getTotalTests();
        int passedTests = totalTests - listener.getFailedTests().size();

        outputTextArea.setText("Total Tests: " + totalTests + "\n");
        outputTextArea.append("Passed Tests: " + passedTests + "\n");
        outputTextArea.append("Failed Tests: " + listener.getFailedTests().size() + "\n");
        outputTextArea.append("Skipped Tests: " + listener.getSkippedTests().size() + "\n");
        outputTextArea.append("\nTest Results:\n" + listener.getFailedTests());
    }

    public void display() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                TestRunner testRunner = new TestRunner();
                testRunner.display();
            }
        });
    }
}
