package ui;

import main.UIResources;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TextInput extends JTextField {

    public static final int PHONE_INPUT = 100;
    public static final int CODE_INPUT = 101;
    public static final int FIRST_NAME_INPUT = 102;
    public static final int LAST_NAME_INPUT = 103;

    public static final int WIDTH = 400;
    private final int HEIGHT = 46;

    private Font font;

    public TextInput(int typeInput) {

        Border border = BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE);
        setBorder(border);
        setMargin(new Insets(2, 5, 2, 5));
        setOpaque(false);
        setForeground(Color.WHITE);
        setCaretColor(Color.WHITE);
        loadFont(UIResources.OPEN_SANS_LIGHT);
        switch (typeInput) {
            case PHONE_INPUT:
                setFont(font.deriveFont(40.0F));
                setPreferredSize(new Dimension(WIDTH, HEIGHT));
                setMaximumSize(new Dimension(WIDTH, HEIGHT));
                setMinimumSize(new Dimension(WIDTH, HEIGHT));
                setDocument(new MainPanel.PhoneFilter());
                setText("+7");
                break;

        }
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
