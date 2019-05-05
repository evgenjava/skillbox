import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Loader {

    public static final int SIZE_PARKIG = 5;
    private static ArrayList<String> airParking = new ArrayList<>(SIZE_PARKIG);

    public static void main(String[] args) throws IOException {

        String input;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for(;;) {
            System.out.println("Введите номер самолёта: ");
            input = reader.readLine().trim();
            if (input.equalsIgnoreCase("exit")) break;

            if (input.equalsIgnoreCase("exitAll")) {
                clearParking();
                continue;
            }
            if (input.equalsIgnoreCase("exitLast")) {
                lastAirDepart();
                continue;
            }

            if (airParking.size() < SIZE_PARKIG) {
                airParking.add(input);
            }
            else {
                System.out.println("Стоянка заполнена");
            }
        }
    }

    private static void clearParking() {
        for (int i = airParking.size() - 1; i >= 0 ; i--) {
            System.out.println(airParking.get(i));
        }
        airParking.clear();
        System.out.println("Стоянка пуста");
    }

    public static void lastAirDepart() {
        if (airParking.size() == 0) {
            System.out.println("Стоянка пуста");
        }
        else {
            int index = airParking.size() - 1;
            System.out.println(airParking.get(index));
            airParking.remove(index);
        }
    }

}
