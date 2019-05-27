package oj;

import java.util.Scanner;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/5/25 2:38
 * @description
 * 输入：3%acm2%n##  输出：acmnnacmnnacmnn 嵌套型的格式
 * 输入：3%acm#2%n#  输出：acmacmacmnn     非嵌套型格式
 **/
public class ByteCamp3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String orig = in.nextLine();
        int len = orig.length();
        StringBuffer sb = new StringBuffer();
        sb = get(sb,orig,0,len);
        System.out.println(sb.toString());
    }

    private static StringBuffer get(StringBuffer sb, String s, int start, int len) {
        int times = Integer.parseInt(String.valueOf(s.charAt(start)));

        StringBuffer stringBuffer = new StringBuffer();
        for (int i = start + 2; i < len; i++) {
            if (s.charAt(i) == '#') {
                start = i + 1;
                break;
            }else if ("123456789".contains(String.valueOf(s.charAt(i)))){
                //仅仅考虑出现的次数为个位数
                StringBuffer sb1 = new StringBuffer();
                stringBuffer.append(get(sb1,s,i,len));
                //次情况为嵌套型 故设置start=len，不再进行非嵌套型的匹配
                start = len;
                //此处的break注意加上
                break;
            }else {
                stringBuffer.append(s.charAt(i));
            }
        }

        for (int i = 0; i < times; i++) {
            sb.append(stringBuffer);
        }

        //对非嵌套型进行后续的拼配
        if (start < len - 1) {
            StringBuffer sb2 = new StringBuffer();
            sb.append(get(sb2,s,start,len));
        }
        return sb;
    }

}
