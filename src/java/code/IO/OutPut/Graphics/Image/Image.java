package code.IO.OutPut.Graphics.Image;

import code.Calc.Game.World.Coordinate;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
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
        //image = new BufferedImage(resolution.getWidth(), resolution.getHeight(), BufferedImage.TYPE_INT_RGB);
        URL url = getClass().getClassLoader().getResource("files/images/img.png");

        try {
            image = ImageIO.read(url);

        } catch (Exception e) {
            e.printStackTrace();
        }
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