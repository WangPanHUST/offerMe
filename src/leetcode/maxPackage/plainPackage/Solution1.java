package leetcode.maxPackage.plainPackage;

import java.util.Scanner;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/7/29 19:58
 * @description 01背包问题 https://www.acwing.com/problem/content/description/2/
 * dp[i][j]表示前i个礼物在背包容积为j时的最大价值
 **/
public class Solution1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt(), volume = in.nextInt();
        int[][] dp = new int[count + 1][volume + 1];
        for (int i = 1; i <= count; i++) {
            int vol = in.nextInt();
            int value = in.nextInt();
            for (int j = 1; j <= volume ; j++) {
                if (j - vol < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //比较是否添加当前物品
                    dp[i][j] = Math.max(value + dp[i - 1][j - vol], dp[i - 1][j]);
                }
            }
        }
        //关闭好评
        in.close();
        System.out.println(dp[count][volume]);
    }
}
