package utils;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * DeductionsCalculator class calculates mandatory deductions.
 */
public class DeductionsCalculator {
    private static final Logger LOGGER = Logger.getLogger(DeductionsCalculator.class.getName());

    private static final double PAGIBIG_RATE = 0.02;
    private static final double PAGIBIG_CAP = 100.0;

    /**
     * Calculates the Pag-IBIG deduction based on the gross salary.
     * @param grossSalary Gross salary of the employee
     * @return Pag-IBIG deduction amount
     */
    public static double calculatePagIbig(double grossSalary) {
        double deduction = Math.min(grossSalary * PAGIBIG_RATE, PAGIBIG_CAP);
        LOGGER.log(Level.INFO, "Pag-IBIG deduction calculated: {0}", deduction);
        return deduction;
    }

    /**
     * Calculates the PhilHealth contribution based on the gross salary.
     * @param grossSalary Gross salary of the employee
     * @return PhilHealth contribution amount
     */
    public static double calculatePhilHealth(double grossSalary) {
        double deduction = PhilHealthCalculator.getPhilHealthContribution(grossSalary);
        LOGGER.log(Level.INFO, "PhilHealth deduction calculated: {0}", deduction);
        return deduction;
    }

    /**
     * Calculates the SSS contribution based on the gross salary.
     * @param grossSalary Gross salary of the employee
     * @return SSS contribution amount
     */
    public static double calculateSSS(double grossSalary) {
        double deduction = SSSCalculator.getSSSContribution(grossSalary);
        LOGGER.log(Level.INFO, "SSS deduction calculated: {0}", deduction);
        return deduction;
    }

    /**
     * Calculates the withholding tax based on the taxable income.
     * @param taxableIncome Taxable income of the employee
     * @return Withholding tax amount
     */
    public static double calculateTax(double taxableIncome) {
        double tax = TaxCalculator.computeWithholdingTax(taxableIncome);
        LOGGER.log(Level.INFO, "Withholding tax calculated: {0}", tax);
        return tax;
    }
}
