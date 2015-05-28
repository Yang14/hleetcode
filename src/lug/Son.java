package lug;

/**
 * Created by Mryang on 15-4-1.
 */
import java.util.*;
public class Son extends Father {
    @Override
    public void say(){
        System.out.println("Im speak too.");
    }

    public static void main(String[] args){
        Father f = new Father();
        f.say();
           int[] x={10,12};
        List<String> l = new ArrayList<String>(10);
        l.add("01");
        l.add("02");
        System.out.println(x.length+" " + l.size());
    }

}
