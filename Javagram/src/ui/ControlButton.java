package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ControlButton extends JButton {

    public static enum BTN_TYPE {BACK, CLOSE, EDIT, HIDE, PLUS, SEARCH};

    private BufferedImage icon;

    public ControlButton(BTN_TYPE type) {
        switch(type) {
            case BACK:
                setIcon("res/buttons/icon-back.png");
                break;
            case CLOSE:
                setIcon("res/buttons/icon-close.png");
                break;
            case EDIT:
                setIcon("res/buttons/icon-edit.png");
                break;
            case HIDE:
                setIcon("res/buttons/icon-hide.png");
                break;
            case PLUS:
                setIcon("res/buttons/icon-plus.png");
                break;
            case SEARCH:
                setIcon("res/buttons/icon-search.png");
                break;
        }
        setBorderPainted(false);
        setSize(icon.getWidth(), icon.getHeight());
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
            g.drawImage(icon, 0, 0, null);
        }
    }
}
