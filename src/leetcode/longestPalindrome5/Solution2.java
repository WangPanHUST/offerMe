package leetcode.longestPalindrome5;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/7/1 18:46
 * @description https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 动态规划解法，时间复杂度o(n2)
 **/
public class Solution2 {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        int len = s.length();
        //dp[i][j]用来存储从i到j的字串是否是回文串
        boolean[][] dp = new boolean[len][len];
        String ans = "";

        //首先初始化一字母和二字母的回文！这点很重要
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (i == j) {
                    dp[i][j] = true;
                    ans = j - i + 1 > ans.length() ? s.substring(i, j + 1) : ans;
                }
                if (j - i == 1 && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    ans = j - i + 1 > ans.length() ? s.substring(i, j + 1) : ans;
                }
            }
        }

        for (int i = 3; i <= len ; i++) {
            for (int j = 0; j <= len - i ; j++) {
                //P(i,j)=(P(i+1,j−1) and Si == Sj，可以利用除两端之外的字串，避免重复判断
                dp[j][j + i - 1] = dp[j + 1][j + i - 2] && s.charAt(j) == s.charAt(j + i - 1);
                if (dp[j][j + i - 1]) {
                    ans = i > ans.length() ? s.substring(j, j + i) : ans;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "bbbaabbf";
        System.out.println(longestPalindrome(s));
    }
}
