package ui;

import sun.applet.Main;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PhonePanel extends MainPanel {

    public static final int WIDTH = 905;
    public static final int HEIGHT = 622;

    private final String welcomInput = "Введите код страны и номер\nвашего мобильного телефона";
    private JPanel pnlLogo;
    private JTextPane paneWelcom;
    private JTextField txtPhone;
    private JButton btnNext;

    public PhonePanel() {
        super(MainPanel.LARGE);
        createUIComponents();
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File("res/fonts/OpenSansLight.ttf"));
            paneWelcom.setFont(font.deriveFont(18.0F));
            txtPhone.setFont(font.deriveFont(40.0F));
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //BoxLayout box = new BoxLayout(this, BoxLayout.Y_AXIS);
       // box.
        //setLayout(box);
        //add(Box.createRigidArea(new Dimension(0, 30)));
        //pnlLogo.setAlignmentX(Component.RIGHT_ALIGNMENT);
        //add(pnlLogo);
         //add(Box.createRigidArea(new Dimension(0, 200)));
         //add(paneWelcom);
        // add(Box.createRigidArea(new Dimension(0, 30)));
         //add(txtPhone);
        //add(Box.createRigidArea(new Dimension(0, 30)));
         //add(btnNext);

    }

    private void createUIComponents() {
        pnlLogo = new LogoPanel(LogoPanel.LARGE);
        paneWelcom = new WelcomPane(new Dimension(380, 140), "text");
        txtPhone = new TextInput(TextInput.PHONE_INPUT);
        btnNext = new BigButton("ПРОДОЛЖИТЬ");
    }
}
