package OJ;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/4/14 10:04
 * @description 输入矩阵中取值为0 1 2，每次把为2的点的上下左右的为1的点变为2，问需要几次把所有的1变为2，如果不能把所有的1变为2则返回-1
 **/
public class byteDance1 {
    private static int r,c;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> arrayList = new ArrayList<>();

        while (in.hasNextLine()){
            String s = in.nextLine();
            if(s != null && s.length() > 0)
                arrayList.add(s);
            else
                break;
        }

        c = arrayList.get(0).split(" ").length;
        r = arrayList.size();
        int[][] numbers = new int[r][c];

        for (int i = 0; i < r; i++) {
            String[] strs = arrayList.get(i).split(" ");
            for (int j = 0; j < c; j++) {
                numbers[i][j] = Integer.valueOf(strs[j]);
            }
        }

        boolean[][] visited = new boolean[r][c];
        int result = counts(numbers,visited);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(numbers[i][j] == 1)
                    System.out.println(-1);
            }
        }
        System.out.println(result);
    }

    public static int counts(int[][] numbers,boolean[][] visited){
        int count = 0;

        while (!isFinish(numbers)){
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if(numbers[i][j] == 2 && !visited[i][j]){
                        numbers = make(numbers,i,j);
                        visited[i][j] = true;
                    }
                }
            }
            count++;
        }
        return count;
    }

    private static int[][] make(int[][] numbers,int row,int col){
        if(isOk(row + 1,col) && numbers[row + 1][col] == 1)
            numbers[row + 1][col] = 2;
        if(isOk(row - 1,col) && numbers[row - 1][col] == 1)
            numbers[row - 1][col] = 2;
        if(isOk(row, col + 1) && numbers[row][col + 1] == 1)
            numbers[row + 1][col] = 2;
        if(isOk(row,col - 1) && numbers[row][col - 1] == 1)
            numbers[row][col - 1] = 2;
        return numbers;
    }

    private static boolean isOk(int row,int col){
        if(row >= 0 && row < r && col >= 0 && col < c)
            return true;

        return false;
    }

    private static boolean isFinish(int[][] numbers){
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(numbers[i][j] == 1)
                    return false;
            }
        }
        return true;
    }
}
