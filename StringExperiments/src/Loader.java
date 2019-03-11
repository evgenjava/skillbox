import java.io.IOException;

public class Loader
{
    public static void main(String[] args) throws IOException
    {
        String text = "Вася заработал 5000 рублей, Петя - 756311 рубля, а Маша - 3000 рублей";
        int worker = 1;
        int totalSumma = 0;
        int index = 0;
        while(index < text.length() ) {
            if ("0123456789".indexOf(text.charAt(index)) >= 0) {
                int startIndex = index;
                while("0123456789".indexOf(text.charAt(index++)) >= 0);
                int endIndex = index - 1;
                if (worker == 1 || worker == 3) {
                    totalSumma += Integer.parseInt(text.substring(startIndex, endIndex).trim());
                }
                worker++;

            }
            else {
                index++;
            }
        }

        System.out.println("Вася и Маша заработали - " + totalSumma);

    }
}