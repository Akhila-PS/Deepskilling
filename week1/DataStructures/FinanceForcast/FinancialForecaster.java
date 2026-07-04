// FinancialForecaster.java
public class FinancialForecaster {

    /**
     * Recursively predicts the future value of an investment/metric
     * given an annual growth rate, using the compound growth formula:
     * FV = PV * (1 + r)^n
     */
    public static double predictFutureValue(double presentValue, double growthRate, int years) {
        // Base case: no more years to grow
        if (years == 0) {
            return presentValue;
        }
        // Recursive case: grow one year, then recurse on the remainder
        double nextYearValue = presentValue * (1 + growthRate);
        return predictFutureValue(nextYearValue, growthRate, years - 1);
    }

    // Optimized closed-form version - avoids recursion entirely
    public static double predictFutureValueOptimized(double presentValue, double growthRate, int years) {
        return presentValue * Math.pow(1 + growthRate, years);
    }

    public static void main(String[] args) {
        double presentValue = 10000.0; // current revenue/investment
        double growthRate = 0.08;      // 8% annual growth
        int years = 10;

        double futureValue = predictFutureValue(presentValue, growthRate, years);
        System.out.printf("Projected value after %d years: $%.2f%n", years, futureValue);
    }
}