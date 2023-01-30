package code.IO.OutPut.Graphics.Graphics_Image;

import code.Calc.Game.Objects.Object;
import code.Calc.Game.Objects.Object_Images.Images;
import code.Calc.Game.World.World_Display_Objects;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.util.Vector;

public class Image_Paint {

    public static Image frame(Image image, World_Display_Objects worldObjects){
        Graphics g = image.getGraphics();
        Images images = worldObjects.getImages();

        Vector<Object> tiles = worldObjects.getTiles();
        Vector<Object> entities = worldObjects.getEntities();

        draw(worldObjects, g, images, tiles);

        draw(worldObjects, g, images, entities);

        File file = new File("src/resources/files/images/World.png");
        try {
            ImageIO.write(image.getImage(), "png", file);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return image;
    }

    private static void draw(World_Display_Objects worldObjects, Graphics g, Images images, Vector<Object> objects) {
        for (Object object : objects) {
            drawObject(g, images, object, worldObjects.getMiddleX(), worldObjects.getMiddleY());
        }
    }

    private static void drawObject(Graphics g, Images images, Object object, int middleX, int middleY) {
        String img = object.getImage();
        int x = object.getCoordinate().getX() + middleX;
        int y = object.getCoordinate().getY() + middleY;
        g.drawImage(images.getImage(img), x, y, null);
    }
}