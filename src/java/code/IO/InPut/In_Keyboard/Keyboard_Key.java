package code.IO.InPut.In_Keyboard;

public class Keyboard_Key {
    private final int code;
    private final String name;
    private boolean pressed;

    public Keyboard_Key(int code, String name){
        this.code = code;
        this.name = name;
        pressed = false;
    }

    public int getCode(){
        return code;
    }

    public String getName(){
        return name;
    }

    public boolean isPressed(){
        return pressed;
    }

    public void setPressed(boolean pressed){
        this.pressed = pressed;
    }
}
