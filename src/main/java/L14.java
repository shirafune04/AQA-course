import java.util.Arrays;

public class L14 {
    public static int[] createArray (int len, int initialValue) {
        int [] array = new int[len];
        Arrays.fill(array, initialValue);
        return array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(createArray(1, -4)));
        System.out.println(Arrays.toString(createArray(7, 5)));
        System.out.println(Arrays.toString(createArray(5, 15)));
    }
}
