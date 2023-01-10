package code.IO.OutPut.Graphics;

import code.IO.OutPut.Graphics.Image.Image;
import code.IO.OutPut.Graphics.Image.Image_Paint;
import code.IO.OutPut.Graphics.Image.Resolution;

import javax.swing.*;
import java.awt.*;

public class Graphics_Panel {
    private JPanel panel;
    private int width;
    private int height;
    private Resolution size;

    private Image image;

    public Graphics_Panel(int width, int height, Resolution resolution) {
        this.width = width;
        this.height = height;
        size = new Resolution(width, height);
        this.image = new Image(resolution);

        initPanel();
    }

    private void initPanel(){
        panel = new JPanel(){
            @Override
            protected void paintComponent(java.awt.Graphics g) {
                super.paintComponent(g);
                Image_Paint.paint(g, image, size);
                System.out.println("Panel: " + panel.getWidth() + " " + panel.getHeight());
            }
        };
        panel.setBackground(Color.BLUE);
        panel.setSize(width, height);
        panel.paint(image.getImage().getGraphics());
    }

    public JPanel getPannel(){
        return panel;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public Resolution getSize(){
        return size;
    }

    public Image getImage(){
        return image;
    }

    public void setWidth(int width){
        this.width = width;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public void setSize(Resolution size){
        this.size = size;
    }

    public void setImage(Image image){
        this.image = image;
    }
}