package offer;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/6/25 20:41
 * @description 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 * 穷举，递归寻找所有可能的匹配字符串
 **/
public class RegexMatch {

    public boolean match(char[] str, char[] pattern) {
        //"" "" 空字符串匹配
        if (str.length == 0 && pattern.length == 0) {
            return true;
        }

        //无法匹配的情况
        if (str == null || pattern == null
                || pattern.length == 0) {
            return false;
        }

        return matchCore(str, pattern, 0, 0);
    }

    private boolean matchCore(char[] str, char[] pattern, int sStart, int pStart) {
        //两者都匹配到末尾，匹配成功
        if (sStart == str.length && pStart == pattern.length) {
            return true;
        }

        //时刻判断数组有没有越界
        if (pStart + 1 < pattern.length && pattern[pStart + 1] == '*') {
            boolean sStartValid = sStart < str.length;
            if (sStartValid && (str[sStart] == pattern[pStart] || pattern[pStart] == '.')) {
                //当*匹配成功时有是那种策略，全部前移、字符串前移、表达式前移
                return matchCore(str, pattern, sStart + 1, pStart + 2)
                        || matchCore(str, pattern, sStart + 1, pStart)
                        || matchCore(str, pattern, sStart, pStart + 2);
            }else {
                //匹配不成功，表达式前移
                return matchCore(str, pattern, sStart, pStart + 2);
            }
        }

        boolean valid = sStart < str.length && pStart < pattern.length;
        if (valid && (str[sStart] == pattern[pStart] || pattern[pStart] == '.')) {
            return matchCore(str, pattern, sStart + 1, pStart + 1);
        }

        return false;
    }
}
