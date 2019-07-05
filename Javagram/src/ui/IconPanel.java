package ui;

import main.UIResources;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class IconPanel  extends JPanel {

    public static final int ICON_PHONE = 100;
    public static final int ICON_LOCK = 101;

    public static final int WIDTH = 35;
    public static final int HEIGHT = 46;

    private BufferedImage icon;

    public IconPanel(int typeIcon) {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setMaximumSize(new Dimension(WIDTH, HEIGHT));
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setOpaque(false);
        switch(typeIcon) {
            case ICON_PHONE :
                loadIcon(UIResources.ICON_PHONE);
                break;
            case ICON_LOCK :
                loadIcon(UIResources.ICON_LOCK);
                break;
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
        g.drawImage(icon, 5, 5, null);
    }
}
