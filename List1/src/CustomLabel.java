import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CustomLabel extends JLabel {

    private final int width = 337;
    private final int height = 65;

    private BufferedImage fon;
    public CustomLabel(String text) {
        setMaximumSize(new Dimension(width, height));
        setMinimumSize(new Dimension(width, height));
        setPreferredSize(new Dimension(width, height));
        setForeground(Color.WHITE);
        loadImage();
        setHorizontalAlignment(CENTER);
        addMouseListener(mouseAdapter);
        setText(text);
    }

    private void loadImage() {
        try {
            fon = ImageIO.read(new File("res/buttons/button-background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {

        if (fon != null) {
            g.drawImage(fon, -2, 0, null);
        }
        super.paintComponent(g);
    }

   private MouseAdapter mouseAdapter = new MouseAdapter() {
       @Override
       public void mousePressed(MouseEvent e) {
           setBorder(BorderFactory.createEtchedBorder(1));
           super.mousePressed(e);
       }

       @Override
       public void mouseReleased(MouseEvent e) {
           setBorder(null);
           super.mouseReleased(e);
       }
   };
}
