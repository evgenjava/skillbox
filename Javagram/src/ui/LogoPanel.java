package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LogoPanel extends JPanel {

    public static final String MINI = "MINI";
    public static final String LARGE = "LARGE";

    private BufferedImage logotip;
    public LogoPanel(String size) {
        String filename;
        if (size.equals(MINI)) {
            filename = "/res/images/logo-mini.png";
        }
        else {
            filename = "/res/images/logo.png";
        }

        try {
            logotip = ImageIO.read(new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        if (logotip != null) {
            g.drawImage(logotip, 0, 0, null);
        }
    }
}
