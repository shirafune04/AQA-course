public class L7{
    public static boolean checkNumber(int number) {
        return number < 0;
    }

    public static void main(String[] args) {
        System.out.println(checkNumber(0));
        System.out.println(checkNumber(-5));
        System.out.println(checkNumber(1));
        System.out.println(checkNumber(-10));
    }
}