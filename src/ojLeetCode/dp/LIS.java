package ojLeetCode.dp;

/**
 * Created by Mryang on 15-6-4.
 */
public class LIS {
    public static void main(String[] args) {
        int[] a = {10,22,9,33,21,50,41,60,80};
        Integer max = 1;
        //int r = lis(a,9,max);

        int r = lisDP(a,9);
        System.out.println("using dp: " + r);
    }

    public static int lis(int[] a,int n,Integer max){

        if(n == 1)
            return 1;
        int ref, curMax = 1;

        for (int i=1;i<n;++i){
            ref = lis(a,i,max);
            if((a[i-1] < a[n-1]) && (ref + 1 > curMax))
                curMax = ref + 1;
        }

        if (curMax > max){
            max = curMax;
            System.out.println("max c:" + max);
        }

        return curMax;
    }

    public static int lisDP(int[] a,int n){
        int[] l = new int[n];

        for (int i=0;i<n;++i)
            l[i] = 1;

        for (int i=0;i<n;++i)
            for (int j=0;j<i;++j){
                if(a[j] < a[i] && l[j] + 1 > l[i])
                    l[i] = l[j] + 1;

            }
        int max = 0;
        for (int i=0;i<n;++i)
            if(l[i] > max)
                max = l[i];
        return max;
    }
}
