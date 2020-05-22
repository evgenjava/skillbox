package ui;

import main.UIResources;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FullNamePanel extends JPanel {

    private final int height = 66;

    private TextInput txtFullName;
    private BufferedImage mask;
    private int width;

    public FullNamePanel(String fullName) {
        txtFullName = new TextInput(350, TextInput.FULLNAME_INPUT, "");
        txtFullName.setText(fullName);
        width = 66 + txtFullName.getWidth() + 140;
        loadImage();
        FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
        layout.setHgap(20);
        setLayout(layout);
        setOpaque(false);
        setMaximumSize(new Dimension(width, height));
        setMinimumSize(new Dimension(width, height));
        setPreferredSize(new Dimension(width, height));
        add(txtFullName);
    }

    private void loadImage() {
        try {
            mask = ImageIO.read(new File(UIResources.MASK_DARK_GRAY_BIG));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.drawImage(mask,20, 0, null);
        g.drawLine(0, 56, 29, 56);
        g.drawLine(77, 56, width, 56);
    }

    public String getName() {
        return txtFullName.getText();
    }
}
