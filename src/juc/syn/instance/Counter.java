package juc.syn.instance;

/**
 * Created by Mryang on 15-6-12.
 */
class Counter implements Runnable {
    /*
     *实例同步方法和实例方法代码块
     *同步方法---是在实例上加同步字，获得这个实例的线程才可以运行，其他线程阻塞在此方法上
     *实例的同步代码块---线程只有获得了同步字包含的对象才可以运行
     *重点：下面两个方法：第二个如果包含了this，则要运行这两个方法获得的实例是一样的
     *那么这两个方法只能是串行运行
       *aThread-0
        bThread-0
        aThread-1
        bThread-1
        cThread-1
        dThread-1
        cThread-0
        dThread-0
      *若第二个包含的是str，执行两个方法所需的实例不同，两个方法可以并行运行
        aThread-1
        bThread-1
        aThread-0
        cThread-1
        dThread-1
        bThread-0
        cThread-0
    * */

    public synchronized void log1(String msg1, String msg2) throws InterruptedException {
        System.out.println(msg1 + Thread.currentThread().getName());
        Thread.sleep(1000);
        System.out.println(msg2 + Thread.currentThread().getName());
    }


    public void log2(String msg1, String msg2) throws InterruptedException {
        String str = "";
        synchronized (str) {
            System.out.println(msg1 + Thread.currentThread().getName());
            Thread.sleep(1000);
            System.out.println(msg2 + Thread.currentThread().getName());
        }
    }

    public void run() {
        try {
            log1("a", "b");
            log2("c", "d");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Counter c = new Counter();
        Thread t1 = new Thread(c);
        Thread t2 = new Thread(c);
        t1.start();
        t2.start();
    }
}
