package leetcode.maxPackage.multiPackage;

import java.util.Scanner;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/7/30 15:33
 * @description 多重背包问题，将数量进行二进制的分解，分解后可看成单独一个物品
 * 0<N,V≤1000
 * 0<vi,wi,si≤2000
 **/
public class Solution2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt(), volume = in.nextInt();

        //每个物品数量最多为2000个，2000 < 2^11 - 1，故每个数量最多分解为11个单独的物品
        int MAX_SIZE = 22000;
        int[] v = new int[MAX_SIZE];
        //w = worth
        int[] w = new int[MAX_SIZE];

        //dp数组的大小也要是MAX_SIZE，所以很不推荐二维的dp数组
        int[][] dp = new int[MAX_SIZE][volume + 1];
        int[] dp22 = new int[volume + 1];

        int index = 0;
        for (int i = 1; i <= count; i++) {
            int vol = in.nextInt();
            int value = in.nextInt();
            int number = in.nextInt();

            int k = 1;
            while (k <= number) {
                index++;
                v[index] = vol * k;
                w[index] = value * k;
                number -= k;
                k *= 2;
            }
            if (number > 0) {
                index++;
                v[index] = vol * number;
                w[index] = value * number;
            }
        }

        for (int i = 1; i <= index; i++) {
            for (int j = volume; j >= v[i]; j--) {
                dp22[j] = Math.max(dp22[j], dp22[j - v[i]] + w[i]);
            }
//            for (int j = 1; j <= volume; j++) {
//                if (j - v[i] < 0) {
//                    dp[i][j] = dp[i - 1][j];
//                }else {
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - v[i]] + w[i]);
//                }
//            }
        }
        in.close();
        System.out.println(dp22[volume]);
    }
}
