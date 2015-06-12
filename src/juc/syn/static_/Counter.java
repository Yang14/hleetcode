package juc.syn.static_;

/**
 * Created by Mryang on 15-6-12.
 */
class Counter implements Runnable{
    public static synchronized void log1(String msg1, String msg2) throws InterruptedException {
        System.out.println(msg1 + Thread.currentThread().getName());
        Thread.sleep(1000);
        System.out.println(msg2 + Thread.currentThread().getName());
    }


    public static void log2(String msg1, String msg2) throws InterruptedException {
        synchronized(String.class){
            System.out.println(msg1 + Thread.currentThread().getName());
            Thread.sleep(1000);
            System.out.println(msg2  + Thread.currentThread().getName());
        }
    }
    public void run() {
        try {
            log1("a","b");
            log2("c","d");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        Counter c = new Counter();
        Thread t1 = new Thread(c);
        Thread t2 = new Thread(c);
        t1.start();
        t2.start();
    }
}
