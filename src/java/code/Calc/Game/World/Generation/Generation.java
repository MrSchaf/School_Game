package code.Calc.Game.World.Generation;

import code.Calc.Game.Objects.Hitbox.HitBox;
import code.Calc.Game.Objects.Object_Images.Images;
import code.Calc.Game.World.Coordinate;
import code.Calc.Game.World.World;
import code.Calc.Game.World.World_Chunk;
import code.Calc.Game.World.World_Tile;

import java.awt.*;
import java.util.Random;

public abstract class Generation {
    protected final int gridSize;
    protected int max;
    protected int min;
    protected final int seed;
    private final World world;

    protected int[][] map;

    protected Random rnd;

    public Generation(int gridSize, int maxH, int minH, int seed, World world) {
        this.gridSize = gridSize;
        this.max = maxH;
        this.min = minH;
        this.seed = seed;
        this.rnd = new Random(seed);
        this.world = world;

        map = new int[gridSize][gridSize];
    }

    public abstract void genTerrain(int x, int y);

    public World_Chunk generateChunk(Coordinate coordinate, int chunkSize, int tileSize, int seed, Images images) {
        World_Chunk chunk = new World_Chunk(coordinate, chunkSize, tileSize, images);
        genTerrain(chunkSize, chunkSize);
        for (int x = 0; x < chunkSize; x++) {
            for (int y = 0; y < chunkSize; y++) {
                int coordinateX = coordinate.getX() + x * tileSize;
                int coordinateY = coordinate.getY() + y * tileSize;
                if(coordinateX == 0 && coordinateY == 0){
                    map[x][y] = 0;
                }
                HitBox hitBox = new HitBox(new Rectangle(tileSize, tileSize), new Coordinate(coordinateX, coordinateY), map[x][y]);
                World_Tile tile = new World_Tile(new Coordinate(coordinateX, coordinateY), hitBox, 0, false, tileSize, "tile" + map[x][y], map[x][y], world);
                chunk.setTile(x, y, tile);
            }
        }

        return chunk;
    }
}