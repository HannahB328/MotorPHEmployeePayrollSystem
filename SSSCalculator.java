package utils;

/**
 * Utility class responsible for calculating SSS contributions.
 * Adheres to OOP principles by encapsulating the SSS calculation logic.
 * Provides an SSS contribution amount based on the given salary.
 */
public class SSSCalculator {

    /**
     * Computes the SSS contribution amount based on the employee's salary.
     *
     * @param salary The employee's gross monthly salary.
     * @return The calculated SSS contribution amount.
     */
    public static double getSSSContribution(double salary) {
        // 2023 SSS Contribution Table
        if (salary < 4250) return 180.00;  // Minimum contribution
        if (salary <= 4749.99) return 202.50;
        if (salary <= 5249.99) return 225.00;
        if (salary <= 5749.99) return 247.50;
        if (salary <= 6249.99) return 270.00;
        if (salary <= 6749.99) return 292.50;
        if (salary <= 7249.99) return 315.00;
        if (salary <= 7749.99) return 337.50;
        if (salary <= 8249.99) return 360.00;
        if (salary <= 8749.99) return 382.50;
        if (salary <= 9249.99) return 405.00;
        if (salary <= 9749.99) return 427.50;
        if (salary <= 10249.99) return 450.00;
        if (salary <= 10749.99) return 472.50;
        if (salary <= 11249.99) return 495.00;
        if (salary <= 11749.99) return 517.50;
        if (salary <= 12249.99) return 540.00;
        if (salary <= 12749.99) return 562.50;
        if (salary <= 13249.99) return 585.00;
        if (salary <= 13749.99) return 607.50;
        if (salary <= 142
