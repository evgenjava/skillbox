package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BigButton extends JButton {

    private final int WIDTH = 337;
    private final int HEIGHT = 65;

    private String caption;
    private BufferedImage background;
    private Font font;

    public BigButton(String caption) {
        this.caption = caption;
        Color color = new Color(0, 181, 234);
        setBorderPainted(false);
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File("res/fonts/OpenSansLight.ttf"));
            background = ImageIO.read(new File("res/images/button-background.png"));
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        setSize(WIDTH, HEIGHT);
        setText(caption);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (background != null) {
            g.drawImage(background, 0, 0, null);
        }
        g.setFont(font.deriveFont(24.0F));
        g.setColor(Color.WHITE);

        FontMetrics fontMetrics = g.getFontMetrics();
        int sWidth = fontMetrics.stringWidth(caption);
        int chHeight = fontMetrics.getAscent();

        g.drawString(caption,(WIDTH - sWidth) / 2, (HEIGHT + chHeight) / 2 - fontMetrics.getDescent());

    }
}
