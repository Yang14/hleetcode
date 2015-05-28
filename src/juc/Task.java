package juc;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Mryang on 15-3-19.
 */
public class Task implements Runnable {
    long n;
    String id;

    public Task(long n,String id){
        this.n = n;
        this.id = id;
    }

    private long fib(long n){
        if( n == 0)
            return 0L;
        if( n==1)
            return 1L;
        return fib(n-1) + fib(n-2);
    }

    public void run() {
        Date d = new Date();
        DateFormat df = new SimpleDateFormat("HH:mm::ss:SSS");
        long startTime = System.currentTimeMillis();
        d.setTime(startTime);
        System.out.println("Start task " + id + " at " + df.format(d));
        fib(n);
        long endTime = System.currentTimeMillis();
        d.setTime(endTime);
        System.out.println("Ending task " + id + " at " + df.format(d) + " after " + (endTime -startTime) +" mills");
    }
}
