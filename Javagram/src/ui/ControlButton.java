package ui;

import main.UIResources;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ControlButton extends JButton {

    public static final int BACK = 100;
    public static final int CLOSE = 101;
    public static final int EDIT = 102;
    public static final int HIDE = 103;
    public static final int PLUS = 104;
    public static final int SEARCH = 105;
    public static final int SETTINGS = 106;

    private ImageIcon imageIcon;
    private Dimension size;

    public ControlButton(Dimension size, int type) {
        this.size = size;
        switch(type) {
            case BACK:
                loadIcon(UIResources.ICON_BACK);
                setBackground(Color.BLACK);
                break;
            case CLOSE:
                loadIcon(UIResources.ICON_CLOSE);
                setOpaque(false);
                break;
            case EDIT:
                loadIcon(UIResources.ICON_EDIT);
                setBackground(Color.WHITE);
                break;
            case HIDE:
                loadIcon(UIResources.ICON_HIDE);
                setOpaque(false);
                break;
            case PLUS:
                loadIcon(UIResources.ICON_PLUS);
                setBackground(UIResources.GRAY_COLOR);
                break;
            case SEARCH:
                loadIcon(UIResources.ICON_SEARCH);
                setBackground(Color.WHITE);
                break;
            case SETTINGS:
                loadIcon(UIResources.ICON_SETTINGS);
                setBackground(UIResources.LIGHT_BLUE_COLOR);
                break;
        }
        setBorderPainted(false);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setIcon(imageIcon);
    }

    private void loadIcon(String fileName) {
        imageIcon = new ImageIcon(fileName);
    }
}
