package code.IO.OutPut.Graphics.Graphics_Image;

import code.IO.OutPut.Graphics.Graphics_Game.Game_Image.Resolution;

import code.Calc.Game.Objects.Object;
import code.Calc.Game.World.World_Display_Objects;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.Vector;

public class Image_Paint {

    public static Image frame(Image image, World_Display_Objects worldObjects){
        Graphics g = image.getGraphics();

        Vector<Object> tiles = worldObjects.getObjects().get("tiles");
        Vector<Object> entities = worldObjects.getObjects().get("entities");

        for (Object tile : tiles) {
            tile.paint(g, worldObjects);
        }

        for (Object entity : entities) {
            entity.paint(g, worldObjects);
        }

        return image;
    }

    public static void paint(Graphics g, BufferedImage before, Resolution size) {
        int w = before.getWidth();
        int h = before.getHeight();

        BufferedImage after = new BufferedImage(size.getWidth(), size.getHeight(), BufferedImage.TYPE_INT_ARGB);
        AffineTransform at = new AffineTransform();
        at.scale((double) size.getWidth() / w, (double) size.getHeight() / h);

        AffineTransformOp scaleOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
        after = scaleOp.filter(before, after);

        g.drawImage(after, 0, 0, size.getWidth(), size.getHeight(), null);
    }
}