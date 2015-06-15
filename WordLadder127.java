package ojLeetCode;

import java.util.*;

/**
 * Created by Mryang on 15-3-28.
 */
public class WordLadder127 {

    public static int ladderLength(String start, String end, Set<String> dict) {
        Queue<String> open = new LinkedList<String>();
        Map<String,String> close = new HashMap<String, String>();
        open.add(start);
        close.put(start,null);
        String peek = "";
        int destLen = 1;
        while (!open.isEmpty()){
            peek = open.poll();
            for(int i=0;i<peek.length();++i){
                char c = peek.charAt(i);
                StringBuilder sb = new StringBuilder(peek);
                for(int j=0;j<26;++j){
                    sb.setCharAt(i, (char) ('a'+j));
                    if(sb.toString().equals(end)){
                        close.put(sb.toString(),peek);
                        return printPath(close,end);

                    }
                    if(!close.containsKey(sb.toString()) && dict.contains(sb.toString())){
                        open.add(sb.toString());
                        close.put(sb.toString(),peek);
                    }
                }
                sb.setCharAt(i,c);
                peek = sb.toString();
            }
        }
        return 0;
    }

    public static int printPath(Map<String,String> path,String end) {
        int count = 1;
        if(path.get(end)!=null){
            String pri = path.get(end);
            count += printPath(path,pri);
            System.out.println(pri+"-->"+end);
            return count;
        }else return 1;
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
