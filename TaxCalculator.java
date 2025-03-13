package utils;

/**
 * Utility class responsible for calculating withholding tax.
 * Adheres to OOP principles by encapsulating the tax calculation logic.
 * Provides accurate computation of withholding tax based on taxable income.
 */
public class TaxCalculator {

    /**
     * Computes the withholding tax amount based on the employee's taxable income.
     *
     * @param taxableIncome The taxable income of the employee.
     * @return The calculated withholding tax amount.
     */
    public static double computeWithholdingTax(double taxableIncome) {
        // 2023 Tax Table based on the Philippine Tax Reform for Acceleration and Inclusion (TRAIN) Law
        if (taxableIncome <= 20832) return 0.0;
        
