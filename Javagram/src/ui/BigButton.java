package ui;

import main.UIResources;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BigButton extends JButton {

    private final int WIDTH = 345;
    private final int HEIGHT = 73;

    private String caption;
    private BufferedImage background;
    private Font font;

    public BigButton(String caption) {
        this.caption = caption;
        Color color = new Color(0, 181, 234);


        //Border border = BorderFactory.createLineBorder(color ,4 ,true);
        //setBorder(border);
        setBackground(color);
        setForeground(Color.WHITE);
        setBorderPainted(false);
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File(UIResources.OPEN_SANS_LIGHT));
            background = ImageIO.read(new File(UIResources.BUTTON_BACKGROUND));
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        setMaximumSize(new Dimension(WIDTH, HEIGHT));
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFont(font.deriveFont(24.F));
        setOpaque(false);
        //setText(caption);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (background != null) {
            g.drawImage(background, 4, 4, null);
        }
        g.setFont(font.deriveFont(24.0F));
        g.setColor(Color.WHITE);

        FontMetrics fontMetrics = g.getFontMetrics();
        int sWidth = fontMetrics.stringWidth(caption);
        int chHeight = fontMetrics.getAscent();

        g.drawString(caption,(WIDTH - sWidth) / 2, (HEIGHT + chHeight) / 2 - fontMetrics.getDescent());

    }
}
