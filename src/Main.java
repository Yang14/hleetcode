import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Mryang on 15-3-29.
 */
public class Main {

    public static void findShortestPath(int[][] maze,int n){
        int[] cur = new int[]{0,0};
        Stack<int[]> path = new Stack<int[]>();
        path.push(cur);  //初始值进栈

        int row = 0,col = 0;

        while (!(row == 4 && col == 4)){
            //右边
            if(cur[1]+1 <=4 && maze[row][cur[1]+1] == 0){
                col = cur[1]+1;
                cur = new int[]{row,col};
                path.add(cur);
                maze[row][col] = 1;
            }else if(cur[0]+1 <= 4 && maze[cur[0]+1][col] == 0){
                row = cur[0]+1;
                cur = new int[]{row,col};
                path.add(cur);
                maze[row][col] = 1;
            }else if(cur[0]-1 >=0 && maze[cur[0]-1][col] == 0){
                row = cur[0]-1;
                cur = new int[]{row,col};
                path.add(cur);
                maze[row][col] = 1;
            }else if(cur[1]-1 >=0 && maze[row][cur[1]-1] == 0){
                col = cur[1]-1;
                cur = new int[]{row,col};
                path.add(cur);
                maze[row][col] = 1;
            }else {
                path.pop();
            }
        }

        Stack<int[]> outPut = new Stack<int[]>();
        while (!path.isEmpty()){
            outPut.push(path.pop());
        }
        while (!outPut.isEmpty()){
            int[] e = outPut.pop();
            System.out.println("("+ e[0] + ", " + e[1]+")");
        }
    }

    public static void main(String[] args) throws IOException {
        /*int[][] maze = {
            {
                0, 1, 0, 0, 0
            },{
                0, 1, 0, 1, 0
            },{
                0, 0, 0, 1, 0
            },{
                0, 1, 1, 1, 0
            },{
                0, 0, 0, 1, 0
            }
        } ;*/
        /*Scanner sc = new Scanner(System.in);
        int[][] maze = new int[5][5];
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++)
                maze[i][j] = sc.nextInt();
        }
        findShortestPath(maze, 5);*/

          intEqu();

    }

    public static void intEqu(){

        int i1 = 1;
        Integer i2 = 1;
        Integer i3 = Integer.valueOf("1");
        Integer i4 = new Integer(1);
        Integer i5 = new Integer(1);

        String s = "abc";
        String s2 = new String("abc");

        System.out.println(s == s2);
        System.out.println(s == s2.intern());
        System.out.println(s.equals(s2));

        System.out.println(1 == i2);
        System.out.println(i3==(i2));
        System.out.println(i3 == i4);
        System.out.println(i5 == i4);






    }
}
