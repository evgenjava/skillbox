import java.util.Random;

public class Loader {

    public static int[] pixels = new int[100];
    public static final Random r = new Random();
    public static final int MASK1 = 0xFF0000;
    public static final int MASK2 = 0x00FF00;
    public static final int MASK3 = 0x0000FF;

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            pixels[i] = r.nextInt(Integer.MAX_VALUE) & 0xFFFFFF;
        }

        int one;
        int two;
        int three;
        for (int i = 0; i < 10; i++) {
            System.out.print(Integer.toHexString(pixels[i]) + "  --  ");
            one = (pixels[i] & MASK1) >> 16;
            two = (pixels[i] & MASK2) << 8;
            three = (pixels[i] & MASK3) << 8;
            pixels[i] = two | three | one;
            System.out.println(Integer.toHexString(pixels[i]));

        }
    }

}
