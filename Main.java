package main;

import service.PayrollSystem;
import model.Employee;
import service.PayrollProcessor;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import com.opencsv.exceptions.CsvException;

/**
 * Main class for the MotorPHPayrollSystem application.
 * Handles employee data loading and payroll processing.
 */
public class Main {

    /**
     * Entry point of the MotorPHPayrollSystem application.
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();
        PayrollProcessor payrollProcessor = new PayrollProcessor();

        try {
            // Load employee data from CSV file
            payrollSystem.loadEmployeeData("src/data/employee_data.csv");

            // Display loaded employees
            payrollSystem.displayEmployees();

            // Retrieve employee list
            List<Employee> employeeList = payrollSystem.getEmployees();
            if (employeeList.isEmpty()) {
                System.out.println("⚠ No employees found. Exiting payroll processing.");
                return;
            }

            // Process payroll for each employee
            try (Scanner scanner = new Scanner(System.in)) {
                for (Employee emp : employeeList) {
                    if (emp == null) continue; // Skip null entries

                    System.out.println("\nProcessing Payroll for: " + emp.getFullName());
                    System.out.println("======================================");
                    System.out.println(emp); // Display complete employee details

                    double hoursWorked = payrollProcessor.getHoursWorked(scanner, emp);
                    payrollProcessor.processPayroll(emp, hoursWorked);
                }
            }
        } catch (IOException | CsvException e) {
            System.err.println("❌ Error loading employee data: " + e.getMessage());
        }
    }
}
