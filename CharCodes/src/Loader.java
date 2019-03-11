public class Loader {

    public static void main(String[] args) {

        System.out.println("Коды русских букв ");

        for (char ch = '\u0000'; ch < '\uFFFF'; ch++) {
            if ( (ch >= 'А' &&  ch <= 'Я') || (ch >= 'а' &&  ch <= 'я')) {
                System.out.println(ch + " " + (int) ch);
            }

        }
    }
}
