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
        //回溯法：当前字符所在位置向四周寻找下一个字符所在的位置
        //如果四周某个或者某几个方向存在下个字符：
        //更新要判断的字符位置，记录当前字符，如果此路不通还可以还原
        //将字符更新为'\0'，防止寻找过程在绕圈
        //如果四周都没有：死胡同了，就返回false

        List<int[]> list = new ArrayList<int[]>();
        char[] wc = word.toCharArray();
        int m = board.length;
        int n = board[0].length;
        //先找到word第一个字符所在的位置
        for (int i=0;i<m;++i){
            for (int j=0;j<n;++j){
                if (wc[0] == board[i][j])
                    list.add(new int[]{i,j});
            }
        }
        for (int[] e : list){
            if (searchChar(wc, board, 0, m, n, e[0],e[1]) == true)
                return true;
        }
        return false;
    }

    /*w = word chars
      b = board
      idx = current index of w
      m * n = board ' width and length
      i,j = w[idx] 's position in board
    * */
    public static boolean searchChar(char[] w, char[][] b, int idx, int m, int n, int i, int j) {

        if (idx + 1 >= w.length) return true;

        int[][] choice = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int ti, tj;
        for (int[] e : choice) {
            ti = i + e[0];
            tj = j + e[1];
            if ((tj >= 0 && tj < n) && (ti >= 0 && ti < m) &&
                    (w[idx + 1] == b[ti][tj]) && (b[ti][tj] != '\0')) {
                char mark = b[i][j];
                b[i][j] = '\0';
                i += e[0];
                j += e[1];
                boolean r = searchChar(w, b, idx + 1, m, n, i, j);
                if (r)
                    return true;
                else {
                    i -= e[0];
                    j -= e[1];
                    b[i][j] = mark;
                }
            }
        }
        return false;
    }

}
