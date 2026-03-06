public class TriangleAreaCalculator {

    public double calculateArea(double base, double height) {
        if (base <= 0 || height <= 0) {
            throw new IllegalArgumentException(
                    "Основание и высота должны быть положительными: " +
                            "base=" + base + ", height=" + height
            );
        }
        return (base * height) / 2;
    }
}