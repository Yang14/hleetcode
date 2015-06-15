package ojLeetCode;

/**
 * Created by Mryang on 15-5-12.
 */
public class Leet9 {

    public boolean isPalindrome2(int x) {
        if(x<0 ||(x!=0 && x%10==0))return false;
        int n = x;
        int sum = 0;
        while (n != 0){
            sum = sum * 10 + n % 10;
            n /=10;
        }
        //System.out.println(sum);
        if(sum != x)
            return false;
        return true;
    }
    public boolean isPalindrome(int x) {
        if(x<0 ||(x!=0 && x%10==0))return false;
        int sum = 0;
        while (x > sum){
            sum = sum * 10 + x % 10;
            x /=10;
        }
        return (x == sum) || (x == sum/10);
    }
    public static void main(String[] args){
        System.out.print(new Leet9().isPalindrome(100));
    }

}
