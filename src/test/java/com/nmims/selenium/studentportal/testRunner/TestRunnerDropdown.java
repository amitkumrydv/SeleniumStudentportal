package com.nmims.selenium.studentportal.testRunner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TestRunnerDropdown {
    private JFrame frame;
    private JComboBox<String> suiteComboBox;
    private JButton runButton;
    private JTextArea outputTextArea;

    public TestRunnerDropdown() {
        frame = new JFrame("TestNG Test Runner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        suiteComboBox = new JComboBox<String>();
        runButton = new JButton("Run Tests");
        outputTextArea = new JTextArea();

        inputPanel.add(new JLabel("Select Test Suite:"));

        // Populate the combo box with available TestNG suite files
        populateSuiteComboBox();

        inputPanel.add(suiteComboBox);
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

    private void populateSuiteComboBox() {
        // Replace this with logic to fetch available TestNG suite files in a directory
        // For demonstration, we'll add a few sample suite file paths
        List<String> sampleSuites = new ArrayList<String>();
        sampleSuites.add("TestNG.xml");
        sampleSuites.add("TestNG2.xml");
        sampleSuites.add("TestNG3.xml");

        for (String suite : sampleSuites) {
            suiteComboBox.addItem(suite);
        }
    }

    private void runTests() {
        String selectedSuite = (String) suiteComboBox.getSelectedItem();

        if (selectedSuite == null || selectedSuite.isEmpty()) {
            outputTextArea.setText("Please select a TestNG XML suite file.");
            return;
        }

        // Add your code here to execute TestNG tests based on the selected suite
        // You should replace this with actual TestNG test execution logic

        // For demonstration purposes, we'll display a message
        outputTextArea.setText("Tests are running using suite: " + selectedSuite);
    }

    public void display() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	TestRunnerDropdown testRunner = new TestRunnerDropdown();
                testRunner.display();
            }
        });
    }
}
