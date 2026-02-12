public class Product1 {
    public static void main(String[] args) {

        Product[] productsArray = new Product[5];

        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025", "Samsung Corp.", "Korea", 5599, true);
        productsArray[1] = new Product("iPhone 17 Pro", "19.09.2025", "Apple.", "USA", 7000, false);
        productsArray[2] = new Product("Google Pixel 9", "10.02.2025", "Google", "США", 799, false);
        productsArray[3] = new Product("Xiaomi 14 Ultra", "20.01.2025", "Xiaomi", "Китай", 899, true);
        productsArray[4] = new Product("OnePlus 12", "05.02.2025", "OnePlus", "Китай", 699, true);
    }
}
