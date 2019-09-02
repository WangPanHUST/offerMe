package leetcode.isValid20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/8/7 19:26
 * @description https://leetcode-cn.com/problems/valid-parentheses/
 * 利用栈先进后出的特性，时间复杂度o(n)，空间复杂度o(n)
 **/
public class Solution1 {
    public boolean isValid(String s) {
        if (s == null || s.length() % 2 == 1) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }

        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> stack = new Stack<>();
        stack.add('1');

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Character pair = map.get(c);
            char peek = stack.peek();
            if (pair != null && pair == peek) {
                stack.pop();
            }else if (pair != null && pair != peek) {
                return false;
            }else {
                stack.add(c);
            }
        }
        if (stack.peek() == '1'){
            return true;
        }else {
            return false;
        }
    }
}
