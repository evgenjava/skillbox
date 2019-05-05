import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Loader {
    private static TreeSet<String> medicaments = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        String input;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for(;;) {
            System.out.println("Введите лекарство : ");
            input = reader.readLine().trim();
            if (input.equalsIgnoreCase("exit")) break;

            if (input.equalsIgnoreCase("LIST")) {
                printMedicaments();
                continue;
            }
            else {
                medicaments.add(input);
            }
        }

    }

    public static void printMedicaments() {
        for (String m : medicaments) {
            System.out.println(m);
        }
    }
}
