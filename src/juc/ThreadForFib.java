package juc;

/**
 * Created by Mryang on 15-3-19.
 */
public class ThreadForFib {

    public static void main(String[] args){
        int nThreads = 3;
        long nForFib = 40;
        Thread[] t = new Thread[nThreads];
        for( int i=0;i<t.length;++i){
            t[i] = new Thread(new Task(nForFib,"Task " + i));
            t[i].start();
        }

        for( int i=0;i<t.length;++i){
            try {
                t[i].join();
            }catch (InterruptedException e){}
        }
    }
}
