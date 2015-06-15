package juc;

/**
 * Created by Mryang on 15-3-18.
 */
public class Bank implements Runnable {
    private int num;

    public Bank(int num){
        this.num = num;
    }

    public void run() {
        while (true){
            String name = Thread.currentThread().getName();
            if(name.equals("one")){
                if(num < 150 ){
                    System.out.println(name + "线程结束了。");
                    return;
                }
                num += 10;

            }
            if(name.equals("two")){
                if(num < 0 ){
                    System.out.println(name + "线程结束了。");
                    return;
                }
                num -= 100;
            }
            System.out.println("我是："+name + "现在num="+num);
//            try {
//                Thread.sleep(800);
//            }catch (InterruptedException e){}
        }
    }
}
