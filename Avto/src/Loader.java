import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Loader {

    private static HashMap<String, String> carOwner = new HashMap<>();

    public static void main(String[] args) {
        String input;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for(;;) {
            System.out.println("Введите номер машины илши имя владельца : ");
            input = reader.readLine().trim();
            if (input.equalsIgnoreCase("exit")) break;

            if (input.equalsIgnoreCase("LIST")) {

                continue;
            }
            else {
                medicaments.add(input);
            }
        }
    }
}
