package code.IO.OutPut.Graphics.Panels;

import code.IO.OutPut.Graphics.Graphics_Image.Image;
import code.IO.OutPut.Graphics.Graphics_Image.Image_Paint;
import code.IO.OutPut.Graphics.Graphics_Game.Game_Image.Resolution;

import javax.swing.*;
import java.awt.*;

public class Graphics_Panel {
    protected JPanel panel;
    private Resolution size;
    private Image image;

    public Graphics_Panel(Resolution resolution) {
        size = resolution;
        image = new Image(size, "files/images/img.png");

        panel = new JPanel(){
          @Override
          public void paintComponent(Graphics g) {
              super.paintComponent(g);
              Image_Paint.paint(g, image.getImage(), size);
          }
        };

        panel.setSize(resolution.getWidth(), resolution.getHeight());
        paint();
    }

    public void paint() {
        image.repaint();
        panel.repaint();
    }

    public JPanel getPanel() {
        return panel;
    }

    public Resolution getSize() {
        return size;
    }

    public Image getImage() {
        return image;
    }

    public void setSize(Resolution size) {
        this.size = size;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}