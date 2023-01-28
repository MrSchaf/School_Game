package code.Calc.Game.Objects.Object_Images;

import java.awt.image.BufferedImage;
import java.util.Hashtable;

public class Images {
    public Hashtable<Integer, Images> images = new Hashtable<>();

    public Images(String path){

    }

    public BufferedImage getImage(int image){
        return images.get(image).getImage(image);
    }
}