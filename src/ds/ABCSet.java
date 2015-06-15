package ds;

import java.util.Stack;

/**
 * Created by Mryang on 15-3-17.
 */
public class ABCSet {

    static void permutation(char a[]){
        int len = a.length;
        Stack<Character> s = new Stack<Character>();
        for(int i=1;i<=len;++i){
            permutation(a,0,i,s);
        }
    }

    static void permutation(char a[],int i,int m,Stack<Character> s){

        if(m == 0){
            for(Character c:s)
                System.out.print(c+" ");
            System.out.println();
            return;
        }
        if(i>=a.length)
            return;
//        System.out.println(i);
        s.push(a[i]);
        permutation(a,i+1,m-1,s);
        s.pop();
        permutation(a,i+1,m,s);
    }

    public static void main(String[] args){
        char a[] = {'a','b','c'};
        permutation(a);
    }
}
