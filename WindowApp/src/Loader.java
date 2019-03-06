import javax.swing.*;
import java.awt.*;

public class Loader {
    private static final int WIDTH = 800;
    private static final int HEGHT = 600;
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        //Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(WIDTH, HEGHT);
        frame.setLocationByPlatform(true);
        /*frame.setBounds(dimension.width / 2 - WIDTH / 2,
                 dimension.height / 2 - HEGHT / 2,
                WIDTH, HEGHT);*/
        frame.setTitle("First Window Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        System.out.println("Hello terminal");
    }
}
