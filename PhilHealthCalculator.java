package utils;

/**
 * Utility class for calculating PhilHealth contributions.
 * This class encapsulates the calculation logic, following OOP principles.
 * The PhilHealth contribution rate is set to 3%, with the employee sharing half of the contribution.
 */
public class PhilHealthCalculator {
    /**
     * Calculates the PhilHealth contribution based on the given salary.
     * @param salary The gross salary of the employee.
     * @return The computed PhilHealth contribution (employee share).
     */
    public static double getPhilHealthContribution(double salary) {
        double contribution = (salary * 0.03) / 2; // 3% contribution, employee share is half
        return contribution; // Return the employee share
    }
}
