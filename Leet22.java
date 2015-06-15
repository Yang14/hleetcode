package ojLeetCode;

import java.util.*;

/**
 * Created by Mryang on 15-5-20.
 */
public class Leet22 {
    public static void main(String[] args) {
        Stack<Integer> stk = new Stack<Integer>();
        generateParenthesis(3);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        String pStr = "";
        for(int i=0;i<n;++i)
            pStr+="(";
        for(int i=0;i<n;++i)
            pStr+=")";
        System.out.println(pStr);
        permutation("",pStr,result);
        for (String e:result)
            System.out.print(e+" ");
        System.out.println();
        return result;
    }

    public static boolean isSafe(String str){
        char[] cs = str.toCharArray();
        int count = 0;
        for (char c:cs){
            if(count < 0 )return false;
            if(c == '(' )count++;
            else count--;
        }
        return true;
    }
    public static void permutation(String sofa,String remain,List<String> result){
        if(remain.length() == 0 && isSafe(sofa)){
            result.add(sofa);
            return;
        }
        for(int i=0;i<remain.length();++i){
            if(i>0 && remain.charAt(i) == remain.charAt(i-1))
                continue;
            String sofa2 = sofa + remain.charAt(i);
            String remain2 = remain.substring(0,i) + remain.substring(i+1);
            permutation(sofa2, remain2,result);
        }
    }

    public static void gp(Stack<Integer> stk, int f, int n) {
        if (f == 0 && stk.size() == 2 * n) {
            for (int e : stk)
                System.out.print(e + " ");
            System.out.println();
            return;
        }
        int t = f;
        System.out.println(t);

        if (stk.size() < 2 * n) {
            if (t >= 0 && t < n) {
                stk.push(0);
                t++;
            } else {
                stk.push(1);
                t--;
            }
            gp(stk, t, n);
            if (stk.pop() == 0)
                t--;
            else t++;
        }



    }

}
