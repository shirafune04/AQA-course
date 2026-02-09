public class L3 {
    public static void printColor() {
        int value = -1;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Жёлтый");
        } else {
            System.out.println("Зелёный");
        }
    }
    public static void main(String[] args) {
        printColor();
    }
}

