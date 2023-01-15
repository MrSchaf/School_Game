package code.IO.OutPut.Graphics;

import code.IO.OutPut.Graphics.Graphics_Game.Game_Image.Resolution;

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
        contentPane = new Graphics_ContentPane(size);
        frame.setContentPane(contentPane.getPanel());
    }

    public void frame(){
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
    }

    public void setTitle(String title){
        this.title = title;
    }

}