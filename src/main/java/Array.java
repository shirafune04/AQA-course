class MyArraySizeException extends Exception {
    public MyArraySizeException(String message) {
        super(message);
    }
}

class MyArrayDataException extends Exception {
    private int row;
    private int col;
    private String value;

    public MyArrayDataException(int row, int col, String value) {
        super("Ошибка в ячейке [" + row + "][" + col + "]: '" + value + "' не является числом");
        this.row = row;
        this.col = col;
        this.value = value;
    }
    public int getRow() { return row; }
    public int getCol() { return col; }
    public String getValue() { return value; }
}

class ArrayProcessor {
    public static int processArray(String[][] array)
            throws MyArraySizeException, MyArrayDataException {

        if (array == null || array.length != 4) {
            throw new MyArraySizeException("Массив должен быть 4×4");
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == null || array[i].length != 4) {
                throw new MyArraySizeException("Строка " + i + " должна быть длиной 4");
            }
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j, array[i][j]);
                }
            }
        }
        return sum;
    }
}

 class Main {
    public static void main(String[] args) {
        int[] arr = new int[5];
        try {
            int x = arr[10];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Массив выходит за границы");
        }

        String[][] correctArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] wrongArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"}
        };

        String[][] wrongDataArray = {
                {"1", "2", "3", "4"},
                {"5", "D", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        System.out.println("Тест 1: ПРАВИЛЬНЫЙ МАССИВ");
        try {
            int result = ArrayProcessor.processArray(correctArray);
            System.out.println("Сумма элементов: " + result);
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка размера: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка данных: " + e.getMessage());
        }
        System.out.println();

        System.out.println("Тест 2: НЕПРАВИЛЬНЫЙ МАССИВ");
        try {
            int result = ArrayProcessor.processArray(wrongArray);
            System.out.println("Сумма элементов: " + result);
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка размера: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка данных: " + e.getMessage());
        }
        System.out.println();

        // Тест 3: Неправильные данные
        System.out.println("Тест 3: МАССИВ С НЕЧИСЛОВЫМИ ДАННЫМИ");
        try {
            int result = ArrayProcessor.processArray(wrongDataArray);
            System.out.println("Сумма элементов: " + result);
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка размера: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка данных: " + e.getMessage());
        }
    }
 }