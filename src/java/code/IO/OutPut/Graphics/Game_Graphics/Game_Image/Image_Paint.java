package code.IO.OutPut.Graphics.Game_Graphics.Game_Image;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class Image_Paint {

    public static void paint(Graphics g, Image image, Resolution size) {
        BufferedImage before = image.getImage();
        int w = before.getWidth();
        int h = before.getHeight();

        BufferedImage after = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        AffineTransform at = new AffineTransform();
        at.scale((double) size.getWidth() / w, (double) size.getHeight() / h);

        AffineTransformOp scaleOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
        after = scaleOp.filter(before, after);

        g.drawImage(after, 0, 0, size.getWidth(), size.getHeight(), null);
    }

    public static void paint(Graphics g, BufferedImage before, Resolution size) {
        int w = before.getWidth();
        int h = before.getHeight();

        BufferedImage after = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        AffineTransform at = new AffineTransform();
        at.scale((double) size.getWidth() / w, (double) size.getHeight() / h);

        AffineTransformOp scaleOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
        after = scaleOp.filter(before, after);

        g.drawImage(after, 0, 0, size.getWidth(), size.getHeight(), null);
    }
}