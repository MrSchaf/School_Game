package code.IO.OutPut.Graphics.Graphics_Game.Game_Image;

public class Resolution {
    private int width;
    private int height;

    public static final Resolution RES_4K = new Resolution(3840, 2160);
    public static final Resolution RES_1440p = new Resolution(2560, 1440);
    public static final Resolution RES_HD = new Resolution(1920, 1080);
    public static final Resolution RES_720p = new Resolution(1280, 720);
    public static final Resolution RES_480p = new Resolution(854, 480);
    public static final Resolution RES_360p = new Resolution(640, 360);
    public static final Resolution RES_240p = new Resolution(426, 240);
    public static final Resolution RES_144p = new Resolution(256, 144);

    public Resolution(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public void setWidth(int width){
        this.width = width;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public void set(int width, int height){
        this.width = width;
        this.height = height;
    }
}