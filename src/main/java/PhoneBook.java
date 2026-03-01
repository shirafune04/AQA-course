import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private Map<String, List<String>> contacts;

    public PhoneBook() {
        contacts = new HashMap<>();
    }

    public void add(String surname, String phone) {
        if (surname == null) {
            throw new IllegalArgumentException("Фамилия не может быть null");
        }
        if (phone == null) {
            throw new IllegalArgumentException("Телефон не может быть null");
        }

        List<String> phones = contacts.get(surname);

        if (phones == null) {
            phones = new ArrayList<>();
            phones.add(phone);
            contacts.put(surname, phones);
        } else {
            phones.add(phone);
        }
    }

    public List<String> get(String surname) {
        if (surname == null) {
            throw new IllegalArgumentException("Фамилия не может быть null");
        }

        List<String> phones = contacts.get(surname);

        if (phones == null) {
            return new ArrayList<>();
        }

        return new ArrayList<>(phones);
    }
}
class PhoneBookMain {
    public static void main (String[] args) {
                PhoneBook phoneBook = new PhoneBook();

                phoneBook.add("Иванов", "969-54-45");
                phoneBook.add("Иванов", "324-86-43");
                phoneBook.add("Петров", "656-54-54");

                System.out.println("Телефоны Иванова: " + phoneBook.get("Иванов"));
                System.out.println("Телефоны Петрова: " + phoneBook.get("Петров"));
                System.out.println("Телефоны Сидорова: " + phoneBook.get("Сидоров"));
            }
        }

