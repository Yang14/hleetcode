package ojLeetCode;

/**
 * Created by Mryang on 15-4-1.
 */
public class Leet5 {

    static int i=2;
    static {
        i = 0;
        System.out.println(i);
    }

    public static String longestPalindrome(String s) {
        int b, e, max,len;
        char[] c = s.toCharArray();
        b = e = max = 0;
        len = c.length;
        for(int i=0;i<len;++i){
            if(c[i] == c[len-i-1]);
        }


        return "";
    }

    public static void main(String[] args) {

        System.out.println(Leet5.i);
        String str = "acdabccbadacc";
        String r = longestPalindrome(str);
        System.out.println(r);
    }
}
