public class L8 {
    public static void printStringMultipleTimes(String text, int times) {
        for (int i = 1; i <= times; i++) {
            System.out.println(text);
        }
    }

    public static void main(String[] args) {
        printStringMultipleTimes("Hello",5);
        printStringMultipleTimes("Java",1);
        printStringMultipleTimes("Meow",0);

    }
}
