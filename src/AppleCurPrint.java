/**
 * Created by Mryang on 15-4-2.
 */
public class AppleCurPrint implements Runnable {

    Thread tGet, tPut;

    int boxSize = 0;

    public AppleCurPrint() {
        tGet = new Thread(this);
        tPut = new Thread(this);
    }

    public synchronized void operateBox() {
        if (Thread.currentThread() == tGet) {
            while (boxSize == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            boxSize--;
            System.out.println("取出1一个苹果，还剩：" + boxSize);
            notifyAll();
        }
        if (Thread.currentThread() == tPut) {
            while (boxSize >= 5) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            boxSize++;
            System.out.println("加入1一个苹果，还剩：" + boxSize);
            notifyAll();
        }
    }

    public static void main(String[] args) {
        AppleCurPrint appleCurPrint = new AppleCurPrint();
        appleCurPrint.tPut.start();
        appleCurPrint.tGet.start();
    }

    @Override
    public void run() {
        while (true) {
            if (Thread.currentThread() == tGet)
                operateBox();

            if (Thread.currentThread() == tPut)
                operateBox();
        }

    }
}
