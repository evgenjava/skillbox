import java.util.Calendar;

public class Loader {

    private static int[] okato = {1, 3, 4, 5, 6, 7, 8, 10, 11, 12 ,14, 15, 17, 18,
    19, 20, 22, 24, 25, 26, 27, 28, 29, 30, 32, 33, 34, 36, 37, 38, 40, 42, 44, 45,
    46, 47, 49, 50, 52, 53, 54, 56, 57, 58, 60, 61, 63, 64, 65, 66, 68, 69,70, 71,
    73, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93,
    94, 95, 96, 97, 98, 99};

    private static final int startYear = 1997;
    private static String[] series;

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        int currentYear =  Calendar.getInstance().get(Calendar.YEAR);
        series = new String[okato.length * (currentYear - startYear + 1)];
        int index = 0;
        for (int i = 0; i < okato.length; i++) {
            String ok;
            if (okato[i] < 10) {
                ok = "0" + Integer.toString(okato[i]);
            }
            else {
                ok = Integer.toString(okato[i]);
            }
            for (int j = startYear; j <= currentYear && index < series.length; j++) {
                String year = Integer.toString(j).substring(2);
                series[index++] = String.format("%s %s", ok, year);

            }
        }
        for (String s : series) {
            System.out.println(s);
        }
    }
}
