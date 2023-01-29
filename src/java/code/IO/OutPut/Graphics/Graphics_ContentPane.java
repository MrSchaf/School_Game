package code.IO.OutPut.Graphics;

import code.IO.InPut.In_Keyboard.In_KeyListener;
import code.IO.OutPut.Graphics.Graphics_Game.Game_Image.Resolution;
import code.IO.OutPut.Graphics.Panels.Graphics_Panel;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class Graphics_ContentPane {
    private final JFrame frame;
    private final Container contentPane;
    private final HashMap<String,Graphics_Panel> panels;
    private Graphics_Panel currentPanel;

    private Resolution resolution;

    public Graphics_ContentPane(JFrame frame, Resolution resolution) {
        this.frame = frame;
        this.contentPane = frame.getContentPane();
        panels = new HashMap<>();
        this.resolution = resolution;
    }

    public void paint(){
        currentPanel.paint();
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

    public Resolution getSize(){
        return resolution;
    }

    public void setSize(Resolution resolution){
        this.resolution = resolution;
        for (String name : panels.keySet()) {
            panels.get(name).setSize(resolution);
        }
    }

    public void addKeyListener(In_KeyListener actionListener){
        for (String name : panels.keySet()) {
            panels.get(name).addKeyListener(actionListener);
        }
    }

    public void requestFocus(){
        for (String name: panels.keySet()){
            panels.get(name).requestFocus();
        }
    }
}