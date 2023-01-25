package code.IO.OutPut.Graphics.Graphics_Game.Game_Image;

import code.Calc.Game.World.Coordinate;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;

public class Image {
    private BufferedImage image;
    private final String path;
    private Resolution resolution;

    public Image(Resolution resolution, String path) {
        this.resolution = resolution;
        this.path = path;

        initImage();
    }

    private void initImage() {
        image = new BufferedImage(resolution.getWidth(), resolution.getHeight(), BufferedImage.TYPE_INT_RGB);
        URL url = getClass().getClassLoader().getResource(path);
        BufferedImage input;

        try {
            input = ImageIO.read(url);
            Image_Paint.paint(image.getGraphics(), input, resolution);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void repaint() {

    }

    public Graphics getGraphics() {
        return image.getGraphics();
    }

    public BufferedImage getImage(){
        return image;
    }

    public Resolution getResolution(){
        return resolution;
    }

    public int getWidth(){
        return resolution.getWidth();
    }

    public int getHeight(){
        return resolution.getHeight();
    }

    public void setImage(BufferedImage image){
        this.image = image;
    }

    public void setResolution(Resolution resolution){
        this.resolution = resolution;
    }

    public void setWidth(int width){
        resolution.setWidth(width);
    }

    public void setHeight(int height){
        resolution.setHeight(height);
    }
}