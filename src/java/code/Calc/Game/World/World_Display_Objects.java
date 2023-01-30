package code.Calc.Game.World;

import code.Calc.Game.Objects.Object;
import code.Calc.Game.Objects.Object_Images.Images;
import code.IO.OutPut.Graphics.Graphics_Game.Game_Image.Resolution;

import java.util.Hashtable;
import java.util.Vector;

public class World_Display_Objects {
    private Coordinate coordinate;
    private Resolution resolution;
    private Coordinate middle;
    private double scale;
    private final World world;
    private final Images images;
    private final int tileSize;

    Hashtable<String, Vector<Object>> objects;
    private Vector<Object> entities;
    private Vector<Object> tiles;

    public World_Display_Objects(Resolution resolution, double scale, World world, Coordinate coordinate){
        this.resolution = resolution;
        this.coordinate = coordinate;
        this.middle = new Coordinate(resolution.getWidth() / 2, resolution.getHeight() / 2);
        this.scale = scale;
        this.tileSize = world.getTileSize();
        this.world = world;
        this.images = world.getImages();

        this.objects = new Hashtable<>();
        this.entities = new Vector<>();
        this.tiles = new Vector<>();

        objects.put("entities", entities);
        objects.put("tiles", tiles);
    }

    public void setObjects(){
        int minX = coordinate.getX() - (resolution.getWidth() / 2);
        int minY = coordinate.getY() -  (resolution.getHeight() / 2);
        Coordinate min = new Coordinate(minX, minY);

        int maxX = coordinate.getX() + (resolution.getWidth() / 2);
        int maxY = coordinate.getY() + (resolution.getHeight() / 2);
        Coordinate max = new Coordinate(maxX, maxY);

        Vector<Object> entityVector = world.getEntities();
        this.entities = setEntities(entityVector, min, max);

        Vector<World_Chunk> chunkVector = world.getChunks();
        this.tiles = setTiles(chunkVector, min, max);
    }

    public Vector<Object> setTiles(Vector<World_Chunk> chunks, Coordinate min, Coordinate max) {
        Vector<World_Chunk> chunkVector = setChunks(chunks, min, max);
        Vector<Object> tileVector = new Vector<>();

        for (World_Chunk world_chunk : chunkVector) {
            for (int j = 0; j < world_chunk.getTiles().length; j++) {
                for (int i = 0; i < world_chunk.getTiles()[j].length; i++) {
                    if (world_chunk.getTiles()[j][i].intersects(min, max)) {
                        tileVector.add(world_chunk.getTiles()[j][i]);
                    }
                }
            }
        }

        return tileVector;
    }

    public Vector<World_Chunk> setChunks(Vector<World_Chunk> chunks, Coordinate min, Coordinate max){
        Vector<World_Chunk> chunkVector = new Vector<>();

        for (int i = 0; i < chunks.size(); i++) {
            World_Chunk chunk = chunks.get(i);
            if (chunk.intersects(min, max)) {
                chunkVector.add(chunk);
            }
        }
        return chunkVector;
    }

    public Vector<Object> setEntities(Vector<Object> entities, Coordinate min, Coordinate max){
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

    public Vector<Object> getEntities() {
        return entities;
    }

    public Vector<Object> getTiles() {
        return tiles;
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

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
        int x = coordinate.getX() + (resolution.getWidth() / 2);
        int y = coordinate.getY() + (resolution.getHeight() / 2);
        this.middle = new Coordinate(x, y);
    }

    public void setMiddle(Coordinate middle) {
        this.middle = middle;
        int x = middle.getX() - (resolution.getWidth() / 2);
        int y = middle.getY() - (resolution.getHeight() / 2);
        this.coordinate = new Coordinate(x, y);
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Coordinate getMiddle() {
        return middle;
    }

    public int getMiddleX() {
        return middle.getX();
    }

    public int getMiddleY() {
        return middle.getY();
    }

    public Images getImages() {
        return images;
    }
}