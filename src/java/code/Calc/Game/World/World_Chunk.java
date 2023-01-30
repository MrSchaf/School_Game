package code.Calc.Game.World;

import code.Calc.Game.Objects.Object;
import code.Calc.Game.Objects.Object_Images.Images;
import code.Calc.Math.Math;

public class World_Chunk {
    private Coordinate coordinate;
    private final int chunkSize;
    private final int size;

    private World_Tile[][] tiles;

    public World_Chunk(){
        this(new Coordinate(0, 0), 0, 0, null);
    }

    public World_Chunk(Coordinate coordinate, int chunkSize, int tileSize, Images images) {
        this.coordinate = new Coordinate(coordinate.getX(), coordinate.getY());
        this.chunkSize = chunkSize;
        this.size = chunkSize * tileSize;
        tiles = new World_Tile[chunkSize][chunkSize];
    }

    public Coordinate getCoordinate() {
        return new Coordinate(getX(), getY());
    }

    public int getX() {
        return coordinate.getX();
    }

    public int getY() {
        return coordinate.getY();
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

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public void setX(int x) {
        this.coordinate.setX(x);
    }

    public void setY(int y) {
        this.coordinate.setY(y);
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

        Coordinate chunkMin = getCoordinate();
        Coordinate chunkMax = new Coordinate((coordinate.getX() + size), (coordinate.getY() + size));

        intersects = Math.intersects(min, max, chunkMin, chunkMax);

        return intersects;
    }

    public void setTile(int x, int y, World_Tile tile) {
        tiles[x][y] = tile;
    }

    public boolean intersects(Object object) {
        boolean intersects;

        Coordinate chunkMin = getCoordinate();
        Coordinate chunkMax = new Coordinate((coordinate.getX() + size), (coordinate.getY() + size));

        intersects = object.intersects(chunkMin, chunkMax);

        return intersects;
    }
}