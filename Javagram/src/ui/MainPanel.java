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

    public static final String MINI = "MINI";
    public static final String LARGE = "LARGE";
    public static final int WIDTH = 905;
    public static final int HEIGHT = 622;

    private final Dimension miniSize = new Dimension(124, 98);
    private final Dimension largeSize = new Dimension(165, 168);

    private BufferedImage background;
    private BufferedImage logotip;
    private int logoX;

    public MainPanel(String size) {
        String filename;
        if (size.equals(MINI)) {
            logoX = WIDTH / 2 - miniSize.width / 2;
            filename = "res/images/logo-mini.png";
        }
        else {
            logoX = WIDTH / 2 - largeSize.width / 2;
            filename = "res/images/logo.png";
        }
        try {
            background = ImageIO.read(new File("res/images/background.png"));
            logotip = ImageIO.read(new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        BigButton btnNext = new BigButton("ПРОДОЛЖИТЬ");
        TextInput txtPhone = new TextInput(TextInput.PHONE_INPUT);
        btnNext.setAlignmentX(Box.CENTER_ALIGNMENT);
        add(Box.createRigidArea(new Dimension(0, 200)));
        add(btnNext);
        txtPhone.setAlignmentX(Box.CENTER_ALIGNMENT);
        add(Box.createRigidArea(new Dimension(0, 100)));
        add(txtPhone);
        setSize(WIDTH, HEIGHT);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (background != null) {
            g.drawImage(background, 0, 0, null);
            g.drawImage(logotip, logoX, 30, null);
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
