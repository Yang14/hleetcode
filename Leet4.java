package ojLeetCode;

/**
 * Created by Mryang on 15-3-31.
 */
public class Leet4 {
    public static double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length,n=B.length;
        int[] C = new int[n+m];
        int i=0,j=0,k=0;
        while (i<m && j<n){
            if(A[i] <= B[j]){
                C[k++] = A[i];
                i++;
            }else {
                C[k++] = B[j];
                j++;
            }
        }
        if(i<m){
            for(;i<m;++i)
                C[k++] = A[i];
        }

        if(j<n){
            for(;j<n;++j)
                C[k++] = B[j];
        }

        if((n+m)%2 != 0)
            return C[(n+m)/2];
        else return (C[(n+m)/2] + C[(n+m)/2 - 1])/2.0;
    }
    public static void main(String[] args) {
        int a[] = {1,2,4,5};
        int b[] = {3,6,9,10};
        double r = findMedianSortedArrays(new int[]{},b);
        System.out.println(r);
    }
}
