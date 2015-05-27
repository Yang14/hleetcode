/**
 * Created by Mryang on 15-4-5.
 */
public class Leet5 {

    public static String longestPalindrome2(String s) {

        if(s.equals(""))
            return "";

        int max = 1, n,j,k,count;
        int left=0,right=1;
        char[] c = s.toCharArray();
        n = c.length;

        for (int i = 0; i < n; ++i) {
            j = k = 1;
            count = 1;
            if((i+1 < n) && c[i] == c[i+1]){
                count = 2;
                k=2;
            }
            while ((i - j) >= 0 && (i + k) < n && ( c[i-j] == c[i+k])){
                j++;
                k++;
                count++;
            }
            j--;
            if(count > max){
                max = count;
                left = i-j;
                right = i+k;
               // System.out.println("max:"+left +" " + right);
            }

        }
        return s.substring(left,right);
    }

    public static String longestPalindrome(String s) {

//        if(s.equals(""))
//            return "";

        int max = 1, n,low,hig;
        int left=0,right=0;
        char[] c = s.toCharArray();
        n = c.length;

        for (int i = 1; i < n; ++i) {
            low = i-1;
            hig = i;
            while (0<=low && hig < n && c[low] == c[hig]){
                if(hig - low +1 > max){
                    max = hig-low + 1;
                    right = hig;
                    left = low;
                }
                low--;
                hig++;
            }

            low = i-1;
            hig = i+1;
            while (0<=low && hig < n && c[low] == c[hig]){
                if(hig - low +1 > max){
                    max = hig-low + 1;
                    right = hig;
                    left = low;
                }
                low--;
                hig++;
            }
        }
        return s.substring(left,right+1);
    }

    public static void main(String[] args) {
        String str = "a";
        String r = longestPalindrome(str);
        System.out.println(r);
    }

}
