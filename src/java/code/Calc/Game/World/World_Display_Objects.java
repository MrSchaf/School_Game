package code.Calc.Game.World;

import code.Calc.Game.Objects.Object;
import code.IO.OutPut.Graphics.Graphics_Game.Game_Image.Resolution;

import java.util.Hashtable;
import java.util.Vector;

public class World_Display_Objects {
    private Coordinate coordinate;
    private Resolution resolution;
    private double scale;
    private World world;
    private final int tileSize;

    Hashtable<String, Vector<Object>> objects;
    private Vector<Object> enteties;
    private Vector<Object> tiles;

    // private

    public World_Display_Objects(Resolution resolution, double scale, World world){
        this.resolution = resolution;
        this.scale = scale;
        this.tileSize = world.getTileSize();

        this.objects = new Hashtable<>();
        this.enteties = new Vector<>();
        this.tiles = new Vector<>();

        objects.put("entities", enteties);
        objects.put("tiles", tiles);
    }

    public void setObjects(){
        int minX = (resolution.getWidth() / 2) / tileSize;
        int maxX = (resolution.getWidth() / 2) / tileSize;

        int minY = (resolution.getHeight() / 2) / tileSize;
        int maxY = (resolution.getHeight() / 2) / tileSize;

        Coordinate min = new Coordinate(minX, minY);
        Coordinate max = new Coordinate(maxX, maxY);

        Vector<Object> entities = world.getEntities();
        enteties = getEntities(entities, min, max);

        Vector<World_Chunk> chunks = world.getChunks();
        tiles = getTiles(chunks, min, max);
    }

    public Vector<Object> getTiles(Vector<World_Chunk> chunks, Coordinate min, Coordinate max) {
        Vector<World_Chunk> chunkVector = getChunks(chunks, min, max);
        Vector<Object> tileVector = new Vector<>();

        for (World_Chunk world_chunk : chunkVector) {
            for (int j = 0; j < world_chunk.getTiles().length; j++) {
                if (world_chunk.getTiles()[j].intersects(min, max)) {
                    tileVector.add(world_chunk.getTiles()[j]);
                }
            }
        }

        return tileVector;
    }

    public Vector<World_Chunk> getChunks(Vector<World_Chunk> chunks, Coordinate min, Coordinate max){
        Vector<World_Chunk> chunkVector = new Vector<>();

        for (int i = 0; i < chunks.size(); i++) {
            World_Chunk chunk = chunks.get(i);
            if (chunk.intersects(min, max)) {
                chunkVector.add(chunk);
            }
        }
        return chunkVector;
    }

    public Vector<Object> getEntities(Vector<Object> entities, Coordinate min, Coordinate max){
        Vector<Object> entityVector = new Vector<>();

        for (int i = 0; i < entities.size(); i++) {
            Object entity = entities.get(i);
            if (entity.intersects(min, max)) {
                entityVector.add(entity);
            }
        }

        return entityVector;
    }

    public Hashtable<String, Vector<Object>> getObjects() {
        return objects;
    }

    public Resolution getResolution() {
        return resolution;
    }

    public double getScale() {
        return scale;
    }

    public void setResolution(Resolution resolution) {
        this.resolution = resolution;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }
}