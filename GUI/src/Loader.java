import javax.swing.*;

public class Loader {

    private static final int WIDTH = 400;
    private static final int HEGHT = 200;

    public static void main(String[] args) {
        JFrame frame = new JFrame();


        Form form = new Form();
        frame.setSize(WIDTH, HEGHT);

        frame.setContentPane(form.getRootPanel());

        frame.setLocationByPlatform(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("GUI");
        frame.setVisible(true);
    }
}
