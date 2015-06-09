package ojLeetCode;

/**
 * Created by Mryang on 15-6-4.
 */
public class Leet63 {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0},
                {0, 0, 1},
        };
        int r = uniquePathsWithObstacles(grid);
        System.out.println("unique path II: " + r);
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1         //出发点和结束点中一个是1就直接返回0，表示没有可以通过的路径
                || obstacleGrid[m - 1][n - 1] == 1) return 0;

        int[][] path = new int[m][n];
        path[0][0] = 1;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i > 0 && obstacleGrid[i - 1][j] == 0)
                    path[i][j] += path[i - 1][j];
                if (j > 0 && obstacleGrid[i][j - 1] == 0)
                    path[i][j] += path[i][j - 1];
            }
        }
        return path[m - 1][n - 1];
    }
}
