package offer;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/6/25 19:09
 * @description 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0。
 * 给出一个全局变量用于判断数字是否合法，在判断为合法数字，即置validNumber = true时，要判断是否计算过数字，排除只有"+"或"-"的情况
 **/
public class StrToInt {

    private static boolean validNumber = false;

    public static int strToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        boolean minus = false;
        int start = 0;
        if (str.charAt(0) == '-') {
            minus = true;
            start = 1;
        }else if (str.charAt(0) == '+') {
            start = 1;
        }

        return getInt(str, minus, start);

    }

    private static int getInt(String str, boolean minus, int start) {
        long temp = 0;
        //由于排除"+""-"的情况，只有单独符号的情况
        boolean calculated = false;

        int flag = minus ? -1 : 1;
        while (start <= str.length() - 1) {
            char curChar = str.charAt(start);
            if (curChar >= '0' && curChar <= '9') {
                temp = temp * 10 + flag * (curChar - '0');
                if (temp > Integer.MAX_VALUE || temp < Integer.MIN_VALUE) {
                    break;
                }
                calculated = true;
            }else {
                break;
            }
            start++;
        }

        if (start == str.length() && calculated) {
            validNumber = true;
            return (int)temp;
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(strToInt("g"));
        System.out.println(validNumber);
    }

}
