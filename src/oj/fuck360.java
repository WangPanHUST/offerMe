package oj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/3/7 20:02
 * @description 360面试题，有n个学生，m张桌子，且n <= 2*m，每张桌子可以坐一个人或两个，每个学生有对应的淘气值，最后淘气值之和的最大值的可能的最小值。
 * 5个学生，3张桌子，淘气值为4 6 2 8 1，则输出为7
 **/
public class fuck360 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter n and m");
        int student = in.nextInt();
        int desk = in.nextInt();

        System.out.println("enter taoqizhi:");
        int[] taoqi = new int[student];

        for (int i = 0; i < student; i++) {
            taoqi[i] = in.nextInt();
        }
        System.out.println(max(taoqi,student,desk));
    }

    public static int max(int[] taoqi,int student,int desk){
        Arrays.sort(taoqi);

        int len = student - desk;

        int[] max = new int[len];
        for (int i = 0; i < len; i++) {
            max[i] = taoqi[i] + taoqi[2*len - 1 - i];
        }

        Arrays.sort(max);
        return max[max.length - 1];
    }
}















