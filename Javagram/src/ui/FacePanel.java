package ui;

import main.UIResources;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FacePanel extends JPanel {

    public static final int MASK_BLUE_MINI = 1;
    public static final int MASK_DARK_GRAY_BIG = 2;
    public static final int MASK_GRAY = 3;
    public static final int MASK_GRAY_ONLINE = 4;
    public static final int MASK_WHITE = 5;
    public static final int MASK_WHITE_MINI = 6;
    public static final int MASK_WHITE_ONLINE = 7;

    private final Dimension sizeMini = new Dimension(29, 29);
    private final Dimension sizeNormal = new Dimension(41, 41);
    private final Dimension sizeBig = new Dimension(66, 66);

    private BufferedImage mask;

    public FacePanel(int maskType) {
        switch(maskType) {
            case MASK_BLUE_MINI:
                setMask(UIResources.MASK_BLUE_MINI);
                setBackground(new Color(0, 179, 230));
                setActualSize(sizeMini);
                break;
            case MASK_DARK_GRAY_BIG:
                setMask(UIResources.MASK_DARK_GRAY_BIG);
                setBackground(new Color(230, 230, 230));
                setActualSize(sizeBig);
                break;
            case MASK_GRAY:
                setMask(UIResources.MASK_GRAY);
                setBackground(new Color(230, 230, 230));
                setActualSize(sizeNormal);
                break;
            case MASK_GRAY_ONLINE:
                setMask(UIResources.MASK_GRAY_ONLINE);
                setBackground(new Color(230, 230, 230));
                setActualSize(sizeNormal);
                break;
            case MASK_WHITE:
                setMask(UIResources.MASK_WHITE);
                setBackground(Color.WHITE);
                setActualSize(sizeNormal);
                break;
            case MASK_WHITE_MINI:
                setMask(UIResources.MASK_WHITE_MINI);
                setBackground(Color.WHITE);
                setActualSize(sizeMini);
                break;
            case MASK_WHITE_ONLINE:
                setMask(UIResources.MASK_WHITE_ONLINE);
                setBackground(Color.WHITE);
                setActualSize(sizeNormal);
                break;
        }
    }

    private void setActualSize(Dimension size) {
        setPreferredSize(size);
        setMaximumSize(size);
        setMinimumSize(size);
    }

    private void setMask(String fileName) {
        try {
            mask = ImageIO.read(new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (mask != null) {
            g.drawImage(mask, 0, 0, null);
        }
    }
}
