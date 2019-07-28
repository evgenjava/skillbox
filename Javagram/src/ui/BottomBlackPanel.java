package ui;

import main.UIResources;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BottomBlackPanel extends JPanel {

    public static final int WIDTH = 905;
    public static final int HEIGHT = 100;
    private ControlButton btnBack;


    public BottomBlackPanel() {
        setLayout(new BorderLayout());
        setBackground(UIResources.DARK_GRAY_COLOR);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setMaximumSize(new Dimension(WIDTH, HEIGHT));
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        btnBack = new ControlButton(new Dimension(35, 35), ControlButton.BACK);
        JPanel westPanel = createWestPanel();
        westPanel.add(btnBack);
        add(westPanel, BorderLayout.WEST);
    }

    private JPanel createWestPanel() {
        FlowLayout flowLayout = new FlowLayout();
        Dimension bSize = btnBack.getPreferredSize();
        flowLayout.setHgap((100 - bSize.width) / 2);
        flowLayout.setVgap((HEIGHT - bSize.height) / 2);
        JPanel panel = new JPanel(flowLayout);
        panel.setOpaque(false);
        panel.setPreferredSize(new Dimension(120, HEIGHT));
        panel.setMaximumSize(new Dimension(120, HEIGHT));
        panel.setMinimumSize(new Dimension(120, HEIGHT));
        return panel;
    }

    public void addEastPanel(JPanel eastPanel) {
        add(eastPanel, BorderLayout.EAST);
    }





}
