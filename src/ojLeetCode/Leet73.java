package ojLeetCode;

import java.util.*;
/**
 * Created by Mryang on 15-6-4.
 */
public class Leet73 {
    public static void main(String[] args) {
        int[][] m = {
                {0,2},
        };
        setZeroes(m);
        for (int[] row : m){
            for (int e : row){
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }

    public static void setZeroes(int[][] matrix) {
        List<Integer> row = new ArrayList<Integer>();
        List<Integer> col = new ArrayList<Integer>();
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i=0;i<m;++i){
            for (int j=0;j<n;++j){
                if (matrix[i][j] == 0){
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for (int e : row){
            for (int i=0;i<n;++i)
                matrix[e][i] = 0;
        }
        for (int e : col){
            for (int i=0;i<m;++i)
                matrix[i][e] = 0;
        }
    }

}
