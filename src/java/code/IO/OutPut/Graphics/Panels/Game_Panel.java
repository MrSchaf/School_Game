package code.IO.OutPut.Graphics.Panels;

import code.Calc.Game.World.Coordinate;
import code.Calc.Game.World.World;
import code.Calc.Game.World.World_Display_Objects;
import code.IO.OutPut.Graphics.Graphics_Game.Game_Image.Resolution;
import code.IO.OutPut.Graphics.Graphics_Image.Image_Paint;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

public class Game_Panel extends Graphics_Panel {
   private final World_Display_Objects worldObjects;

   public Game_Panel(Resolution resolution, World world) {
       super(resolution);
       worldObjects = new World_Display_Objects(resolution, 1, world, new Coordinate(0, 0));
       panel.setBackground(Color.BLUE);
   }

   @Override
    public void paint() {
       worldObjects.setObjects();
       Image_Paint.frame(getImage(), worldObjects);

       File file = new File("src/resources/files/images/World.png");
       try {
           ImageIO.write(getImage().getImage(), "png", file);
       } catch (Exception e) {
           e.printStackTrace();
       }

       super.paint();
    }

    public void setCamera(Coordinate coordinate){
        worldObjects.setMiddle(coordinate);
    }
}