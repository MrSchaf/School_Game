package code.Calc.Game.Player;

import code.Calc.Actions.Action_Listener;
import code.Calc.Game.Objects.Hitbox.HitBox;
import code.Calc.Game.Objects.Moving_Object;
import code.Calc.Game.World.Coordinate;
import code.Calc.Game.World.World;
import code.Calc.Math.Math;
import code.IO.InPut.In_Keyboard.Keyboard_Keys;

import java.util.Hashtable;

public class Player extends Moving_Object {
    private String name;
    private int speed;
    private final World world;

    private final Hashtable<String, Action_Listener> actions;

    public Player(String name, Coordinate coordinate, HitBox hitBox, String image, World world) {
        super(coordinate, hitBox, 0, false, image, world);
        this.name = name;
        this.world = world;

        actions = new Hashtable<>();
        initActions();
    }

    public void initActions(){
        actions.put("up", new Action_Listener() {
            @Override
            protected void actionPerformed(int code) {
                if(code == 1){
                    addVel(Math.UP);
                } else if(code == 0){
                    subVel(Math.UP);
                }
            }
        });
        world.addKeyListener(actions.get("up"), Keyboard_Keys.Key_W);

        actions.put("down", new Action_Listener() {
            @Override
            protected void actionPerformed(int code) {
                if(code == 1){
                    addVel(Math.DOWN);
                } else if(code == 0){
                    subVel(Math.DOWN);
                }
            }
        });
        world.addKeyListener(actions.get("down"), Keyboard_Keys.Key_S);

        actions.put("left", new Action_Listener() {
            @Override
            protected void actionPerformed(int code) {
                if(code == 1){
                    addVel(Math.LEFT);
                } else if(code == 0){
                    subVel(Math.LEFT);
                }
            }
        });
        world.addKeyListener(actions.get("left"), Keyboard_Keys.Key_A);

        actions.put("right", new Action_Listener() {
            @Override
            protected void actionPerformed(int code) {
                if(code == 1){
                    addVel(Math.RIGHT);
                } else if(code == 0){
                    subVel(Math.RIGHT);
                }
            }
        });
        world.addKeyListener(actions.get("right"), Keyboard_Keys.Key_D);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void generateChunks(){
        world.generateChunks(coordinate);
    }

    public void tick() {
        generateChunks();
        move();
        setCamera();
    }

    public void setCamera(){
        world.setCamera(coordinate);
    }
}