package offer;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/2/17 15:31
 * @description 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * 知识点：
 * 注意返回类型，return的一定是返回值的类型，这里必须返回StringBuffer.toString才是String类型
 * 判断char类型，注意是单引号''，String类型是双引号""
 * 更改某个char，用方法setCharAt方法，更改StringBuffer长度用setLength方法
 * --len的使用
 **/
public class ReplaceSpace {

    public static String replace(StringBuffer str) {
        if(str == null) {
            return null;
        }

        int count = 0;
        int len = str.length();
        for (int i = 0; i < len; i++) {
            if(str.charAt(i) == ' ') {
                count++;
            }
        }

        if(count == 0) {
            return str.toString();
        } else {
            str.setLength(len + 2 * count);
        }

        int newLen = str.length();

        //这里自带的replace方法可以直接从前往后替换
        while (len >= 0 && len < newLen){
            if(str.charAt(--len) != ' '){
                str.setCharAt(--newLen,str.charAt(len));
            } else{
                str.setCharAt(--newLen,'0');
                str.setCharAt(--newLen,'2');
                str.setCharAt(--newLen,'%');
            }
        }

        return str.toString();
    }

    public static void main(String[] args) {
        StringBuffer s = new StringBuffer("we are happy.");
        System.out.println(replace(s));
    }
}
