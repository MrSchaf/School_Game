package code.IO.OutPut.Graphics.Panels;

import code.IO.InPut.In_Keyboard.In_KeyListener;
import code.IO.OutPut.Graphics.Graphics_Image.Image;
import code.IO.OutPut.Graphics.Graphics_Image.Image_Paint;
import code.IO.OutPut.Graphics.Graphics_Game.Game_Image.Resolution;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

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
    }

    public void paint() {
        image.repaint();
        panel.repaint();
    }

    public void paintPanel(Graphics g) {
        Image_Paint.paint(g, image.getImage(), size);
        BufferedImage bufferedImage = new BufferedImage(size.getWidth(), size.getHeight(), BufferedImage.TYPE_INT_RGB);
        Image_Paint.paint(bufferedImage.getGraphics(), image.getImage(), size);
        File file = new File("src/resources/files/images/Image.png");
        try {
            ImageIO.write(bufferedImage, "png", file);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        image.setResolution(size);
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void addKeyListener(In_KeyListener actionListener){
        panel.addKeyListener(actionListener);
    }

    public void requestFocus(){
        panel.requestFocusInWindow();
    }
}