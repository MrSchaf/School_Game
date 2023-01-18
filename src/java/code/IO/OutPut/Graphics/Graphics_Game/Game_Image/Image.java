package code.IO.OutPut.Graphics.Graphics_Game.Game_Image;

import code.Calc.Game.World.Coordinate;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

public class Image {
    private BufferedImage image;
    private Resolution resolution;
    private Coordinate middle;

    public Image(Resolution resolution) {
        this.resolution = resolution;

        initImage();
    }

    private void initImage() {
        image = new BufferedImage(resolution.getWidth(), resolution.getHeight(), BufferedImage.TYPE_INT_RGB);
        URL url = getClass().getClassLoader().getResource("files/images/img.png");
        BufferedImage input;

        try {
            input = ImageIO.read(url);
            Image_Paint.paint(image.getGraphics(), input, resolution);
            URL imageURL = getClass().getClassLoader().getResource("files/images/Image.png");
            File file = new File(imageURL.toURI());
            ImageIO.write(image, "png", file);

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