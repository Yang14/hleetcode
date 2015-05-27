import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Mryang on 15-3-28.
 */
public class WordLadder_1_2_7 {
    public static int ladderLength(String start, String end, Set<String> dict) {
        int len = 0;
        Map<String, Integer> visited = new HashMap<String, Integer>();
        Queue<String> queue = new LinkedList<String>();
        dict.add(start);

        for (String s : dict)
            visited.put(s, 0);
        queue.offer(start);
        visited.put(start, 1);
        String peek = "";
        boolean flag = false;
        while (!queue.isEmpty()) {
            peek = queue.poll();
            System.out.println(peek);
            len++;
            if (diffOne(peek, end)){
                flag = true;
                break;
            }
            for (String e : dict)
                if (diffOne(e, peek) && visited.get(e) == 0) {
                    queue.add(e);
                    visited.put(e, 1);
                }
        }
        return flag ? len : 0;
    }

    /*public static int ladderLength(String start, String end, Set<String> dict) {
        int len = 0;
        Map<String, Integer> visited = new HashMap<String, Integer>();
        Queue<String> queue = new LinkedList<String>();
        Map<Integer,ArrayList<String>> priorityMap = new HashMap<Integer, ArrayList<String>>();

        if(diffOne(start,end) == 1)
            return 1;

        dict.add(start);

        for (String s : dict)
            visited.put(s, 0);
        queue.offer(start);
        visited.put(start, 1);

        ArrayList<String> temp;
        for(String s:dict){
            int diffCount = diffOne(end,s);
            if(priorityMap.get(diffCount) == null){
                temp = new ArrayList<String>();
                temp.add(s);
                priorityMap.put(diffCount,temp);
            }else {
                ArrayList<String> add = priorityMap.get(diffCount);
                add.add(s);
                priorityMap.put(diffCount,add);
            }
        }

        String peek = "";
        while (!queue.isEmpty()){
            peek = queue.poll();
            len++;
            for(int i=1;i<=start.length();++i){
                ArrayList<String> al = priorityMap.get(i);
                if(al == null)
                    continue;
                boolean flag = false;
                for(int j=0;j<al.size();++j){
                    String aStr = al.get(j);
                    if(diffOne(peek,aStr) == 1 && visited.get(aStr) == 0){
                        if(i==1){
                            return len + 2;
                        }
                        queue.offer(aStr);
                        visited.put(aStr, 1);

                        flag = true;
                    }
                }
                if(flag)
                    break;
            }

        }

        return 0;
    }
*/

    /*public static int ladderLength(String start, String end, Set<String> dict) {
        int len = start.length();
        int count =0;
        Map<String, Integer> visited = new HashMap<String, Integer>();
        Queue<String> queue = new LinkedList<String>();

        dict.add(start);
        dict.add(end);

        for (String s : dict)
            visited.put(s, 0);
        queue.offer(start);
        visited.put(start, 1);

        String peek = "";
        while (!queue.isEmpty()){
            peek = queue.poll();
            count++;

            char[] chars = peek.toCharArray();
            for(int i=0;i<len;++i){
                char c = chars[i];
                for(int j=0;j<26;++j){
                    chars[i] = (char) ('a' + j);
                    String s = new String(chars);
                    if(visited.get(s) != null && visited.get(s) == 0 && dict.contains(s)  ){
                        queue.offer(s);
                        visited.put(s,1);
                        System.out.println(peek + " " + s);
                        if(s.equals(end))
                            return ++count;

                    }
                }
                chars[i] = c;
            }

        }
        return 0;
    }
*/
    public static boolean diffOne(String s, String t) {
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        int count = 0;
        for (int i = 0; i < cs.length; ++i) {
            if (cs[i] != ct[i]) {
                ++count;
            }
        }
        return count>1?false:true;
    }

    public static void main(String[] args) {
        Set<String> dict = new HashSet<String>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");

        String start = "hit";
        String end = "cot";

        int r = ladderLength(start, end, dict);
        System.out.println(r);



    }

}
