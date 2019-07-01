package leetcode.longestsubstring2;


import java.util.HashMap;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/5/8 18:56
 * @description https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 时间复杂度 o(n) 空间复杂度O(min(n,m))，n为字符串的大小，m为字符集的大小，这里hashMap里存储的是char，字母最多只有26个
 **/
public class Solution1 {
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> hashMap = new HashMap<>();
        int maxLen = 0, start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (hashMap.containsKey(cur) && hashMap.get(cur) >= start) {
                start = hashMap.get(cur) + 1;
            }
            hashMap.put(cur,i);
            end = i;
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "adbvdfgdz";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
