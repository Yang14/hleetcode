package ojLeetCode;

/**
 * Created by Mryang on 15-6-4.
 */
public class Leet64 {
    public static void main(String[] args) {
        int[][] grid = {
                {3,2},{1,1}
        };
        int r = minPathSum(grid);
        System.out.println("min path sum: " + r);
    }

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int min ;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i==0 && j==0) continue;
                min = Integer.MAX_VALUE;
                if (i > 0)
                    min = grid[i-1][j];
                if (j > 0)
                    min = min < grid[i][j-1] ? min : grid[i][j-1];
                grid[i][j] += min;
            }
        }
        return grid[m-1][n-1];
    }


}
