package code.Calc.Game.World;

import code.Calc.Game.Objects.Object;
import code.Calc.Game.World.Generation.Generation;

import java.util.Hashtable;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;

public class World {
    private final int seed;
    private final int chunkSize;
    private final int tileSize;

    private final Generation generation;

    private Hashtable<String, Object> entities;
    private Hashtable<Coordinate, World_Chunk> chunks;

    public World(int chunkSize, int tileSize_Ratio, Generation generation) {
        this.seed = getSeed();
        this.chunkSize = chunkSize;
        this.tileSize = tileSize_Ratio;
        this.generation = generation;
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

    public void addChunk(Coordinate coordinate, World_Chunk chunk){
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
}