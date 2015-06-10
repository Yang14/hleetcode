package ojLeetCode;

/**
 * Created by Mryang on 15-6-4.
 */
public class Leet62 {
    public static void main(String[] args) {
        int r = uniquePaths(1,1);
        System.out.println("unique path: " + r);
    }

    public static int uniquePaths(int m, int n) {
        int[][] path = new int[m + 1][n + 1];

        path[1][1] = 1;

        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (i - 1 > 0)
                    path[i][j] += path[i - 1][j];
                if (j - 1 > 0)
                    path[i][j] += path[i][j - 1];
            }
        }
        return path[m][n];
    }
}
