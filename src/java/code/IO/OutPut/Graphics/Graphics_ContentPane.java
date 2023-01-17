package code.IO.OutPut.Graphics;

import code.IO.OutPut.Graphics.Graphics_Game.Game_Image.Resolution;
import code.IO.OutPut.Graphics.Panels.Graphics_Panel;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class Graphics_ContentPane {
    private JFrame frame;
    private Container contentPane;
    private HashMap<String,Graphics_Panel> panels;
    private Graphics_Panel currentPanel;

    private Resolution resolution;

    public Graphics_ContentPane(JFrame frame, Resolution resolution) {
        this.frame = frame;
        this.contentPane = frame.getContentPane();
        contentPane.setBackground(Color.YELLOW);
        panels = new HashMap<>();
        this.resolution = resolution;
    }

    public void paint(){
        contentPane.repaint();
        currentPanel.paint();
    }

    public void addPanel(String name, Graphics_Panel panel){
        panels.put(name, panel);
    }

    public void removePanel(String name){
        panels.remove(name);
    }

    public void setCurrentPanel(String name){
        currentPanel = panels.get(name);
        contentPane.removeAll();
        contentPane.add(currentPanel.getPanel());
        frame.validate();
        paint();
    }

    public Container getContainer(){
        return contentPane;
    }

    public Graphics_Panel getCurrentPanel(){
        return currentPanel;
    }

    public String getCurrentPanelName(){
        for(String name : panels.keySet()){
            if(panels.get(name) == currentPanel){
                return name;
            }
        }
        return null;
    }
}