package code.Calc.Game.World;

import code.Calc.Game.Objects.Hitbox.HitBox;
import code.Calc.Game.Objects.Object;
import code.Calc.Game.Objects.Object_Images.Images;
import code.Calc.Game.Player.Player;
import code.Calc.Game.World.Generation.Generation;

import java.awt.*;
import java.util.Hashtable;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;

public class World {
    private final int seed;
    private final int chunkSize;
    private final int tileSize;
    private final Images images;
    private final Generation generation;

    private final Player player;

    private Hashtable<String, Object> entities;
    private Hashtable<Coordinate, World_Chunk> chunks;

    public World(int chunkSize, int tileSize, Generation generation, Images images) {
        this.seed = getSeed();
        this.chunkSize = chunkSize;
        this.tileSize = tileSize;
        this.generation = generation;
        this.images = images;

        this.player = new Player("Player", new Coordinate(0, 0), new HitBox(new Rectangle(10, 10), new Coordinate(0,0), 0), "player", this);

        this.entities = new Hashtable<>();
        this.chunks = new Hashtable<>();
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
        int x = coordinate.getX();
        int y = coordinate.getY();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                addChunk(new Coordinate(x + i, y + j));
            }
        }
    }

    public void addChunk(Coordinate coordinate){
        World_Chunk chunk = generation.generateChunk(coordinate, chunkSize, tileSize, seed, images);
        if(!chunks.containsKey(coordinate)){
            chunks.put(coordinate, chunk);
        }
    }

    public boolean intersects(Object object) {
        AtomicBoolean intersects = new AtomicBoolean(false);
        for (int i = 0; i < chunks.size(); i++) {
            chunks.forEach((coordinate, chunk) -> {
                for (int j = 0; j < chunk.getTiles().length; j++) {
                    if (chunk.collides(object)) {
                        intersects.set(true);
                    }
                }
            });
        }
        return intersects.get();
    }

    public void tick(){

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
}