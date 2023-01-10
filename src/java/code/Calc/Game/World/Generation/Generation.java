package code.Calc.Game.World.Generation;


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