package ojLeetCode;

import java.util.ArrayList;

/**
 * Created by Mryang on 15-1-12.
 */
public class Leet7 {

    public int reverse(int x) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int n=0;
        int t = x % 10;
        while (x != 0) {
            n = x % 10;
            x = x / 10;
            result.add(n);
        }
        int sum = 0;
        for (int i = 0; i < result.size(); i++)
            sum = sum * 10 + result.get(i);
        x = sum;
        while (x != 0) {
            n = x % 10;
            x = x / 10;
        }
        if(t!=0 && t != n)
            sum = 0;
       // System.out.println(sum + " " + t  +" " + n);
        return sum;
    }

    public static void main(String[] args) {
        new Leet7().reverse(10);
    }
}
