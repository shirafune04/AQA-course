public class FactorialCalculator {
    public long calculateFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException(
                    "Факториал отрицательного числа не определён: " + n);
        }

        if (n == 0) {
            return 1;
        }

        long result = 1;
        for (int i = 1; i <= n; i++) {
            if (result > Long.MAX_VALUE / i) {
                throw new ArithmeticException("Переполнение при вычислении факториала " + n);
            }
            result *= i;
        }

        return result;
    }
}
