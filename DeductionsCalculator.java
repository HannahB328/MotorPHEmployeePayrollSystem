package utils;

/**
 * Utility class for calculating various mandatory deductions.
 * This class adheres to OOP principles by encapsulating deduction calculation logic.
 * The supported deductions include Pag-IBIG, PhilHealth, SSS, and tax.
 */
public class DeductionsCalculator {

    /**
     * Calculates the Pag-IBIG contribution based on the gross salary.
     * The maximum contribution is capped at PHP 100.
     * @param grossSalary The gross salary of the employee.
     * @return The computed Pag-IBIG contribution.
     */
    public static double calculatePagIbig(double grossSalary) {
        return Math.min(grossSalary * 0.03, 100);
    }

    /**
     * Calculates the PhilHealth contribution by utilizing the PhilHealthCalculator.
     * @param grossSalary The gross salary of the employee.
     * @return The computed PhilHealth contribution.
     */
    public static double calculatePhilHealth(double grossSalary) {
        return PhilHealthCalculator.getPhilHealthContribution(grossSalary);
    }

    /**
     * Calculates the SSS contribution by utilizing the SSSCalculator.
     * @param grossSalary The gross salary of the employee.
     * @return The computed SSS contribution.
     */
    public static double calculateSSS(double grossSalary) {
        return SSSCalculator.getSSSContribution(grossSalary);
    }

    /**
     * Calculates the withholding tax by utilizing the TaxCalculator.
     * @param taxableIncome The taxable income of the employee.
     * @return The computed withholding tax.
     */
    public static double calculateTax(double taxableIncome) {
        return TaxCalculator.computeWithholdingTax(taxableIncome);
    }
}

