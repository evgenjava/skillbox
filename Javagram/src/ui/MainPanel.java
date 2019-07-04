package ui;

import main.UIResources;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainPanel extends JPanel {

    public static final String MINI = "MINI";
    public static final String LARGE = "LARGE";
    public static final int WIDTH = 905;
    public static final int HEIGHT = 622;

    private final int miniLogoWidth = 124;
    private final int largeLogoWidth = 165;

    private BufferedImage background;
    private BufferedImage logotip;
    private int logoX;

    public MainPanel(String size) {
        String filename;
        if (size.equals(MINI)) {
            logoX = WIDTH / 2 - miniLogoWidth / 2;
            filename = UIResources.MINI_LOGO;
        }
        else {
            logoX = WIDTH / 2 - largeLogoWidth / 2;
            filename = UIResources.LARGE_LOGO;
        }
        try {
            background = ImageIO.read(new File(UIResources.BACKGROUND));
            logotip = ImageIO.read(new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setSize(WIDTH, HEIGHT);
    }

    public void addComponent(JComponent component, int deltaY){
        add(Box.createRigidArea(new Dimension(0, deltaY)));
        component.setAlignmentX(Box.CENTER_ALIGNMENT);
        add(component);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (background != null) {
            g.drawImage(background, 0, 0, null);
            g.drawImage(logotip, logoX, 50, null);
        }
    }

    public static class TextFilter extends PlainDocument {
        @Override
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
            char c = str.charAt(0);
            if (Character.isLetter(c) || Character.isSpaceChar(c)) {
                super.insertString(offs, str, a);
            }
        }
    }

    public static class PhoneFilter extends PlainDocument {
        private final String symbols = "()-+";
        @Override
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
            char c = str.charAt(0);
            System.out.println(offs);
            if (Character.isDigit(c) || Character.isSpaceChar(c) || symbols.indexOf(c) >= 0) {
                super.insertString(offs, str, a);
            }
        }
    }

    /**public static class PhoneVerifyer extends InputVerifier {

        @Override
        public boolean verify(JComponent input) {
            JTextField tf = (JTextField) input;
            return tf.getText().length() >= 6;
        }
    }**/
}
