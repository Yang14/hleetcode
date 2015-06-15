package ojLeetCode;

import java.util.*;

/**
 * Created by Mryang on 15-5-18.
 */
public class Leet17 {
    public static void main(String[] args) {
        letterCombinations("23");
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        Map<Character, String> numHm = new HashMap<Character, String>();
        numHm.put('2', "abc");
        numHm.put('3', "def");
        numHm.put('4', "ghi");
        numHm.put('5', "jkl");
        numHm.put('6', "mno");
        numHm.put('7', "pqrs");
        numHm.put('8', "tuv");
        numHm.put('9', "wxyz");
        numHm.put('0', " ");
        numHm.put('*', "+");

        char[] cs = digits.toCharArray();
        String[] strs = new String[cs.length];
        for (int i = 0; i < cs.length; ++i) {
            strs[i] = numHm.get(cs[i]);
        }
        Stack<Result> stack = new Stack<Result>();
        int i = 0;
        for (String s : strs) {
            stack.push(new Result(strs[i].charAt(0), i, 0));
            i++;
        }
        allOper(strs, stack,result);

//        for(String e:result)
//            System.out.print(e + " ");
        System.out.println();
        return result;
    }

    private static class Result {
        char c;
        int i;
        int j;

        public Result(char c, int i, int j) {
            this.c = c;
            this.i = i;
            this.j = j;
        }
    }

    public static void allOper(String[] strs, Stack<Result> stack,List<String> result) {
        if (stack.isEmpty())
            return;
        Result r = stack.peek();
        if (strs.length == stack.size()) {
            String rStr = "";
            for (Result e : stack){
//                System.out.print(e.c + " ");
                rStr += e.c;
            }
            result.add(rStr);
//            System.out.println();

            stack.pop();
            if (r.j < strs[r.i].length() - 1) {
                Result r1 = new Result(strs[r.i].charAt(r.j + 1), r.i, r.j + 1);
                stack.push(r1);
                allOper(strs, stack,result);
            } else {
                while (!stack.isEmpty()) {
                    r = stack.pop();
                    if (r.j < strs[r.i].length() - 1) {
                        Result r1 = new Result(strs[r.i].charAt(r.j + 1), r.i, r.j + 1);
                        stack.push(r1);
                        break;
                    }
                }
            }
        }
        if (r.i + 1 < strs.length) {
            char c = strs[r.i + 1].charAt(0);
            stack.push(new Result(c, r.i + 1, 0));
            allOper(strs, stack,result);
        }
    }

}
