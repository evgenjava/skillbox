public class Loader {
    private static final String DIGITS = "0123456789";

    public static void main(String[] args) {
        String text = "Вася заработал 5300 рублей, Петя - 756311 рубля, а Миша - 13000 рублей";
        int totalSumma = 0;
        int index = 0;
        while(index < text.length() ) {
            if (DIGITS.indexOf(text.charAt(index)) >= 0) {
                int startIndex = index;
                while(DIGITS.indexOf(text.charAt(++index)) >= 0);
                int endIndex = index;
                totalSumma += Integer.parseInt(text.substring(startIndex, endIndex).trim());
                break;
            }
            else {
                index++;
            }
        }
        index = text.length() - 1;
        while(index >= 0) {
            if (DIGITS.lastIndexOf(text.charAt(index)) >= 0) {
                int endIndex = index + 1;
                while(DIGITS.lastIndexOf(text.charAt(--index)) >= 0);
                int startIndex = index;
                totalSumma += Integer.parseInt(text.substring(startIndex, endIndex).trim());
                break;
            }
            else {
                index--;
            }
        }
        System.out.println("Вася и Маша заработали - " + totalSumma);
    }
}
