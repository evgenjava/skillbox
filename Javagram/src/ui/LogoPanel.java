package ui;

import main.UIResources;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LogoPanel extends JPanel {

    public static final String MINI = "MINI";
    public static final String LARGE = "LARGE";
    public static final int WIDTH = 905;
    public static final int HEIGHT = 630;

    private final int miniLogoWidth = 124;
    private final int largeLogoWidth = 165;

    private BufferedImage background;
    private BufferedImage logotip;
    private int logoX;

    public LogoPanel(String size) {
        String filename;
        if (size.equals(MINI)) {
            logoX = WIDTH / 2 - miniLogoWidth / 2;
            filename = UIResources.MINI_LOGO;
        }
        else {
            logoX = WIDTH / 2 - largeLogoWidth / 2;
            filename = UIResources.LARGE_LOGO;
        }
        try {
            background = ImageIO.read(new File(UIResources.BACKGROUND));
            logotip = ImageIO.read(new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setSize(WIDTH, HEIGHT);
    }

    public void addComponent(JComponent component, int deltaY){
        add(Box.createRigidArea(new Dimension(0, deltaY)));
        component.setAlignmentX(Box.CENTER_ALIGNMENT);
        add(component);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (background != null) {
            g.drawImage(background, 0, 0, null);
            g.drawImage(logotip, logoX, 50, null);
        }
    }



}
