package com.nmims.selenium.studentportal.testRunner;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestRunnerGUIfIRSTcODE {
    private JFrame frame;
    private JTextField suitePathField;
    private JTextArea outputTextArea;
    private TestNGTestRunner testRunner;

    public TestRunnerGUIfIRSTcODE() {
        frame = new JFrame("Test Runner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        suitePathField = new JTextField();
        JButton runButton = new JButton("Run Tests");
        outputTextArea = new JTextArea();
        testRunner = new TestNGTestRunner();

        inputPanel.add(new JLabel("Test Suite Path:"));
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

        outputTextArea.setText(""); // Clear previous output

        // Delegate test execution to the TestNGTestRunner class
        testRunner.setSuitePath(suitePath);
        testRunner.setOutputArea(outputTextArea);

        Thread testThread = new Thread(testRunner);
        testThread.start();
    }

    public void display() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                TestRunnerGUIfIRSTcODE  testRunner = new TestRunnerGUIfIRSTcODE();
                testRunner.display();
            }
        });
    }
}
