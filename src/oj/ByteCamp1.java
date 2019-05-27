package oj;

import java.util.Scanner;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/5/25 1:29
 * @description 给定景区的评分和每个的坐标，一天只能游玩两个景区，总评分等于两个景区的分数和加距离差（负数）
 * 如 11 6 5 11 18 12 ，总评分最大为29,18+12-1 = 29
 * 简单的动态规划
 **/
public class ByteCamp1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] lands = new int[num];

        for (int i = 0;i < num;i++) {
            lands[i] = in.nextInt();
        }

        int max = 0, start = 0;
        for (int i = 1; i < num; i++) {
            int cur = lands[i] + lands[start] + start - i;
            max = Math.max(max,cur);
            if (lands[i] + i > lands[start] + start) {
                start = i;
            }
        }
        System.out.println(max);
    }

}
