package ojLeetCode;

/**
 * Created by Mryang on 15-6-4.
 */
public class Leet76 {
    public static void main(String[] args) {
        String s = "bbaa";
        String t = "aba";
        String r = minWindow(s, t);
        System.out.print("min window :" + r);
    }

    public static String minWindow(String s, String t) {
        String r = "";

        int[] shm = new int[256];
        int[] thm = new int[256];
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();

        for (char e : cs)
            shm[e]++;
        for (char e : ct)
            thm[e]++;
        for (char e : ct) {
            if (shm[e] < thm[e])
                return "";
        }

        int beg = 0, end = cs.length - 1;

        /*while (beg < end) {
            if (thm[cs[beg]] == 0){
                beg++;
            }else if (thm[cs[end]] == 0){
                end--;
            }
            if (thm[cs[beg]] != 0 && shm[cs[beg]] > 1) {
                shm[cs[beg]]--;
                beg++;
            }
            else if (thm[cs[end]] != 0 && shm[cs[end]] > 1){
                shm[cs[end]]--;
                end--;
            }else
                break;
        }*/
        while (beg < end) {
            if (thm[cs[beg]] != 0) {
                if (--shm[cs[beg]] < thm[cs[beg]])
                    break;
            }
            beg++;
        }
        while (beg < end) {
            if (thm[cs[end]] != 0) {
                if (--shm[cs[end]] < thm[cs[end]])
                    break;
            }
            end--;
        }
        System.out.println(beg +" " + end);
        return s.substring(beg,end + 1);
    }

}
