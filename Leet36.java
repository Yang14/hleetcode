package ojLeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Mryang on 15-5-12.
 */
public class Leet36 {

    public static void main(String[] args) {
        char[][] board = {
                "..5.....6".toCharArray(),
                "....14...".toCharArray(),
                ".........".toCharArray(),
                ".....92..".toCharArray(),
                "5....2...".toCharArray(),
                ".......3.".toCharArray(),
                "...54....".toCharArray(),
                "3.....42.".toCharArray(),
                "...27.6..".toCharArray()};
        boolean r = isValidSudoku(board);
        System.out.println(r);
    }

    public static boolean isValidSudoku(char[][] board) {

        Set<Character> set = new HashSet<Character>();
        set.clear();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;
                if (set.contains(board[i][j]))
                    return false;
                set.add(board[i][j]);
            }
            set.clear();
        }
        set.clear();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.')
                    continue;
                if (set.contains(board[j][i]))
                    return false;
                set.add(board[j][i]);
            }
            set.clear();
        }
        set.clear();
        for (int i = 1; i <= 3; ++i) {
            for (int k = 0; k < 9; k++) {
                for (int j = 3 * (i - 1); j < 3 * i; j++) {
                    if(board[k][j] == '.')
                        continue;
                    if (set.contains(board[k][j]))
                        return false;
                    set.add(board[k][j]);
                }
                if ((k + 1) % 3 == 0)
                    set.clear();
            }
        }
        return true;
    }
}
