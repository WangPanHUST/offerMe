package leetcode.maxPackage.plainPackage;

import java.util.Scanner;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/7/29 21:08
 * @description
 **/
public class Solution2 {
    public static void main(String[] args) throws Exception {

        Scanner reader = new Scanner(System.in);

        int N = reader.nextInt();
        int V = reader.nextInt();

        int[] v = new int[N + 1] ;
        int[] w = new int[N + 1] ;

        for (int i=1 ; i <= N ; i++){
            v[i] = reader.nextInt();
            w[i] = reader.nextInt();
        }
        reader.close() ;

        int[] dp = new int[V+1];
        dp[0] = 0;
        for(int i = 1; i <= N; i++){
            //重点是这里的逆序更新，保证一趟过去，肯定能确定容量为 j - 1 的时候的最优解
            for(int j = V; j >= v[i]; j--){
                dp[j] = Math.max(dp[j], dp[j-v[i]] + w[i]);
            }
        }
        System.out.println(dp[V]);
    }
}
