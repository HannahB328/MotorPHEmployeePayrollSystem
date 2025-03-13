package service;

import model.Employee;
import utils.PayslipGenerator;
import utils.SSSCalculator;
import utils.PhilHealthCalculator;
import utils.TaxCalculator;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * PayrollSystem class handles the loading, processing, and displaying of payroll data.
 * It leverages utility classes and follows good coding practices.
 */
public class PayrollSystem {
    private static final Logger LOGGER = Logger.getLogger(PayrollSystem.class.getName());
    private final List<Employee> employees = new ArrayList<>();
    private final PayrollCalculator payrollCalculator = new PayrollCalculator();

    /**
     * Loads employee data from a CSV file.
     * @param filePath Path to the CSV file containing employee data
     * @throws IOException if file reading fails
     * @throws CsvException if CSV parsing fails
     */
    public void loadEmployeeData(String filePath) throws IOException, CsvException {
        try (
            InputStreamReader fileReader = new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8);
            CSVReader reader = new CSVReader(fileReader)
        ) {
            String[] line;
            boolean firstLine = true;
            while ((line = reader.readNext()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                if (line.length < 19) {
                    LOGGER.log(Level.WARNING, "⚠ Invalid data format (Columns found: {0}): {1}", 
                        new Object[]{line.length, String.join("|", line)});
                    continue;
                }

                try {
                    String employeeNumber = line[0].trim();
                    String lastName = line[1].trim();
                    String firstName = line[2].trim();
                    String birthDate = line[3].trim();
                    String address = line[4].trim();
                    String contactNumber = line[5].trim();
                    String tinNumber = line[6].trim();
                    String sssNumber = line[7].trim();
                    String philHealthNumber = line[8].trim();
                    String pagIbigNumber = line[9].trim();
                    String employmentStatus = line[10].trim();
                    String position = line[11].trim();
                    String supervisor = line[12].trim();

                    double basicSalary = parseDouble(line[13].trim());
                    double riceSubsidy = parseDouble(line[14].trim());
                    double phoneAllowance = parseDouble(line[15].trim());
                    double clothingAllowance = parseDouble(line[16].trim());

                    employees.add(new Employee(employeeNumber, lastName, firstName, birthDate, address, contactNumber,
                        tinNumber, sssNumber, philHealthNumber, pagIbigNumber, employmentStatus, position, supervisor,
                        basicSalary, riceSubsidy, phoneAllowance, clothingAllowance));

                } catch (NumberFormatException e) {
                    LOGGER.log(Level.WARNING, "⚠ Error parsing numeric fields in line: {0}", String.join("|", line));
                }
            }
            System.out.println("✅ Employee data loaded successfully.");
        } catch (IOException | CsvException e) {
            LOGGER.log(Level.SEVERE, "❌ Error loading employee data: {0}", e.getMessage());
            throw e;
        }
    }

    /**
     * Parses a string to a double while handling formatting issues.
     * @param value The string to parse
     * @return Parsed double value or 0.0 if parsing fails
     */
    private double parseDouble(String value) {
        try {
            String cleanedValue = value.replace(",", "").trim();
            return Double.parseDouble(cleanedValue);
        } catch (NumberFormatException e) {
            LOGGER.log(Level.WARNING, "⚠ Error parsing numeric value: {0}", value);
            return 0.0;
        }
    }

    /**
     * Retrieves the list of employees.
     * @return List of employees
     */
    public List<Employee> getEmployees() {
        return employees;
    }

    /**
     * Displays the list of employees with basic salary information.
     */
    public void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("⚠ No employee data found.");
            return;
        }

        System.out.println("\n📋 Employee List:");
        System.out.println("-------------------------------------------------");
        for (Employee emp : employees) {
   
