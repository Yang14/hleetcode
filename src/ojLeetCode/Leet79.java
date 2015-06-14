package ojLeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mryang on 15-6-4.
 */
public class Leet79 {
    public static void main(String[] args) {
        char[][] board = {
                "ABCE".toCharArray(),
                "SFCS".toCharArray(),
                "ADEE".toCharArray(),
        };
        String word = "SEE";
        boolean r = exist(board, word);
        System.out.println("search result is: " + r);
    }

    public static boolean exist(char[][] board, String word) {
        List<Integer> list = new ArrayList<Integer>();


        return searchChar(word.toCharArray(),board,1,board.length,board[0].length,1,3);
    }

    public static boolean searchChar(char[] w, char[][] b, int idx, int m, int n, int i, int j) {
        if (i >= m || j >= n) return false;

        if (b[i][j] != w[idx]) return false;

        if (idx >= w.length ) return false;

        int[][] choice = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int[] e : choice) {
            i += e[0];
            j += e[1];
            boolean r = searchChar(w, b, idx + 1, m, n, i, j);
            if (r && idx+1 == w.length)
                return true;
            else {
                i -= e[0];
                j -= e[1];
            }
        }
        return false;
    }

}
