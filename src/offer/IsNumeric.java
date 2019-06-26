package offer;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/6/25 21:51
 * @description 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * 分别用两个函数实现无符号整数的和有符号整数的判定，重用
 **/
public class IsNumeric {
    int index = 0;
    String normal = "0123456789";

    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0) {
            return false;
        }

        boolean numeric = false;

        numeric = isSignedInt(str, index);

        if (index < str.length && str[index] == '.') {
            index++;
            // ||运算是，左侧若为真，则右侧表达式不再执行，故应将表达式放在左侧
            numeric = isInt(str, index) || numeric;
        }

        if (index < str.length && (str[index] == 'e' || str[index] == 'E')) {
            index++;
            // 数组时刻判断是否越界
            if (index < str.length) {
                numeric = numeric && isSignedInt(str, index);
            }else {
                return false;
            }
        }

        return numeric && index == str.length;
    }

    //判断是否是无符号整数
    private boolean isInt(char[] str, int start) {
        while (index < str.length && normal.contains(String.valueOf(str[index]))) {
            index++;
        }
        return index > start;
    }

    private boolean isSignedInt(char[] str, int start) {
        if (str[index] == '+' || str[index] == '-') {
            index++;
            return isInt(str, start + 1);
        }else {
            return isInt(str, start);
        }
    }

}
