package leetcode.generateParenthesis22;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/8/7 20:11
 * @description https://leetcode-cn.com/problems/generate-parentheses/
 **/
public class Solution1 {
    private static List<String> result = new ArrayList<>();
    public static List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return result;
        }

        getString("(", n - 1, n);
        return result;
    }

    private static void getString(String s, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(s);
            return;
        }
        //注意条件的判断 left == 0，与下面 left < right 不是对立的，所以应该写到 if else if，保证只处理一种情况
        if (left == 0) {
            String t = s + ")";
            getString(t, left, right - 1);
        }

        //说明此时左侧已经是成对的对号，只能再添加"("
        if (left == right) {
            String t1 = s + "(";
            getString(t1, left - 1, right);
        }else if (left != 0 && left < right) {
            String t1 = s + "(";
            getString(t1, left - 1, right);

            String t2 = s + ")";
            getString(t2, left, right - 1);
        }

    }

    public static void main(String[] args) {
        List<String> list =  generateParenthesis(3);
        System.out.println(list.toString());
    }
}
