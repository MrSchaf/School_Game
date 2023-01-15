package code.IO.OutPut.Graphics.Graphics_Game.Game_Image;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class Image_Paint {

//    public static void paint(Graphics g, BufferedImage image, int width , int height){
//        int w = image.getWidth();
//        int h = image.getHeight();
//
//        BufferedImage after = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
//        AffineTransform at = new AffineTransform();
//        at.scale((double) width / w, (double) height / h);
//
//        AffineTransformOp scaleOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
//        after = scaleOp.filter(image, after);
//
//        g.drawImage(after, 0, 0, width, height, null);
//    }

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