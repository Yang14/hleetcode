package ojLeetCode;

/**
 * Created by Mryang on 15-5-18.
 */
public class Leet151 {
    public static void main(String[] args) {
        String  s = "the is a  boy ";
        reverseWords(s);
    }

    public static String reverseWords(String s) {
        String result = "";
        String[] splits = s.split(" ");
        for(int i = splits.length-1;i>=0;--i){
            String e = splits[i];
            if(e.length() > 0){
//                System.out.println(e+"|");
                result += e +" ";
            }
        }
        if(!result.equals(""))
            result = result.substring(0,result.length()-1);
//        System.out.println(result);
        return result;
    }

}
