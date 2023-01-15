package code.IO.OutPut.Graphics;

import code.IO.OutPut.Graphics.Graphics_Game.Game_Image.Resolution;
import code.IO.OutPut.Graphics.Panels.Graphics_Panel;

import javax.swing.*;
import java.util.HashMap;

public class Graphics_ContentPane {
    private JPanel contentPane;
    private HashMap<String,Graphics_Panel> panels;
    private Graphics_Panel currentPanel;

    private Resolution resolution;

    public Graphics_ContentPane(Resolution resolution) {
        contentPane = new JPanel();
        panels = new HashMap<>();
        this.resolution = resolution;
    }

    public void paint(){
        contentPane.repaint();
    }

    public void addPanel(String name, Graphics_Panel panel){
        panels.put(name, panel);
    }

    public void removePanel(String name){
        panels.remove(name);
    }

    public void setCurrentPanel(String name){
        currentPanel = panels.get(name);
        contentPane.remove(contentPane.getComponentCount() - 1);
        contentPane.add(currentPanel.getPanel());
    }

    public JPanel getPanel(){
        return contentPane;
    }

    public Graphics_Panel getCurrentPanel(){
        return currentPanel;
    }
}