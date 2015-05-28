package ds;

import com.sun.org.apache.regexp.internal.recompile;

/**
 * Created by Mryang on 15-5-21.
 */
public class Recursive {

    public static void main(String[] args){
        String str = "0011";
        permutation("",str);
//        subset("",str);
    }
    public static boolean isSafe(String str){
        char[] cs = str.toCharArray();
        int count = 0;
        for (char c:cs){
            if(count < 0 )return false;
            if(c == '0' )count++;
            else count--;
        }
        return true;
    }
    public static void permutation(String sofa,String remain){
        if(remain.length() == 0 && isSafe(sofa)){
            System.out.println(sofa);
            return;
        }
        for(int i=0;i<remain.length();++i){
            if(i>0 && remain.charAt(i) == remain.charAt(i-1))
                continue;
            String sofa2 = sofa + remain.charAt(i);
            String remain2 = remain.substring(0,i) + remain.substring(i+1);
            permutation(sofa2, remain2);
        }
    }

    public static void subset(String sofa,String remain){
        if(remain.length() == 0){
            System.out.println(sofa);
            return;
        }
        char c = remain.charAt(0);
        remain = remain.substring(1);
        subset(sofa+c, remain);
        subset(sofa, remain);
    }
}
