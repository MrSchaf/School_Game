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

    public World(int seed, int chunkSize, int tileSize_Ratio, Generation generation) {
        this.seed = seed;
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

    public Hashtable<String, Vector<Object>> getObjects(int x, int y, int width, int height){
        int minX = (x - (width/2));
        int maxX = (x + (width/2));

        int minY = (y - (height/2));
        int maxY = (y + (height/2));

        Coordinate min = new Coordinate(minX, minY);
        Coordinate max = new Coordinate(maxX, maxY);

        Hashtable<String, Vector<Object>> objects = new Hashtable<>();

        Vector<Object> entityVector = new Vector<>();
        for (int i = 0; i < entities.size(); i++) {
            entities.forEach((s, entity) -> {
                if (entity.intersects(min, max)) {
                    entityVector.add(entity);
                }
            });
        }

        Vector<Object> chunkTilesVector = new Vector<>();
        Vector<World_Chunk> chunkVector = new Vector<>();
        chunks.forEach((coordinate, chunk) -> {
            Coordinate chunkMin = coordinate;
            Coordinate chunkMax = new Coordinate((coordinate.getX() + chunkSize), (coordinate.getY() + chunkSize));
            if (chunkMin.toBottomRight(min) && chunkMin.toTopLeft(max)) {
                chunkVector.add(chunk);
            } else if(chunkMax.toBottomRight(min) && chunkMax.toTopLeft(max)){
                chunkVector.add(chunk);
            }
        });

        for (World_Chunk world_chunk : chunkVector) {
            for (int j = 0; j < world_chunk.getTiles().length; j++) {
                if (world_chunk.getTiles()[j].intersects(min, max)) {
                    chunkTilesVector.add(world_chunk.getTiles()[j]);
                }
            }
        }

        objects.put("entities", entityVector);
        objects.put("Tiles", chunkTilesVector);

        return objects;
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
                    if (chunk.intersects(object)) {
                        intersects.set(true);
                    }
                }
            });
        }
        return intersects.get();
    }
}