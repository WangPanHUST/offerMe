package leetcode.longestPalindrome5;


import java.util.HashMap;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/7/1 16:01
 * @description https://leetcode-cn.com/problems/longest-palindromic-substring/
 **/
public class Solution1 {
    //暴力法o(n3)
    public static String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        HashMap<Integer,String> hashMap = new HashMap<>();
        hashMap.put(1, s.substring(0,1));
        int max = 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.length() - i < max) {
                break;
            }
            for (int j = i + 1; j < s.length(); j++) {
                if (isPalindrome(s, i ,j) && j - i + 1 > max) {
                    hashMap.clear();
                    hashMap.put(j - i + 1, s.substring(i, j + 1));
                    max = j - i + 1;
                }
            }
        }
        String result = hashMap.values().toString();
        return result.substring(1, result.length() - 1);
    }

    private static boolean isPalindrome(String s, int begin, int end) {
        while (end >= begin) {
            if (s.charAt(begin) != s.charAt(end)) {
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "bbbaabbf";
        System.out.println(longestPalindrome(s));
    }
}
