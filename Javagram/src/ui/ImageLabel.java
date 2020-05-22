package ui;

import main.UIResources;

import javax.swing.*;
import java.awt.*;

public class ImageLabel extends JLabel {

    public static final int MINI_BLUE_ICON = 100;
    public static final int MINI_WHITE_ICON = 101;
    private ImageIcon icon;
    private Font font = UIResources.getFont(UIResources.OPEN_SANS_LIGHT);

    public ImageLabel(int type, Color bc, Color fc) {
        setFont(font.deriveFont(14.0F));
        setForeground(fc);
        setBackground(bc);
        switch(type) {
            case MINI_BLUE_ICON :
                icon = new ImageIcon(UIResources.MASK_BLUE_MINI);
                break;
            case MINI_WHITE_ICON :
                icon = new ImageIcon(UIResources.MASK_WHITE_MINI);
                break;
        }
        setIcon(icon);
    }
}
