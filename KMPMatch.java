package ojLeetCode;

/**
 * Created by Mryang on 15-4-12.
 */
public class KMPMatch {

    public static int simpleMatch(String t, String m) {

        if (t == null) return -1;

        char[] tc = t.toCharArray();
        char[] mc = m.toCharArray();
        int i = 0, j = 0;
        while (i < tc.length && j < mc.length) {
            if (tc[i] == mc[j]) {
                ++i;
                ++j;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == mc.length) return i - j;

        return -1;
    }

    public static int[] getNext(String m) {

        int[] next = new int[m.length()];
        char[] mc = m.toCharArray();
        int i = 0, j = -1;
        next[0] = -1;

        while (i < mc.length-1) {
            if (j == -1 || mc[i] == mc[j]) {
                ++i;
                ++j;
                next[i] = j;
            } else j = next[j];
        }

        return next;
    }

    public static int kmpMatch(String t, String m, int[] next) {

        if (t == null) return -1;

        char[] tc = t.toCharArray();
        char[] mc = m.toCharArray();
        int i = 0, j = 0;
        while (i < tc.length && j < mc.length) {
            if (j == -1 || tc[i] == mc[j]) {
                ++i;
                ++j;
            } else {
                j = next[j];
            }
        }
        if (j == mc.length) return i - j;

        return -1;
    }


    public static void main(String[] args) {
        String t = "banananobano";
        String m = "anob";

        int r = simpleMatch(t, m);
        System.out.println(t.substring(r));

        int[] next = getNext(m);
        r = kmpMatch(t, m,next);
        System.out.println(t.substring(r));
    }
}
