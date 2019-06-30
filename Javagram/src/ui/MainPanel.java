package ui;

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

    private BufferedImage background;
    public MainPanel() {
        try {
            background = ImageIO.read(new File("res/images/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (background != null) {
            g.drawImage(background, 0, 0, null);
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
            if (Character.isDigit(c) || Character.isSpaceChar(c) || symbols.indexOf(c) >= 0) {
                super.insertString(offs, str, a);
            }
        }
    }

    public static class PhoneVerifyer extends InputVerifier {

        @Override
        public boolean verify(JComponent input) {
            JTextField tf = (JTextField) input;
            return tf.getText().length() >= 6;
        }
    }
}
