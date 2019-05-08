package oj;

import java.util.Scanner;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/4/8 19:50
 * @description
 **/
public class xieCheng2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        String numbers = input.substring(1,input.length() - 1);
        int k = in.nextInt();
        revertInK(numbers,k);
    }

    public static void revertInK(String numbers,int k){
        if(numbers.length() == 0)
            System.out.println("[" + numbers + "]");
        String[] nodes = numbers.split(",");
        if(nodes.length <= k || k <= 1)
            System.out.println("[" + numbers + "]");

        for (int i = 0; i < nodes.length / k; i++) {
            revert(nodes,i * k,(i + 1) * k - 1);
        }

        System.out.print("[");
        for (int i = 0; i < nodes.length; i ++) {
            System.out.print(nodes[i]);
            if(i < nodes.length - 1)
                System.out.print(",");
        }
        System.out.print("]");
    }

    private static void revert(String[] nodes,int start,int end){
        while (start < end){
            String temp = nodes[start];
            nodes[start] = nodes[end];
            nodes[end] = temp;
            start++;
            end--;
        }
    }
}
