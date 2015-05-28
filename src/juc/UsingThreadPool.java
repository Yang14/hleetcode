package juc;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Mryang on 15-3-19.
 */
public class UsingThreadPool {
    public static void main(String[] args){
        int nTask = 3;
        long nFib = 40;
        ThreadPoolExecutor tpe = new ThreadPoolExecutor(2,2,50000L,
                TimeUnit.MILLISECONDS,new LinkedBlockingDeque<Runnable>());
        Task[] tasks = new Task[nTask];
        for(int i=0;i<tasks.length;++i){
            tasks[i] = new Task(nFib,"Task " + i);
            tpe.execute(tasks[i]);
        }
        tpe.shutdown();

    }
}
