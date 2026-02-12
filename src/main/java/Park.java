import java.util.ArrayList;
import java.util.List;

public class Park {
    private List<Attraction> attractions = new ArrayList<>();

    public class Attraction {
        private String name;
        private String workTime;
        private double price;

        public Attraction(String name, String workTime, double price) {
            this.name = name;
            this.workTime = workTime;
            this.price = price;
        }

        public void printInfo() {
            System.out.println(name + " | " + workTime + " | " + price + " руб.");
        }
    }

    public static void main(String[] args) {
        Park park = new Park();
        Park.Attraction a = park.new Attraction("Колесо обозрения", "10:00-22:00", 450);
        a.printInfo();
    }
}