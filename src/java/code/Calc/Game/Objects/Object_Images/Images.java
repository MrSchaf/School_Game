package code.Calc.Game.Objects.Object_Images;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.Hashtable;

public class Images {
    public Hashtable<String, BufferedImage> images = new Hashtable<>();

    public Images(String path){
        readImages(path);
    }

    public BufferedImage getImage(String image){
        return images.get(image);
    }

    private void readImages(String path){
        File folder = new File(path);
        String imagePath = path.replace("src/resources/", "");
        System.out.println(imagePath);
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                String name = file.getName().replace(".png", "");
                images.put(name, readImage(imagePath + file.getName()));
            }
        }
    }

    private BufferedImage readImage(String path){
        BufferedImage image = null;
        URL url = getClass().getClassLoader().getResource(path);

        try {
            image = ImageIO.read(url);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return image;
    }
}