package ui;

import main.UIResources;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DrawingPanel extends JPanel {

    public static final int IN_BOTTOM = 1;
    public static final int IN_TOP = 2;
    public static final int OUT_BOTTOM = 3;
    public static final int OUT_TOP = 4;

    private final Dimension inSize = new Dimension(308, 8);
    private final Dimension outSize = new Dimension(307, 9);


    private BufferedImage image;
    private Color color;

    public DrawingPanel(int typePanel) {
        setOpaque(false);
        switch(typePanel) {
            case IN_BOTTOM :
                loadImage(UIResources.IN_BOTTOM);
                setActualSize(inSize);
                break;
            case IN_TOP :
                loadImage(UIResources.IN_TOP);
                setActualSize(inSize);
                break;
            case OUT_BOTTOM :
                loadImage(UIResources.OUT_BOTTOM);
                setActualSize(outSize);
                break;
            case OUT_TOP :
                loadImage(UIResources.OUT_TOP);
                setActualSize(outSize);
                break;
        }
    }

    private void setActualSize(Dimension size) {
        setMaximumSize(size);
        setMinimumSize(size);
        setPreferredSize(size);
    }

    private void loadImage(String fileName) {
        try {
            image = ImageIO.read(new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0,0, null);
        }
    }
}
