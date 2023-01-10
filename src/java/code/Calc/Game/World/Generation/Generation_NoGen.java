package code.Calc.Game.World.Generation;

public class Generation_NoGen extends Generation {

    public Generation_NoGen(int gridSize) {
        super(gridSize, 0, 0, 0);
    }

    @Override
    public void genTerrain(int x, int y) {
        for (int[] a : map) {
            for (int b : a){
                y = 0;
            }
        }

        map[x][y] = 0;
    }
}