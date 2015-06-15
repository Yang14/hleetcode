package ojLeetCode;

/**
 * Created by Mryang on 15-6-4.
 */
public class Leet48 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {5, 6, 7},
                {9, 10, 11}
        };
        rotate(matrix);

        for (int[] m : matrix) {
            for (int e : m) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int temp;

        /*
        *      1.{1, 2, 3},
                {5, 6, 7},
                {9, 10, 11}
               2.
                 1,5,9
                 2,6,10
                 3,7,11
               3.得到目标矩阵
                 9,5,1
                 10,6,2
                 11,7,3

        * */
        //第一步矩阵转置
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //第二步按行交换数字
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n / 2; ++j) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }
}
