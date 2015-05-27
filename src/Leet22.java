import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Mryang on 15-5-20.
 */
public class Leet22 {

    public static void main(String[] args) {

        Stack<Integer> stk = new Stack<Integer>();
        gp(stk,0,3);

    }


    public static void gp(Stack<Integer> stk,int f,int n){
        if(f == 0 && stk.size() == 2*n){
            for(int e:stk)
                System.out.print(e+" ");
            System.out.println();
            return;
        }

        if(stk.size() > 2*n)
            return;
        System.out.println("f:" + f +" " + stk.size());
        if(f>=0 && stk.size()<n){
            stk.push(0);
            gp(stk, f+1, n);
            if(0==stk.peek()){
                gp(stk, f, n);
            }
        }
        else if(f>0 && stk.size()<2*n){
            stk.push(1);
            gp(stk, f-1, n);
            if(1==stk.peek()){
                gp(stk, f, n);
            }
        }


    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        return result;
    }
}
