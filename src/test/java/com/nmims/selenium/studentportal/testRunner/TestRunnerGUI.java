package com.nmims.selenium.studentportal.testRunner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class TestRunnerGUI {
    private JFrame frame;
    private JComboBox<String> suiteComboBox;
    private JComboBox<String> testCaseComboBox; // Added JComboBox for test cases
    private JButton runButton;
    private JTextArea outputTextArea;

    public TestRunnerGUI() {
        frame = new JFrame("TestNG Test Runner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel inputPanel = new JPanel(new GridLayout(3, 2));

        suiteComboBox = new JComboBox<String>();
        testCaseComboBox = new JComboBox<String>(); // Create the JComboBox for selecting test cases
        runButton = new JButton("Run Tests");
        outputTextArea = new JTextArea();

        inputPanel.add(new JLabel("Select Test Suite:"));
        inputPanel.add(suiteComboBox);
        inputPanel.add(new JLabel("Select Test Case:")); // Label for test cases
        inputPanel.add(testCaseComboBox); // Add the JComboBox for test cases
        inputPanel.add(new JLabel(""));
        inputPanel.add(runButton);

        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(inputPanel, BorderLayout.NORTH);
        frame.getContentPane().add(new JScrollPane(outputTextArea), BorderLayout.CENTER);

        // Populate the dropdowns with available TestNG suite files and test cases
        populateSuiteDropdown();
        suiteComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                populateTestCaseDropdown();
            }
        });

        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runTests();
            }
        });
    }

    private void populateSuiteDropdown() {
        // Specify the directory where your TestNG suite files are located
        File suiteDirectory = new File("path/to/test/suites");

        if (suiteDirectory.isDirectory()) {
            // List all XML files in the specified directory
            File[] suiteFiles = suiteDirectory.listFiles((dir, name) -> name.endsWith(".xml"));

            if (suiteFiles != null) {
                for (File suiteFile : suiteFiles) {
                    suiteComboBox.addItem(suiteFile.getName());
                }
            }
        }
    }

    private void populateTestCaseDropdown() {
        String selectedSuite = (String) suiteComboBox.getSelectedItem();
        if (selectedSuite != null && !selectedSuite.isEmpty()) {
            // Clear existing items in the test case dropdown
            testCaseComboBox.removeAllItems();

            // Load the selected suite file to extract test case names
            File suiteFile = new File("path/to/test/suites/" + selectedSuite);

            if (suiteFile.exists()) {
                XmlSuite xmlSuite = new XmlSuite();
                xmlSuite.load(suiteFile.getAbsolutePath());

                for (XmlTest xmlTest : xmlSuite.getTests()) {
                    testCaseComboBox.addItem(xmlTest.getName());
                }
            }
        }
    }

    private void runTests() {
        String selectedSuite = (String) suiteComboBox.getSelectedItem();
        String selectedTestCase = (String) testCaseComboBox.getSelectedItem();

        if (selectedSuite == null || selectedSuite.isEmpty()) {
            outputTextArea.setText("Please select a TestNG XML suite file.");
            return;
        }

        if (selectedTestCase == null || selectedTestCase.isEmpty()) {
            outputTextArea.setText("Please select a TestNG test case.");
            return;
        }

        // Add your code here to execute the selected TestNG test case
        // You should replace this with the actual TestNG test execution logic

        // For demonstration purposes, we'll display a message
        outputTextArea.setText("Test Case '" + selectedTestCase + "' from suite '" + selectedSuite + "' is running...");
    }

    public void display() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                TestRunnerGUI testRunner = new TestRunnerGUI();
                testRunner.display();
            }
        });
    }
}
