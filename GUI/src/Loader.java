import javax.swing.*;

public class Loader {

    private static final int WIDTH = 800;
    private static final int HEGHT = 600;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(WIDTH, HEGHT);

        Form form = new Form();
        frame.setContentPane(form.getRootPanel());

        frame.setLocationByPlatform(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("GUI");
        frame.setVisible(true);
    }
}
