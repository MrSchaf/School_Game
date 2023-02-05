package code.Calc.Game.World;

import code.Calc.Actions.Action_Listener;
import code.Calc.Game.Objects.Hitbox.HitBox;
import code.Calc.Game.Objects.Object;
import code.Calc.Game.Objects.Object_Images.Images;
import code.Calc.Game.Player.Player;
import code.Calc.Game.World.Generation.Generation;
import code.Calc.Game.World.Generation.Generation_NoGen;
import code.Game;
import code.IO.InPut.In_Keyboard.Keyboard_Key;

import java.awt.*;
import java.util.Hashtable;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class World {
    private final int seed;
    private final int chunkSize;
    private final int tileSize;
    private final Images images;
    private final Generation generation;
    private final Game game;

    private final Player player;

    private final Hashtable<String, Object> entities;
    private final Hashtable<Coordinate, World_Chunk> chunks;

    public World(int chunkSize, int tileSize, Generation generation, Images images, Game game) {
        this.seed = getSeed();
        this.chunkSize = chunkSize;
        this.tileSize = tileSize;
        this.generation = new Generation_NoGen(chunkSize, this);
        this.game = game;
        this.images = images;

        this.entities = new Hashtable<>();
        this.chunks = new Hashtable<>();

        this.player = new Player("Player", new Coordinate(0,0), new HitBox(new Rectangle(10, 10), new Coordinate(0,0), 0), "player", this);
        addEntity("Player", player);
    }

    public boolean addEntity(String name, Object object){
        boolean added = false;

        if(!entities.containsKey(name)){
            entities.put(name, object);
            added = true;
        }

        return added;
    }

    public boolean removeEntity(String name){
        boolean removed = false;

        if(entities.containsKey(name)){
            entities.remove(name);
            removed = true;
        }

        return removed;
    }

    public void generateChunks(Coordinate coordinate){
        Coordinate chunkCoordinate = World_Chunk.getChunkCoordinate(coordinate, chunkSize);
        int x = chunkCoordinate.getX();
        int y = chunkCoordinate.getY();

        for (int i = -4; i < 4; i++) {
            for (int j = -4; j < 4; j++) {
                addChunk(new Coordinate(x + i, y + j));
            }
        }
    }

    public void addChunk(Coordinate chunkCoordinate){
        if(!chunkExists(chunkCoordinate)){
            Coordinate coordinate = World_Chunk.getRealCoordinate(chunkCoordinate, chunkSize);

//            coordinate = new Coordinate(coordinate.getX() * chunkSize * tileSize, coordinate.getY() * chunkSize * tileSize);
//            World_Chunk chunk = generation.generateChunk(coordinate, chunkSize, tileSize, seed, images);
//            chunks.put(coordinate, chunk);
//            System.out.println("Put: " + coordinate);
        }
    }

    public boolean intersects(Object object) {
        AtomicBoolean intersects = new AtomicBoolean(false);
        for (int i = 0; i < chunks.size(); i++) {
            chunks.forEach((coordinate, chunk) -> {
                for (int j = 0; j < chunk.getTiles().length; j++) {
                    if (chunk.intersects(object)) {
                        intersects.set(true);
                    }
                }
            });
        }
        return intersects.get();
    }

    public void tick(){
        player.tick();
    }

    public int getSeed() {
        return (int) (Math.random() * 1_000_000);
    }

    public int getTileSize() {
        return tileSize;
    }

    public Vector<Object> getEntities() {
        return new Vector<>(entities.values());
    }

    public Vector<World_Chunk> getChunks() {
        return new Vector<>(chunks.values());
    }

    public Images getImages() {
        return images;
    }

    public void addKeyListener(Action_Listener action_listener, Keyboard_Key key){
        game.addKeyListener(action_listener, key);
    }

    public boolean chunkExists(Coordinate coordinate){
        AtomicBoolean exists = new AtomicBoolean(false);
        for (int i = 0; i < chunks.size(); i++) {
            chunks.forEach((chunckCoord, chunk) -> {
                chunckCoord = World_Chunk.getRealCoordinate(chunckCoord, chunkSize);
                if(chunckCoord.equals(coordinate)){
                    exists.set(true);
                }
            });
        }
        return exists.get();
    }

    public World_Chunk getChunk(Coordinate coordinate){
        AtomicReference<World_Chunk> chunk = new AtomicReference<>();
        for (int i = 0; i < chunks.size(); i++) {
            chunks.forEach((coordinate1, chunk1) -> {
                coordinate1 = World_Chunk.getRealCoordinate(coordinate1, chunkSize);
                if(coordinate1.equals(coordinate)){
                    chunk.set(chunk1);
                }
            });
        }
        return chunk.get();
    }

    public boolean collides(Object object) {
        AtomicBoolean collides = new AtomicBoolean(false);
        Coordinate coordinate = World_Chunk.getRealCoordinate(object.getCoordinate(), chunkSize);
        int size = chunkSize * tileSize;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                Coordinate coordinate1 = World_Chunk.getRealCoordinate(new Coordinate(coordinate.getX()* size + i * size, coordinate.getY()* size + j * size), chunkSize);
                if(chunkExists(coordinate1)){
                    World_Chunk chunk = getChunk(coordinate1);
                    if(chunk.collides(object)){
                        collides.set(true);
                    }
                }
            }
        }
        entities.forEach((s, object1) -> {
            if(object1.collides(object)){
                collides.set(true);
            }
        });

        return collides.get();
    }

    public void setCamera(Coordinate coordinate){
        game.setCamera(coordinate);
    }
}