public class L5 {
    public static boolean checkSumInRange(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    public static void main(String[] args) {
        System.out.println(checkSumInRange(5, 10));
        System.out.println(checkSumInRange(10, 20));
        System.out.println(checkSumInRange(2,8));
        System.out.println(checkSumInRange(10, 11));
    }
}

