package ojLeetCode;

/**
 * Created by Mryang on 15-6-4.
 */
public class Leet69 {
    public static void main(String[] args) {
        int r = mySqrt(1);
        System.out.println("my sqrt: " + r);
    }

    public static int mySqrt(int x) {
        //考点：不能通过两个数相乘的结果与x是否相等来求平方根
        //x太大，相乘的结果可能溢出，采用除法求解
        if (x <= 1) return x;
        int beg = 0, end = x, mid;
        int temp;
        while (beg <= end) {
            mid = (beg + end) / 2;
            temp = (x / mid);       //用除法防止溢出
            if (mid == temp)
                return mid;
            if (mid < temp && (mid + 1) > x / (mid + 1))
                return mid;
            if (mid > temp)
                end = mid - 1;
            else
                beg = mid + 1;
        }
        return 0;
    }

    public static int mySqrt2(int x) {
        int upper = (int) Math.sqrt(Integer.MAX_VALUE); //获得最大整数的平方根，依次递减求值
        upper = upper > x ? x : upper;
        for (int i = upper; i >= 1; --i) {
            if (i * i == x)
                return i;
            else if (i * i < x)
                return i;
        }
        return 0;
    }

}
