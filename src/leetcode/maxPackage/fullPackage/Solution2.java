package leetcode.maxPackage.fullPackage;

import java.util.Scanner;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/7/30 11:11
 * @description 完全背包问题
 **/
public class Solution2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt(), volume = in.nextInt();

        // 将dp优化为一维数组
        /**
         注意，这里第二层循环的时候，还是小到大循环的话，那么

         dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-v[i]] + w[i])
         实际上变成了
         dp[i][j] = Math.max(dp[i][j], dp[i][j-v[i]] + w[i]);

         因为i-1的值已经在前面被更新过了，覆盖了
         为了避免这个问题，所以要逆序更新，即先更新第i个，然后更新第i-1个，从而保证第i-1个不被覆盖

         如果不逆序的话，输出结果为10，dp数组实际为：
         0 0 0 0 0 0
         0 2 4 6 8 10
         0 2 4 6 8 10
         0 2 4 6 8 10
         0 2 4 6 8 10
         */
        int[] dp22 = new int[volume + 1];
        for (int i = 1; i <= count; i++) {
            int vol = in.nextInt();
            int value = in.nextInt();
            for (int j = volume; j >= vol; j--) {
                int c = 1;
                //逆序更新，同背包问题
                for (int k = vol; k <= j; k += vol) {
                    dp22[j] = Math.max(dp22[j], dp22[j - k] + c * value);
                    c++;
                }
            }
        }
        in.close();

        System.out.println(dp22[volume]);
    }
}
