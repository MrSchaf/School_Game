package code.IO.OutPut.Graphics;

import code.IO.OutPut.Graphics.Graphics_Game.Game_Image.Resolution;
import code.IO.OutPut.Graphics.Panels.Game_Panel;
import code.IO.OutPut.Graphics.Panels.Menu_Panel;

import javax.swing.*;

public class Graphics_Frame {
    private JFrame frame;
    private Resolution size;
    private String title;

    private Graphics_ContentPane contentPane;

    public Graphics_Frame(Resolution resolution, String title) {
        size = resolution;
        this.title = title;

        initFrame();
        initPanel();

        frame.setVisible(true);
    }

    private void initFrame(){
        frame = new JFrame(title);
        frame.setSize(size.getWidth(), size.getHeight());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }

    private void initPanel(){
        contentPane = new Graphics_ContentPane(this.frame, size);
        contentPane.addPanel("Game", new Game_Panel(size));
        contentPane.addPanel("Menu", new Menu_Panel(size));
        contentPane.setCurrentPanel("Menu");

        frame.setContentPane(contentPane.getContainer());
    }

    public void frame(){
        setSize(new Resolution(frame.getWidth(), frame.getHeight()));
        System.out.println("Frame: " + frame.getWidth() + " " + frame.getHeight());
        contentPane.paint();
        frame.repaint();

    }

    public JFrame getFrame(){
        return frame;
    }

    public Resolution getSize(){
        return size;
    }

    public String getTitle(){
        return title;
    }

    public void setSize(Resolution size){
        this.size = size;
        contentPane.setSize(size);
    }

    public void setTitle(String title){
        this.title = title;
    }

    public Graphics_ContentPane getContentPane(){
        return contentPane;
    }

    public String getCurrentPanelName(){
        return contentPane.getCurrentPanelName();
    }

    public void changePanel(String name){
        contentPane.setCurrentPanel(name);
    }
}