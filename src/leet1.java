import java.util.HashMap;

/**
 * Created by Mryang on 15-3-27.
 */
public class leet1 {

    public static int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int[] r = new int[2];

        HashMap<Integer,Integer> hm = new HashMap<Integer, Integer>();
        HashMap<Integer,Integer[]> hm2;
        for(int i=0;i<n;++i){
            hm.put(target-numbers[i],i+1);
        }

        for(int i=0;i<n;++i){
            if(hm.get(numbers[i]) != null){
                int ind = hm.get(numbers[i]);
                if(i+1 == ind)
                    continue;
                r[0] = i+1 < ind ? i+1 : ind;
                r[1] = i+1 < ind ? ind : i+1;
                break;
            }

        }
        return r;


    }
    /*public static int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int[] r = new int[2];
        int i = 0;
        int[] a = new int[n];
        for (i = 0; i < n; ++i)
            a[i] = numbers[i];
        if(!inOrder(numbers))
            bubbleSort(numbers);
        for(int e:numbers)
            System.out.print(e + " ");
        System.out.println();
        i = 0;
        int j = n-1;
        while (i < j){
            int sum = numbers[i] + numbers[j];
            if(sum == target){
                r = index(a,numbers[i] ,numbers[j]);
                break;
            }
            else
            if(sum > target) --j;
            else ++i;
        }
        return r;
    }*/
    public static boolean inOrder(int[] a) {
        for (int i=1;i<a.length;++i)
            if(a[i-1] > a[i])
                return false;
        return true;
    }
    public static void bubbleSort(int[] a) {
        boolean flag = false;
        for(int i =0;i<a.length-1 && !flag;++i){
            flag = true;
            for(int j=0;j<a.length-i-1;++j){
                if(a[j] > a[j+1]){
                    int t = a[j];
                    a[j] = a[j+1];
                    a[j+1] = t;
                    flag = false;
                }
            }
        }
    }
    public static void qSort(int[] a, int q, int s) {
        if (q < s) {
            int p = partition(a, q, s);
            qSort(a, q, p - 1);
            qSort(a, p + 1, s);
        }
    }

    public static int partition(int[] a, int q, int s) {
        /*int x = a[s];
        int i = q - 1;
        for (int j = q; j < s; ++j) {
            if (a[j] <= x) {
                i++;
                swap(a, i, j);
            }
        }
        swap(a, i + 1, s);
        return i + 1;*/
        int x = a[q];
        while (q < s){
            while (q<s && a[s]>=x) --s;
            a[q] = a[s];
            while (q<s && a[q]<=x) ++q;
            a[s] = a[q];
        }
        a[q] = x;
        return q;
    }

    public static void swap(int[] a, int q, int s) {
        int t = a[q];
        a[q] = a[s];
        a[s] = t;
    }

    public static int[] index(int[] a, int key1, int key2) {
        int i;
        int idx1 = 0, idx2 = 0;
        int[] r = new int[2];
        if (key1 == key2) {
            for (i = 0; i < a.length; ++i)
                if (a[i] == key1) {
                    idx1 = i + 1;
                    break;
                }
            for (i = i + 1; i < a.length; ++i)
                if (a[i] == key2) {
                    idx2 = i + 1;
                    break;
                }
        } else {
            for (i = 0; i < a.length; ++i) {
                if (a[i] == key1) {
                    idx1 = i + 1;
                    break;
                }
            }
            for (i = 0; i < a.length; ++i) {
                if (a[i] == key2) {
                    idx2 = i + 1;
                    break;
                }
            }
        }
        if (idx1 < idx2) {
            r[0] = idx1;
            r[1] = idx2;
        } else {
            r[0] = idx2;
            r[1] = idx1;
        }
        return r;
    }

    public static void main(String[] args) {
        int [] a = {3,2,4};
        int[] r = twoSum(a,6);
        System.out.println(r[0] +"-" + r[1]);
    }
}