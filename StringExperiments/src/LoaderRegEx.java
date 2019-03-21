public class LoaderRegEx {

    public static void main(String[] args) {
        String text = "Вася заработал 5300 рублей, Петя -756311 рубля, а Маша - 13000 рублей";
        System.out.println(text.replaceAll("\\b[^0-9*\\S]\\b", ""));
    }
}
