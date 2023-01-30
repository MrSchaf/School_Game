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

        Vector<Object> tiles = worldObjects.getTiles();
        Vector<Object> entities = worldObjects.getEntities();

        for (Object tile : tiles) {
            String img = tile.getImage();
            int x = tile.getCoordinate().getX() + worldObjects.getMiddleX();
            int y = tile.getCoordinate().getY() + worldObjects.getMiddleY();
            g.drawImage(images.getImage(img), x, y, null);
        }

        for (Object entity : entities) {
            String img = entity.getImage();
            g.drawImage(images.getImage(img), entity.getCoordinate().getX(), entity.getCoordinate().getY(), null);
        }

        return image;
    }
}