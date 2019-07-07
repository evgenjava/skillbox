package ui;

import main.UIResources;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CodeInput extends JPasswordField {

    public static final int WIDTH = 150;
    private final int HEIGHT = 46;

    private Font font;

    public CodeInput() {
        Border border = BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE);
        setBorder(border);
        setMargin(new Insets(2, 5, 2,5));
        setOpaque(false);
        setHorizontalAlignment(CENTER);
        setForeground(Color.WHITE);
        setCaretColor(Color.WHITE);
        loadFont(UIResources.OPEN_SANS_LIGHT);
        setFont(font.deriveFont(40.0F));
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setHorizontalAlignment(JTextField.CENTER);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setMaximumSize(new Dimension(WIDTH, HEIGHT));
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
    }

    private void loadFont(String fontName) {
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File(fontName));
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
