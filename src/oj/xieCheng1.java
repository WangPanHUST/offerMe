package oj;

import java.util.Scanner;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/4/8 19:38
 * @description
 **/
public class xieCheng1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(isCircleList(str));
    }

    private static boolean isCircleList(String str){
        if(str == null || str.length() <= 1)
            return false;

        String[] nodes = str.split(",");
        String last = nodes[nodes.length - 1];
        for (int i = 0; i < nodes.length - 1; i++) {
            if(nodes[i].equals(last))
                return true;
        }
        return false;
    }

}
