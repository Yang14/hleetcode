package juc;

/**
 * Created by Mryang on 15-3-18.
 */
public class UsingThread {
    public static void main(String[] args){
        StringBuffer sb = new StringBuffer();
        People p1 = new People("张三",sb);
        People p2 = new People("李四",sb);
        p1.start();
        p2.start();
    }
}
