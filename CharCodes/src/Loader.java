public class Loader {

    public static void main(String[] args) {


        //System.out.println("Символы скодами от 0 до 512");
        //for (char ch = 0; ch < 513; ch++) {
        //    System.out.println((int) ch + " - " + ch);
        //}

        System.out.println("Коды русских букв ");
        for(int i=1072; i<=1103;i++) {
            System.out.println((char)i+" = "+i+", "+(char)(i-32)+" = "+(i-32));
        }

        System.out.println("ё = "+(int)'ё'+", Ё = "+(int)'Ё');


    }
}
