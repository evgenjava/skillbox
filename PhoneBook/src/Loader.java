import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Loader {

    public static final int PHONE_NUMBER_LENGTH = 11;
    public static final String PHONE_NUMBER_SYMBOLS = "+-()0123456789";

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
            if (input.equalsIgnoreCase("LIST")) {
                for (String key : phoneBook.keySet()) {
                    System.out.println("Имя : " + key + " номер : " + phoneBook.get(key) );
                }
                continue;
            }

            if (!isPhoneNumber(input)) {
                name = input;
                number = phoneBook.get(name);
                if (number != null) {
                    System.out.println("По имени : " + name + " найден номер " +  number);
                }
                else {
                    System.out.println("Номер по имени " + name + " не найден, введите номер");
                    input = reader.readLine().trim();
                    phoneBook.put(name, input);
                    System.out.println("Номер : " + input + " сохранен в телефонной книге с именем " + name);
                }

            }
            else {
                number = input;
                if (phoneBook.containsValue(number)) {
                    for ( String key : phoneBook.keySet()) {
                        if (number.equalsIgnoreCase(phoneBook.get(key))) {
                            System.out.println("По номеру : " + number + " найдено имя " +  key);
                        }
                    }

                }
                else {
                    System.out.println("Имя для " + number + " не найдено введите имя ");
                    input = reader.readLine().trim();
                    phoneBook.put(input, number);
                    System.out.println("Имя : " + input + " сохранено в телефонной книге с номером " + number);
                }
            }

        }
    }

    private static boolean isPhoneNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (PHONE_NUMBER_SYMBOLS.indexOf(input.charAt(i)) < 0) {
                return false;
            }
        }
        return true;
    }
}
