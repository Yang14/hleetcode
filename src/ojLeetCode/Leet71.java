package ojLeetCode;

import java.util.Stack;

/**
 * Created by Mryang on 15-6-4.
 */
public class Leet71 {
    public static void main(String[] args) {
        String r = simplifyPath("/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///");
        System.out.println("simplify path: " + r);
    }

    public static String simplifyPath(String path) {
        Stack<String> stk = new Stack<String>();

        String[] paths = path.split("/");

        for (String e : paths) {
            if (e.length() < 1 || e.equals(".")) continue;

            if (e.equals("..")) {
                //易错点：..时需要返回上一层目录，如果栈为空不做任何处理--不弹出
                //栈非空时弹出
                if (!stk.empty())
                    stk.pop();
            }else {
                stk.push(e);
            }
        }
        StringBuilder sb = new StringBuilder();
        //顺序遍历栈中元素
        //若用栈的出栈方式，需要逆向增加字符串，实现就复杂多了
        for (String e : stk){
            sb.append("/").append(e);
        }
        return sb.toString().equals("") ? "/" : sb.toString();
    }

}
