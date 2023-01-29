package code.IO.OutPut.Graphics;

import code.Calc.Game.World.World;
import code.Game;
import code.IO.InPut.In_Keyboard.In_KeyListener;
import code.IO.OutPut.Graphics.Graphics_Game.Game_Image.Resolution;
import code.IO.OutPut.Graphics.Panels.Game_Panel;
import code.IO.OutPut.Graphics.Panels.Menu_Panel;

import javax.swing.*;
import java.awt.*;

public class Graphics_Frame {
    private JFrame frame;
    private Resolution size;
    private String title;
    private final World world;
    private final Game game;

    private boolean fullScreen;
    private Resolution preferredSize;
    private GraphicsEnvironment devices;

    private Graphics_ContentPane contentPane;

    public Graphics_Frame(Resolution resolution, String title, World world, GraphicsEnvironment devices, Game game){
        size = resolution;
        this.title = title;
        this.world = world;
        this.game = game;
        this.devices = devices;

        fullScreen = false;
        preferredSize = size;

        initFrame();
        initPanel();

        frame.setVisible(true);
        contentPane.requestFocus();
        addKeyListener(game.getKeyListener());
    }

    private void initFrame(){
        frame = new JFrame(title);
        frame.setSize(size.getWidth(), size.getHeight());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }

    private void initPanel(){
        contentPane = new Graphics_ContentPane(this.frame, size);
        contentPane.addPanel("Game", new Game_Panel(size, world));
        contentPane.addPanel("Menu", new Menu_Panel(size));
        contentPane.setCurrentPanel("Menu");

        frame.setContentPane(contentPane.getContainer());
    }

    public void addKeyListener(In_KeyListener actionListener){
        contentPane.addKeyListener(actionListener);
    }

    public void frame(){
        setSize(new Resolution(frame.getWidth(), frame.getHeight()));
        // System.out.println("Frame: " + frame.getWidth() + " " + frame.getHeight());
        contentPane.paint();
        frame.repaint();

    }

    public void changeFullscreen(boolean fullScreen){
        this.fullScreen = fullScreen;
        if (fullScreen) {
            setFullscreen();
        } else {
            setWindowed();
        }
    }

    public void changeFullscreen(){
        if(fullScreen){
            System.out.println("Windowed");
            setWindowed();
            fullScreen = false;
        } else {
            System.out.println("Fullscreen");
            preferredSize = size;
            setFullscreen();
            fullScreen = true;
        }

    }

    public void setFullscreen(){
        GraphicsDevice device = devices.getDefaultScreenDevice();
        if (device.isFullScreenSupported()) {
            frame.dispose();
            frame.setUndecorated(true);
            device.setFullScreenWindow(frame);
            frame.validate();
            contentPane.requestFocus();
        }
    }

    public void setWindowed(){
        GraphicsDevice device = devices.getDefaultScreenDevice();
        device.setFullScreenWindow(null);
        frame.dispose();
        frame.setUndecorated(false);
        frame.setSize(preferredSize.getWidth(), preferredSize.getHeight());
        frame.setVisible(true);
        contentPane.requestFocus();
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