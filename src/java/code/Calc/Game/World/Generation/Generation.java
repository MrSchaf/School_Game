package code.Calc.Game.World.Generation;

import code.Calc.Game.Objects.Hitbox.HitBox;
import code.Calc.Game.Objects.Object_Images.Images;
import code.Calc.Game.World.Coordinate;
import code.Calc.Game.World.World_Chunk;
import code.Calc.Game.World.World_Tile;

import java.awt.*;
import java.util.Random;

public abstract class Generation {
    protected final int gridSize;
    protected int max;
    protected int min;
    protected final int seed;

    protected int[][] map;

    protected Random rnd;

    public Generation(int gridSize, int maxH, int minH, int seed) {
        this.gridSize = gridSize;
        this.max = maxH;
        this.min = minH;
        this.seed = seed;
        this.rnd = new Random(seed);

        map = new int[gridSize][gridSize];
    }

    public abstract void genTerrain(int x, int y);

    public World_Chunk generateChunk(Coordinate coordinate, int chunkSize, int tileSize, int seed, Images images) {
        World_Chunk chunk = new World_Chunk(coordinate, chunkSize, tileSize, images);
        genTerrain(coordinate.getX(), coordinate.getY());
        for (int x = 0; x < chunkSize; x++) {
            for (int y = 0; y < chunkSize; y++) {
                int coordinateX = coordinate.getX();
                int coordinateY = coordinate.getY();
                World_Tile tile = new World_Tile(new Coordinate(coordinateX, coordinateY), new HitBox(new Rectangle(coordinateX, coordinateY), new Coordinate(coordinateX, coordinateY), map[x][y]), 0, false, "tile", map[x][y]);
                chunk.setTile(coordinateX, coordinateY, tile);
            }
        }

        return chunk;
    }

//    private int calc(long x, long y, long max){
//        long aL;
//        long bL;
//        int a = 127773;
//        int b = 32749;
//        int c = 16807;
//
//        aL = ((long) a * x + (long) b * y + seed) ^ c;
//
//        if(aL < 0){
//            aL *= -1;
//        }
//
//        bL = ((long) a * x - (long) b * y + seed) ^ c;
//
//        if(bL < 0){
//            bL *= -1;
//        }
//
//        return (int)(aL % max);
//    }
}