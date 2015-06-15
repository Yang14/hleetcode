package ojLeetCode;

import java.util.*;

/**
 * Created by Mryang on 15-5-12.
 */
public class Leet40 {

    public static void main(String[] args) {
        int[] a = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> r = combinationSum(a, 8);
        for (List<Integer> l : r) {
            for (int e : l)
                System.out.print(e + " ");
            System.out.println();
        }
    }

    public static List<List<Integer>> combinationSum(int[] a, int target) {
        List<List<Integer>> r = new ArrayList<List<Integer>>();
        if (a.length < 1) return null;
        Stack<Integer> closet = new Stack<Integer>();
        List<Integer> openSet = new ArrayList<Integer>();
        for (int e:a)
            openSet.add(e);
        calSet(openSet, closet, target, r, 0);
        return r;
    }

    public static void calSet(List<Integer> openSet, Stack<Integer> closet, int target, List<List<Integer>> r, int start) {
        for (int i = start; i < openSet.size(); ++i) {
            int e = openSet.get(i);
            if (e == target) {
                closet.push(e);
                List<Integer> result = new ArrayList<Integer>(closet);
                Collections.sort(result);
                if (!r.contains(result))
                    r.add(result);
                closet.pop();
            } else if (e < target) {
                closet.push(e);
                openSet.remove(i);
                calSet(openSet, closet, target - e, r, i);
                openSet.add(i,e);
                closet.pop();
            }
        }
    }


}
