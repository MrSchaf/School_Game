package code.Calc.Game.World;

import code.Calc.Game.Objects.Object;
import code.Calc.Game.Objects.Object_Images.Images;
import code.Calc.Math.Math;

public class World_Chunk {
    private Coordinate chunckCoordinate;
    private Coordinate realCoordinate;
    private final int chunkSize;
    private final int size;

    private World_Tile[][] tiles;

    public World_Chunk(){
        this(new Coordinate(0, 0), 0, 0, null);
    }

    public World_Chunk(Coordinate coordinate, int chunkSize, int tileSize, Images images) {
        this.realCoordinate = new Coordinate(coordinate.getX(), coordinate.getY());
        this.chunkSize = chunkSize;
        this.size = chunkSize * tileSize;
        this.chunckCoordinate = new Coordinate(coordinate.getX() / size, coordinate.getY() / size);
        tiles = new World_Tile[chunkSize][chunkSize];
    }

    public Coordinate getChunkCoordinate() {
        return new Coordinate(getChunkX(), getChunkY());
    }

    public int getChunkX() {
        return chunckCoordinate.getX();
    }

    public int getChunkY() {
        return chunckCoordinate.getY();
    }

    public Coordinate getRealCoordinate() {
        return new Coordinate(getRealX(), getRealY());
    }

    public int getRealX() {
        return chunckCoordinate.getX() * size;
    }

    public int getRealY() {
        return chunckCoordinate.getY() * size;
    }

    public int getChunkSize(){
        return chunkSize;
    }

    public int getSize(){
        return size;
    }

    public World_Tile[][] getTiles(){
        return tiles;
    }

    public World_Tile getObject(int x, int y) {
        return tiles[x][y];
    }

    public World_Tile getObject(Coordinate coordinate) {
        return tiles[coordinate.getX()][coordinate.getY()];
    }

    public void setChunkCoordinate(Coordinate chunckCoordinate) {
        this.chunckCoordinate = chunckCoordinate;
    }

    public void setChunkX(int x) {
        this.chunckCoordinate.setX(x);
    }

    public void setChunkY(int y) {
        this.chunckCoordinate.setY(y);
    }

    public void setRealCoordinate(Coordinate realCoordinate) {
        this.realCoordinate = realCoordinate;
    }

    public void setRealX(int x) {
        this.realCoordinate.setX(x);
    }

    public void setRealY(int y) {
        this.realCoordinate.setY(y);
    }

    public void setTiles(World_Tile[][] tiles){
        this.tiles = tiles;
    }

    public void setObject(int x, int y, World_Tile tile) {
        tiles[x][y] = tile;
    }

    public void setObject(Coordinate coordinate, World_Tile tile) {
        tiles[coordinate.getX()][coordinate.getY()] = tile;
    }

    public static Coordinate getChunkCoordinate(Coordinate coordinate, int size) {
        return new Coordinate(coordinate.getX() / size, coordinate.getY() / size);
    }

    public static Coordinate getRealCoordinate(Coordinate coordinate, int size) {
        return new Coordinate(coordinate.getX() * size, coordinate.getY() * size);
    }

    public boolean collides(Object object) {
        for (World_Tile[] slice : tiles) {
            for (World_Tile tile: slice) {
                if (tile != null && tile.intersects(object) && tile.isSolid()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean intersects(Coordinate min, Coordinate max) {
        boolean intersects;

        Coordinate chunkMin = getChunkCoordinate();
        Coordinate chunkMax = new Coordinate((chunckCoordinate.getX() + size), (chunckCoordinate.getY() + size));

        intersects = Math.intersects(min, max, chunkMin, chunkMax);

        return intersects;
    }

    public void setTile(int x, int y, World_Tile tile) {
        tiles[x][y] = tile;
    }

    public boolean intersects(Object object) {
        boolean intersects;

        Coordinate chunkMin = getChunkCoordinate();
        Coordinate chunkMax = new Coordinate((chunckCoordinate.getX() + size), (chunckCoordinate.getY() + size));

        intersects = object.intersects(chunkMin, chunkMax);

        return intersects;
    }
}