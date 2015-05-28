package juc;

/**
 * Created by Mryang on 15-3-18.
 */
public class UsingRunnable {
    public static void main(String[] args){
        Bank b = new Bank(300);
        Thread t1 = new Thread(b);
        t1.setName("one");
        Thread t2 = new Thread(b);
        t2.setName("two");
        //t1.start();
        //t2.start();

        LocalVar lv = new LocalVar();
        Thread tlv1 = new Thread(lv);
        tlv1.setName("zhangsan");
        Thread tlv2 = new Thread(lv);
        tlv2.setName("lisi");
        tlv1.start();
        tlv2.start();

    }
}
