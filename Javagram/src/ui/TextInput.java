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

    private final int PHONE_WIDTH = 400;
    private final int CODE_WIDTH = 300;
    private final int HEIGHT = 46;

    private BufferedImage icon;
    private Font font;

    public TextInput(int typeInput) {

        Border border = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE);
        setBorder(border);
        setMargin(new Insets(2, 5, 2,5));
        setOpaque(false);
        setForeground(Color.WHITE);
        loadFont(UIResources.OPEN_SANS_LIGHT);
        switch(typeInput) {
            case PHONE_INPUT:
                loadIcon(UIResources.ICON_PHONE);
                setFont(font.deriveFont(40.0F));
                setPreferredSize(new Dimension(PHONE_WIDTH, HEIGHT));
                setMaximumSize(new Dimension(PHONE_WIDTH, HEIGHT));
                setMinimumSize(new Dimension(PHONE_WIDTH, HEIGHT));
                setDocument(new MainPanel.PhoneFilter());
                setText("    +7");
                break;
            case CODE_INPUT:
                loadIcon(UIResources.ICON_LOCK);
                setPreferredSize(new Dimension(CODE_WIDTH, HEIGHT));
                setHorizontalAlignment(JTextField.CENTER);
                setPreferredSize(new Dimension(CODE_WIDTH, HEIGHT));
                setMaximumSize(new Dimension(CODE_WIDTH, HEIGHT));
                setMinimumSize(new Dimension(CODE_WIDTH, HEIGHT));
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
    private void loadIcon(String fileName) {

        try {
            icon = ImageIO.read(new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(icon, 5, 3, null);
    }
}
