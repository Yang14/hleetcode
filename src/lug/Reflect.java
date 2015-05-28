package lug;

/**
 * Created by Mryang on 15-4-3.
 */
public class Reflect {

    public void print(){
        System.out.println("say"+" " + Reflect.class.getInterfaces());
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Class c = Class.forName("lug.Reflect");
        Reflect reflect = (Reflect) (c.newInstance());
        reflect.print();

    }


}
