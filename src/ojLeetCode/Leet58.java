package ojLeetCode;

/**
 * Created by Mryang on 15-6-4.
 */
public class Leet58 {
    public static void main(String[] args) {
        int r = lengthOfLastWord("       ");
        System.out.println("last word length is: " + r);
    }


    public static int lengthOfLastWord(String s) {
        int len = 0;
        char[] cs = s.toCharArray();
        int i;
        for (i = cs.length - 1; i >= 0; --i) {
            if (cs[i] == ' ' && len != 0)
                break;
            else if (cs[i] == ' ')
                continue;
            len++;
        }
        return len;
    }

}
