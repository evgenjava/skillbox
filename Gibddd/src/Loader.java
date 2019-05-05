import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Loader {
    private static final int[] regions = {1, 2, 102, 3, 4, 5, 6, 7, 8, 9, 10,
    11, 12, 13, 113, 14, 15, 16, 116, 17, 18, 19, 20, 21, 121, 22, 23, 93, 123,
    24, 84, 88, 124, 25, 125, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 136,
    37, 38, 85, 39, 91, 40, 41, 82, 42, 142, 43, 44, 45, 46, 47, 48, 40, 50,
    90, 150, 190, 51, 52, 152, 53, 54, 154, 55, 56, 57, 58, 59, 81, 159, 60,
    61, 161, 62, 63, 163, 64, 164, 65, 66, 96, 67, 68, 69, 70, 71, 72, 73, 173,
    74, 174, 75, 80, 76, 77, 97, 99, 177, 199, 197, 777, 78, 98, 178, 79, 83,
    86, 87, 89, 94, 95};

    private static final String[] federal = {"ЕКХ99", "ЕКХ177", "ЕКХ97", "ХКХ77",
    "АМР97", "ТКР177", "ХРК177", "ООТ177", "АОО77", "ВОО77", "МОО77", "СОО77", "КОО77",
    "АКР177", "ВКР177", "ЕКР177", "ККР177", "ЕРЕ177", "АМР77", "ВМР77", "КМР77", "ММР77",
    "ТМР77", "РМР77", "АМО77","ОМР77", "УМР77", "НАА99", "ТАА99", "САА99", "ХАА99"};

    public static final String[] specSeries = {
            "ААА", "АММ", "АМО", "ЕЕЕ", "ККК", "ККХ", "КММ", "МММ", "ННН", "ООО",
            "САС", "СММ", "СОО", "ССС", "УУУ", "ХХХ"
    };

    private static ArrayList<String> numbers = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        generateFederal();
        generateSpecSeries();
        String number;
        long ms;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println("Введите номер: ");
            number = reader.readLine().trim();
            ms = System.currentTimeMillis();
            boolean isThisNumber = numbers.contains(number.toUpperCase());
            ms = System.currentTimeMillis() - ms;
            System.out.println(isThisNumber + " (" + ms + " ms)");
        } while (!number.equals("exit"));
        //System.out.println(numbers.size());
       // for (int i = 0; i < numbers.size(); i++) {
       //     System.out.println(numbers.get(i));
       // }
    }

    private static void generateFederal() {
        for (int i = 0; i < federal.length; i++) {
            for (int j = 1; j <= 999; j++) {
                if (j < 10) {
                    numbers.add(federal[i].charAt(0) + "00" + Integer.toString(j) + federal[i].substring(1));
                }
                else if (j >= 10 && j < 100) {
                    numbers.add(federal[i].charAt(0) + "0" + Integer.toString(j) + federal[i].substring(1));
                }
                else {
                    numbers.add(federal[i].charAt(0) + Integer.toString(j) + federal[i].substring(1));
                }
            }
        }
    }

    private static void generateSpecSeries() {
        for (int i = 0; i < regions.length ; i++) {
            String region;
            if (regions[i] < 10) {
                region = "0" + Integer.toString(regions[i]);
            }
            else {
                region = Integer.toString(regions[i]);
            }
            for (int j = 0; j < specSeries.length; j++) {
                for (int k = 1; k <= 999 ; k++) {
                    if (k < 10) {
                        numbers.add(specSeries[j].charAt(0) + "00" + Integer.toString(k)
                                + specSeries[j].substring(1) + region);
                    }
                    else if (k >=10 && k < 100) {
                        numbers.add(specSeries[j].charAt(0) + "0" + Integer.toString(k)
                                + specSeries[j].substring(1) + region);
                    }
                    else {
                        numbers.add(specSeries[j].charAt(0) + Integer.toString(k)
                                + specSeries[j].substring(1) + region);
                    }
                }

            }
        }
    }
}
