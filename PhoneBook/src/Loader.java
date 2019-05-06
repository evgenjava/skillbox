import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Loader {

    public static final int PHONE_NUMBER_LENGTH = 11;

    private static TreeMap<String, String> phoneBook = new TreeMap<>();
    public static void main(String[] args) throws IOException {
        String input;
        String number;
        String name;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for(;;) {
            System.out.println("Введите номер телефона или имя : ");
            input = reader.readLine().trim();
            if (input.equalsIgnoreCase("exit")) break;

            if (isPhoneNumber(input)) {
                number = input;
                name = phoneBook.get(number);
                if (name != null) {
                    System.out.println("По номеру : " + number + " найден " +  name);
                }
                else {
                    System.out.println("Имя не найдено введите имя ");
                    input = reader.readLine().trim();
                    phoneBook.put(number, input);
                    System.out.println("Имя : " + input + " сохранено в телефонной книге");
                }

            }
            number = input;
            owner = phoneBook.get(number);
            if (owner == null) {
                System.out.println("Такой машины нет, введите имя владельца : ");
                input = reader.readLine().trim();
                phoneBook.put(number, input);
            }
            else {
                System.out.println(number + " -> " + owner);
            }
        }
    }

    private static boolean isPhoneNumber(String input) {
        return input.replaceAll("[\\D]+", "").length() == PHONE_NUMBER_LENGTH;
    }
}
