package code.IO.OutPut.Graphics.Graphics_Image;

import code.Calc.Game.Objects.Object;
import code.Calc.Game.Objects.Object_Images.Images;
import code.Calc.Game.World.World_Display_Objects;

import java.awt.*;
import java.util.Vector;

public class Image_Paint {

    public static Image frame(Image image, World_Display_Objects worldObjects){
        Graphics g = image.getGraphics();
        Images images = worldObjects.getImages();

        Vector<Object> tiles = worldObjects.getObjects().get("tiles");
        Vector<Object> entities = worldObjects.getObjects().get("entities");

        for (Object tile : tiles) {
            String img = tile.getImage();
            g.drawImage(images.getImage(img), tile.getCoordinate().getX(), tile.getCoordinate().getY(), null);
        }

        for (Object entity : entities) {
            String img = entity.getImage();
            g.drawImage(images.getImage(img), entity.getCoordinate().getX(), entity.getCoordinate().getY(), null);
        }

        return image;
    }
}