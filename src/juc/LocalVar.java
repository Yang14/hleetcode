package juc;

/**
 * Created by Mryang on 15-3-18.
 */
public class LocalVar implements Runnable {

    public void run() {
        StringBuffer sb = new StringBuffer();
        for(int i=1;i<4;++i){
            if(Thread.currentThread().getName().equals("zhangsan")){
                sb.append("zs,");
                System.out.println(Thread.currentThread().getName()+"localVar:" +i +" str="+ sb);
            }else if(Thread.currentThread().getName().equals("lisi")){
                sb.append("ls,");
                System.out.println(Thread.currentThread().getName()+" localVar:" +i +" str="+ sb);
            }
            try{
                Thread.sleep(800);
            }catch (Exception e){}
        }
    }
}
