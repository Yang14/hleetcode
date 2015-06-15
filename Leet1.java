package ojLeetCode;

/**
 * Created by Mryang on 15-3-27.
 */
public class Leet1 {

    public static void qSort(int[] a, int q, int s) {
        if (q < s) {
            int p = partition(a, q, s);
            qSort(a, q, p - 1);
            qSort(a, p + 1, s);
        }
    }

    public static int partition(int[] a, int q, int s) {
        int x = a[s];
        int i = q - 1;
        for (int j = q; j < s; ++j) {
            if (a[j] <= x) {
                i++;
                swap(a, i, j);
            }
        }
        swap(a, i + 1, s);
        return i + 1;
    }

    public static void swap(int[] a, int q, int s) {
        int t = a[q];
        a[q] = a[s];
        a[s] = t;
    }

    public static int[] index(int[] a, int key1, int key2) {
        int i;
        int idx1=0, idx2=0;
        int [] r = new int[2];
//        System.out.println("k1" + key1 +" " + "k2"+key2);
        if (key1 == key2) {
            for (i = 0; i < a.length; ++i)
                if (a[i] == key1) {
                    idx1 = i + 1;
                    break;
                }
            for (i=i+1; i < a.length; ++i)

                if (a[i] == key2) {
//                    System.out.println("i" + i);
                    idx2 = i + 1;
                    break;
                }
        }
        else {
            for (i = 0; i < a.length; ++i){
                if (a[i] == key1) {
                    idx1 = i + 1;
                    break;
                }
            }
            for (i = 0; i < a.length; ++i){
                if (a[i] == key2) {
                    idx2 = i + 1;
                    break;
                }
            }
        }
        if(idx1 < idx2){
            r[0] = idx1;
            r[1] = idx2;
        }else {
            r[0] = idx2;
            r[1] = idx1;
        }
        return r;
    }

    public static int[] twoSun(int[] numbers, int target) {
        int n = numbers.length;
        int[] r = new int[2];
        int i = 0;
        int[] a = new int[n];
        for (i = 0; i < n; ++i)
            a[i] = numbers[i];
        qSort(numbers, 0, n - 1);
        i=0;
        while (i < n - 1) {
            if ((numbers[i] + numbers[i + 1]) == target) {
                r = index(a,numbers[i],numbers[i+1]);
//                System.out.println(r[0] + "-- " + r[1]);
//                System.out.println(r[0] + "-- " + r[1]);
                break;
            }
            i++;
        }

        return r;
    }


    public static void main(String[] args) {
        int[] a = {0,4,3,0};
        int[] r = twoSun(a, 0);
        System.out.println(r[0] + " " + r[1]);
    }
}
