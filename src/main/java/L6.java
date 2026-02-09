public class L6 {
    public static void checkNumber(int number) {
        if (number >= 0) {
            System.out.println("Число " + number + " положительное");
        } else {
            System.out.println("Число " + number + " отрицательное");
        }
    }

    public static void main(String[] args) {
        checkNumber(0);
        checkNumber(-5);
        checkNumber(10);
        checkNumber(3);
        checkNumber(-20);
    }
}
