public class Loader {
    private static final int SIZE = 8;
    private static String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H"};

    public static void main(String[] args) {
        String[][] board = new String[SIZE][SIZE];
        for (int i = SIZE; i > 0 ; i--) {
            for (int j = 0; j < SIZE; j++) {
                board[SIZE - i][j] = String.format("%s%s", letters[j], i);
            }
        }
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
