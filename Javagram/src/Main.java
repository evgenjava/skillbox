import ui.PhoneNumberFrom;

import javax.swing.*;

public class Main {

    public static final int WIDTH = 600;
    public static final int HEIGHT = 400;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        PhoneNumberFrom phoneNumberFrom = new PhoneNumberFrom();
        frame.setContentPane(phoneNumberFrom.getRootPanel());
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationByPlatform(true);
        frame.setTitle("Javagram");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
