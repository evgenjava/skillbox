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

    private final int WIDTH = 300;
    private final int HEIGHT = 46;

    private BufferedImage icon;
    private Font font;

    public CodeInput() {
        Border border = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE);
        setBorder(border);
        setMargin(new Insets(2, 5, 2,5));
        setOpaque(false);
        setForeground(Color.WHITE);
        loadFont(UIResources.OPEN_SANS_LIGHT);
        loadIcon(UIResources.ICON_LOCK);
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
