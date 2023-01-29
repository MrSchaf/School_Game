package code.Calc.Game.World;

import code.Calc.Game.Objects.Object;
import code.Calc.Game.Objects.Object_Images.Images;

public class World_Chunk {
    private Coordinate coordinate;
    private int width;
    private int height;

    private World_Tile[][] tiles;

    public World_Chunk(Coordinate coordinate, int width, int height, int tileSize, Images images) {
        this.coordinate = new Coordinate(coordinate.getX() * width * tileSize, coordinate.getY() * height * tileSize);
        this.width = width * tileSize;
        this.height = height * tileSize;
        tiles = new World_Tile[width][height];
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

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
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

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
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
                if (tile != null && tile.intersects(object)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean intersects(Coordinate max, Coordinate min){
        Coordinate chunkMin = getCoordinate();
        Coordinate chunkMax = new Coordinate((coordinate.getX() + width), (coordinate.getY() + height));
        System.out.println(chunkMin.getX() + " " + chunkMin.getY() + " " + chunkMax.getX() + " " + chunkMax.getY());
        if (chunkMin.toBottomRight(max) && chunkMin.toTopLeft(min)) {
            return true;
        } else if(chunkMax.toBottomRight(max) && chunkMax.toTopLeft(min)){
            return true;
        }
        return false;
    }

    public void setTile(int x, int y, World_Tile tile) {
        tiles[x][y] = tile;
    }
}