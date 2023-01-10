package code.IO.OutPut.Graphics;

import javax.swing.*;

public class Graphics_Frame {
    private JFrame frame;
    private int width;
    private int height;
    private String title;

    private final Graphics_Panel panel;

    public Graphics_Frame(int width, int height, String title, Graphics_Panel panel) {
        this.width = width;
        this.height = height;
        this.title = title;
        this.panel = panel;

        initFrame();
    }

    private void initFrame(){
        frame = new JFrame(title){
            @Override
            public void paint(java.awt.Graphics g) {
                super.paint(g);
                panel.getPannel().paint(g);
                System.out.println("Frame: " + frame.getWidth() + " " + frame.getHeight());
            }
        };
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel.getPannel());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void frame(){
        frame.repaint();
    }

    public JFrame getFrame(){
        return frame;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public String getTitle(){
        return title;
    }

    public void setWidth(int width){
        this.width = width;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public void setTitle(String title){
        this.title = title;
    }

}