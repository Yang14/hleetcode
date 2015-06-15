package ojLeetCode;

/**
 * Created by Mryang on 15-5-12.
 */
public class Leet6 {

    public String convert(String s, int numRows) {
        StringBuffer sb = new StringBuffer();
        char[] cs = s.toCharArray();
        int c = 2 * numRows - 2;
        for (int i = 0; i < numRows; ++i) {
            if (i == 0 || i == numRows - 1) {
                int j = i;
                while (j < cs.length) {
                    System.out.print(cs[j] + " ");
                    j += c;
                }
                System.out.println();
            } else {
                int j = i;
                int k = c - 2 + i;
                while (j < cs.length && k < cs.length) {
                    System.out.print(cs[j] + " ");
                    System.out.print(cs[k] + " ");
                    j += c;
                    k += c;
                }
                System.out.println();
            }
        }

        return "";
    }

    public static void main(String[] args) {
        new Leet6().convert("PAYPALISHIRING", 3);
    }
}
