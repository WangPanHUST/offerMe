package leetcode.maxPackage.fullPackage;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/7/30 10:45
 * @description 完全背包（多重背包问题，限制每个物品数量），每个物品无限件
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
                if (j < vol) {
                    dp[i][j] = dp[i - 1][j];
                }else {
                    int max = dp[i - 1][j], c = 1;
                    //状态转移时以当前物品为中心，看添加几个当前物品，找出最大值
                    for(int k = vol; k <= j; k += vol) {
                        max = Math.max(max, c * value + dp[i - 1][j - k]);
                        c++;
                    }
                    dp[i][j] = max;
                }
            }
        }
        in.close();
        for (int i = 0; i <= count; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        //System.out.println(dp[count][volume]);
    }
}
