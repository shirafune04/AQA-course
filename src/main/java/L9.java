public class L9 {
    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else if (year % 4 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isLeapYear(2000));
        System.out.println(isLeapYear(2005));
        System.out.println(isLeapYear(2008));
        System.out.println(isLeapYear(2023));
        System.out.println(isLeapYear(2012));
    }
}

