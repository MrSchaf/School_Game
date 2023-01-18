package code.IO.OutPut.Graphics.Panels;


import code.IO.OutPut.Graphics.Graphics_Game.Game_Image.Image;
import code.IO.OutPut.Graphics.Graphics_Game.Game_Image.Image_Paint;
import code.IO.OutPut.Graphics.Graphics_Game.Game_Image.Resolution;

import javax.swing.*;

public class Graphics_Panel {
    protected JPanel panel;
    private Resolution size;
    private Image image;

    public Graphics_Panel(Resolution resolution) {
        panel = new JPanel();
        panel.setSize(resolution.getWidth(), resolution.getHeight());
        size = resolution;
        image = new Image(size);
        Image_Paint.paint(panel.getGraphics(), image.getImage(), size);

    }

    public void paint() {
        image.repaint();
        panel.repaint();
    }

    public JPanel getPanel() {
        return panel;
    }
}