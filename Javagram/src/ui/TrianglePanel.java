package ui;

import main.UIResources;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TrianglePanel extends JPanel
{
    public static final int IN_LEFT = 1;
    public static final int OUT_RIGHT = 2;
    private final int width = 20;
    private BufferedImage image;
    private int height;
    private int typePanel;

    public TrianglePanel(int typePanel, int height) {
        this.height = height;
        this.typePanel = typePanel;
        //setOpaque(false);
        setBackground(Color.WHITE);
        switch(typePanel) {
            case IN_LEFT :
                setActualSize(new Dimension(width, height));
                loadImage(UIResources.IN_LEFT);
                break;
            case OUT_RIGHT :
                setActualSize(new Dimension(width, height));
                loadImage(UIResources.OUT_RIGHT);
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
            if (typePanel == IN_LEFT) {
                g.drawImage(image, width - image.getWidth(), (height - image.getHeight()) / 2, null);
            }
            else {
                g.drawImage(image, 0, (height - image.getHeight()) / 2, null);
            }
        }
    }
}
