package ds;

/**
 * Created by Mryang on 15-3-3.
 */
public class QuickSort {

    public static void quickSort(int[] a, int p, int r) {

        if (a != null && p >= 0 && r >= 0 && p < r) {
            int q = partitionOneDirect(a, p, r);
            quickSort(a, p, q - 1);
            quickSort(a, q + 1, r);
        }
    }

    public static int partitionOneDirect(int[] a, int p, int r) {
        int x = a[r];
        int i = p - 1;
        for (int j = p; j < r; j++)
            if (a[j] <= x)
                swap(a, ++i, j);
        swap(a, ++i, r);
        return i;
    }

    public static int partitionTwoDirect(int[] a, int p, int r) {
        int key = a[p];
        while (p < r) {
            while (a[r] >= key && p < r) r--;
            a[p] = a[r];

            while (a[p] <= key && p < r) p++;
            a[r] = a[p];
        }
        a[p] = key;
        return p;
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void bubbleSort(int[] a, int len) {
        for (int i = 0; i < len - 1; i++)
            for (int j = 0; j < len - 1 - i; j++)
                if (a[j] > a[j + 1])
                    swap(a, j, j + 1);
    }

    public static void insertSort(int[] a, int len) {
        if (a == null || len <= 0)
            return;
        for (int i = 1; i < len; i++) {
            int j = 0;
            while (j < i && a[j] <= a[i])
                ++j;
            if (j < i) {
                int k = i;
                int temp = a[i];
                while (j < k) {
                    a[k] = a[k - 1];
                    k--;
                }
                a[k] = temp;
            }
        }
    }

    public static void heapAdjust(int[] a, int s, int m) {
        int x = a[s];
        System.out.println(s);
        for (int j = 2 * s + 1; j < m; j = 2 * j + 1) {
            if (j < m && (a[j] < a[j + 1]))
                ++j;
            if (a[j] > x)
                break;
            a[s] = a[j];
            s = j;
        }
        a[s] = x;
        printArray(a);
    }

    private static void maxHeap(int[] array, int index, int heapSize) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int large = index;
        if (left < heapSize && array[left] > array[index]) large = left;
        if (right < heapSize && array[right] > array[large]) large = right;

        if (large != index) {
            swap(array, large, index);
            maxHeap(array, large, heapSize);
        }
    }

    public static void heapSort(int[] a) {
        for (int i = a.length / 2; i >= 0; --i)
            maxHeap(a, i, a.length);
        //printArray(a);

        for (int i = a.length - 1; i >= 1; --i) {
            swap(a, 0, i);
            maxHeap(a, 0, i);
        }
    }

    public static void dirInsertSort(int[] a) {
        for (int i = 1; i < a.length; ++i) {
            int j = i - 1;
            int x = a[i];
            while (j >= 0 && a[j] > x) {
                a[j + 1] = a[j];
                --j;
            }
            a[j + 1] = x;
        }
    }

    public static void shellSort(int[] a) {
        /*int d = a.length;
        while (d > 0) {
            d = d / 2;
            for (int i = d; i < a.length; ++i) {
                if (a[i] < a[i - d]) {
                    int x = a[i];
                    int j;
                    for (j = i - d; j >= 0 && a[j] > x; j -= d) {
                        a[j + d] = a[j];
                    }
                    a[j + d] = x;
                }
            }
        }*/
        int d = a.length;
        while (d > 0) {
            for (int i = d; i < a.length; ++i) {
                int t = a[i];
                int j = i;
                while (j >= d && a[j - d] > t) {
                    a[j] = a[j - d];
                    j -= d;
                }
                a[j] = t;
            }
            d = d / 2;
        }

    }


    public static void printArray(int[] a) {
//        for (int e : a)
//            System.out.print(e + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = {16, 14, 10, 8, 7, 9, 3, 2, 4, 1};//{2,8,7,1,3,5,6,4};
        //test(a);
//        quickSort(a, 0, 7);
//        swap(a,0,1);
//        bubbleSort(a,8);
//        insertSort(a,8);
//        heapSort(a);

        shellSort(a);
        printArray(a);

        int i = 0;
        int b = 3;
        char d = 48;
        float f = (float) 1.0;
        long k = 056l;
        int j = 0x17;
        int s = 32;
//        s = (short) (s + 1);
        int i1 = s >> 33;
        try {
            if(true)
                throw new Exception();
            s = Integer.valueOf("1");
        } catch (Exception e) {
            //e.printStackTrace();
        }

        double random = Math.round(-11.5);

        System.out.println(random + " " + Character.getNumericValue('z'));
    }
}
