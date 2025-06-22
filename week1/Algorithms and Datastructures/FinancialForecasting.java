import java.util.Scanner;

public class FinancialForecasting {

    // Recursive method to calculate future value
    public static double forecast(double presentValue, double rate, int years) {
        if (years == 0) {
            return presentValue;
        } else {
            return (1 + rate) * forecast(presentValue, rate, years - 1);
        }
    }

    // Optimized version using memoization (optional)
    public static double forecastMemo(double presentValue, double rate, int years, Double[] memo) {
        if (years == 0) return presentValue;
        if (memo[years] != null) return memo[years];
        memo[years] = (1 + rate) * forecastMemo(presentValue, rate, years - 1, memo);
        return memo[years];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter present value: ");
        double presentValue = sc.nextDouble();

        System.out.print("Enter annual growth rate (e.g., 0.05 for 5%): ");
        double rate = sc.nextDouble();

        System.out.print("Enter number of years to forecast: ");
        int years = sc.nextInt();

        // Simple recursive result
        double result = forecast(presentValue, rate, years);
        System.out.printf("Forecasted value after %d years (recursive): ₹%.2f%n", years, result);

        // Optional: Memoized version to improve performance
        Double[] memo = new Double[years + 1];
        double optimized = forecastMemo(presentValue, rate, years, memo);
        System.out.printf("Forecasted value after %d years (optimized): ₹%.2f%n", years, optimized);

        sc.close();
    }
}

Output:
Enter present value: 12000
Enter annual growth rate (e.g., 0.05 for 5%): 0.10
Enter number of years to forecast: 4
Forecasted value after 4 years (recursive): ₹17569.20
Forecasted value after 4 years (optimized): ₹17569.20
