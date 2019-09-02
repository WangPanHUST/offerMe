package leetcode.maxPackage.multiPackage;

import java.util.Scanner;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/7/30 15:31
 * @description 多重背包问题，每行增加了数量的限制
 **/
public class Solution1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt(), volume = in.nextInt();
        int[][] dp = new int[count + 1][volume + 1];
        for (int i = 1; i <= count; i++) {
            int vol = in.nextInt();
            int value = in.nextInt();
            int number = in.nextInt();
            for (int j = 1; j <= volume ; j++) {
                if (j - vol < 0) {
                    dp[i][j] = dp[i - 1][j];
                }else {
                    //这里可以使用逆序的一维数组来实现
                    int max = dp[i - 1][j], c = 1;
                    for(int k = vol; c <= number && k <= j; k += vol) {
                        max = Math.max(max, c * value + dp[i - 1][j - k]);
                        c++;
                    }
                    dp[i][j] = max;
                }
            }
        }
        in.close();
        System.out.println(dp[count][volume]);
    }
}
