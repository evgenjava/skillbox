import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Loader {

    private static HashMap<String, String> carOwner = new HashMap<>();

    public static void main(String[] args) throws IOException {
        String input;
        String number;
        String owner;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for(;;) {
            System.out.println("Введите номер машины : ");
            input = reader.readLine().trim();
            if (input.equalsIgnoreCase("exit")) break;

            number = input;
            owner = carOwner.get(number);
            if (owner == null) {
                System.out.println("Такой машины нет, введите имя владельца : ");
                input = reader.readLine().trim();
                carOwner.put(number, input);
            }
            else {
                System.out.println(number + " -> " + owner);
            }
        }
    }
}
