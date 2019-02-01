public class Loader {
    private static final int MIN_NUMBER = 200000;
    private static final int MAX_NUMBER = 210000;

    public static void main(String[] args) {

        int numberTicket = MIN_NUMBER;
        do {
            System.out.println("Numbr ticket - " + numberTicket);
            numberTicket++;
        } while (numberTicket <= MAX_NUMBER);

    }
}
