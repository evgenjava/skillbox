package ui;

import main.UIResources;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ControlButton extends JButton {

    public static enum BTN_TYPE {BACK, CLOSE, EDIT, HIDE, PLUS, SEARCH, SETTINGS};

    private BufferedImage icon;
    private Dimension size;

    public ControlButton(Dimension size, BTN_TYPE type) {
        this.size = size;
        switch(type) {
            case BACK:
                setIcon(UIResources.ICON_BACK);
                setBackground(Color.BLACK);
                break;
            case CLOSE:
                setIcon(UIResources.ICON_CLOSE);
                setOpaque(false);
                break;
            case EDIT:
                setIcon(UIResources.ICON_EDIT);
                break;
            case HIDE:
                setIcon(UIResources.ICON_HIDE);
                setOpaque(false);
                break;
            case PLUS:
                setIcon(UIResources.ICON_PLUS);
                setBackground(new Color(242, 242, 242));
                break;
            case SEARCH:
                setIcon(UIResources.ICON_SEARCH);
                setBackground(Color.WHITE);
                break;
            case SETTINGS:
                setIcon(UIResources.ICON_SETTINGS);
                setBackground(new Color(0, 179, 230));
                break;
        }
        setBorderPainted(false);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
    }

    private void setIcon(String fileName) {
        try {
            icon = ImageIO.read(new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (icon != null) {

            g.drawImage(icon, (size.width - icon.getWidth()) / 2, (size.height - icon.getHeight()) / 2, null);
        }
    }
}
