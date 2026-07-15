import java.util.*;

class NeighborSum {

    private int[][] grid;
    private Map<Integer, int[]> pos;

    public NeighborSum(int[][] grid) {

        this.grid = grid;

        pos = new HashMap<>();

        int n = grid.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                pos.put(
                        grid[i][j],
                        new int[]{i, j}
                );
            }
        }
    }

    public int adjacentSum(int value) {

        int[] p = pos.get(value);

        int r = p[0];
        int c = p[1];

        int n = grid.length;

        int sum = 0;

        int[][] dir = {
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1}
        };

        for (int[] d : dir) {

            int nr = r + d[0];
            int nc = c + d[1];

            if (nr >= 0 &&
                    nr < n &&
                    nc >= 0 &&
                    nc < n) {

                sum += grid[nr][nc];
            }
        }

        return sum;
    }

    public int diagonalSum(int value) {

        int[] p = pos.get(value);

        int r = p[0];
        int c = p[1];

        int n = grid.length;

        int sum = 0;

        int[][] diag = {
                {-1, -1},
                {-1, 1},
                {1, -1},
                {1, 1}
        };

        for (int[] d : diag) {

            int nr = r + d[0];
            int nc = c + d[1];

            if (nr >= 0 &&
                    nr < n &&
                    nc >= 0 &&
                    nc < n) {

                sum += grid[nr][nc];
            }
        }

        return sum;
    }
}