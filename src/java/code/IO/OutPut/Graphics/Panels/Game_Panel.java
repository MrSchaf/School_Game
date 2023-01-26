package code.IO.OutPut.Graphics.Panels;

import code.Calc.Game.World.World;
import code.Calc.Game.World.World_Display_Objects;
import code.IO.OutPut.Graphics.Graphics_Game.Game_Image.Resolution;

import java.awt.*;

public class Game_Panel extends Graphics_Panel {
   private final World_Display_Objects worldObjects;

   public Game_Panel(Resolution resolution, World world) {
       super(resolution);
       panel.setBackground(Color.BLUE);
       worldObjects = new World_Display_Objects(resolution, 1, world);

   }
}