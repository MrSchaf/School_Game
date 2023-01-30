package code.Calc.Game.World.Generation;

import code.Calc.Game.World.World;

public class Generation_NoGen extends Generation {

    public Generation_NoGen(int gridSize, World world) {
        super(gridSize, 0, 0, 0, world);
    }

    @Override
    public void genTerrain(int x, int y) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                int r = rnd.nextInt(4);
                if (r == 0) {
                    map[i][j] = 1;
                } else {
                    map[i][j] = 0;
                }
            }
        }
    }
}