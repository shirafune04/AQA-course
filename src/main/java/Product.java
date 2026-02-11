public class Product {
    String productName;
    String manufactureData;
    String manufacturer;
    String countryOfOrigin;
    double price;
    boolean isReserved;

    public Product ( String productName, String manufactureData, String manufacturer, String countryOfOrigin, double price, boolean isReserved) {
        this.productName = productName;
        this.manufactureData = manufactureData;
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.isReserved = isReserved;
    }
    public void printInfo() {
        System.out.println("Название: " + productName);
        System.out.println("Дата: " + manufactureData);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Страна: " + countryOfOrigin);
        System.out.println("Цена: " + price);
        System.out.println("Бронь: " + (isReserved ? "Да" : "Нет"));
    }

    public static void main(String[] args) {
        Product p = new Product("Планшет", "2024-03-10", "iPad",
                "США", 50000, true);
        p.printInfo();
    }
}
