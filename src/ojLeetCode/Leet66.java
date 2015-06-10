package ojLeetCode;

/**
 * Created by Mryang on 15-6-4.
 */
public class Leet66 {
    public static void main(String[] args) {
        int[] digits = {1};
        int[] r = plusOne(digits);
        System.out.println("plus one:");
        for (int e : r) {
            System.out.print(e);
        }
    }

    public static int[] plusOne(int[] digits) {
        if (digits.length < 1) return digits;
        int overFlag = 0;
        int sum = 0;

        digits[digits.length - 1] = digits[digits.length - 1] + 1;

        for (int i = digits.length - 1; i >= 0; --i) {
            sum = digits[i] + overFlag;
            if (sum > 9) {
                overFlag = 1;
                digits[i] = sum - 10;
            }else {
                digits[i] = sum;
                overFlag = 0;
                break;
            }
        }

        if (overFlag != 0){
            int[] r = new int[digits.length+1];
            System.arraycopy(digits,0,r,1,digits.length);
            r[0] = overFlag;
            return r;
        }
        return digits;

    }

}
