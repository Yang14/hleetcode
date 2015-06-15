package juc;

/**
 * Created by Mryang on 15-3-18.
 */
public class People extends Thread{
    StringBuffer str;
    public People(String name, StringBuffer str){
        setName(name);
        this.str = str;
    }

    @Override
    public void run(){
        for(int i=0;i<3;++i){
            str.append(getName()+",");
            System.out.println("我是"+getName()+",字符串为："+str);
            try {
                sleep(2000);
            }catch (Exception e){
            }
        }
    }
}
