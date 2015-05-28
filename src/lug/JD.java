package lug;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Mryang on 15-4-17.
 */
public class JD {

    public static void main(String[] args) {
        System.out.println(10 % (3 * 2));
        List<Integer> l1 = new ArrayList<Integer>();
        l1.add(0);
        List<Object> l2 = (List)l1;

        Object o = new JD();

        System.out.println(l1.get(0) instanceof Integer);
        System.out.println(l2.get(0) instanceof Integer);

        ArrayList<HashMap<String,Integer>> ah = new ArrayList<HashMap<String, Integer>>();

    }

    public static <T> void getObject(T o1,T o2){
    }
}
